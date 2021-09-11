<?php

namespace App\Services\Fiware;

use App\Models;
use Illuminate\Support\Facades\Http;

class Subscription extends FiwareAbstractService
{
    public function subscribe(Models\Subscription $subscription): void
    {
        $url = $this->baseUrl . '/subscriptions';

        Http::post($url, [
            "description" => "Notify user {$subscription->user->id} about any movie of gender {$subscription->gender->name}",
            "subject" => [
                "entities" => [[
                    "idPattern" => ".*",
                    "type" => "movie"
                ]
                ],
                "condition" => [
                    "attrs" => ["gender"],
                    "expression" => [
                        "q" => "gender=={$subscription->gender->name}"
                    ],
                ]
            ],
            "notification" => [
                "http" => [
                    "url" => config('app.url') . "/api/notifications" // FIWARE will notify this application using this endpoint
                ]
            ]
        ]);
    }
}
