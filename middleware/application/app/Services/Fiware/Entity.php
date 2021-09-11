<?php

namespace App\Services\Fiware;

use App\Models;
use Illuminate\Support\Facades\Http;

class Entity extends FiwareAbstractService
{
    public function create(Models\Movie $movie)
    {
        $url = $this->baseUrl . '/entities';

        return Http::post($url, [
            "id" => 'movie-' . $movie->id,
            "type" => "movie",
            "name" => [
                "type" => "text",
                "value" => $movie->name,
            ],
            "gender" => [
                "type" => "text",
                "value" => $movie->gender->name,
            ],
            "notify_at" => [
                "type" => "date",
                "value" => $movie->date_of_notification,
            ]
        ]);
    }
}
