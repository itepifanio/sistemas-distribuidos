<?php

namespace App\Http\Controllers;

use App\Models\FiwareSubscription;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Log;

class NotificationController extends Controller
{
    public function __invoke(Request $request)
    {
        FiwareSubscription::query()->upsert(
            $this->mapMoviesData($request->subscriptionId, $request->data),
            ['movie_id', 'movie_title']
        );

        return response()->json([
           'success' => 'Movies created/updated with success.',
        ]);
    }

    protected function mapMoviesData(string $subscriptionId, array $movies): array
    {
        $result = [];

        foreach ($movies as $movie) {
            Log::info(json_encode($movie));

            $result[] = [
                'title' => data_get($movie, 'name.value'),
                'description' => data_get($movie, 'name.description'),
                'movie_id' => data_get($movie, 'id'),
                'movie_gender' => data_get($movie, 'gender.value'),
                'subscription_id' => $subscriptionId,
                'date_of_notification' => data_get($movie, 'notify_at.value')
            ];
        }

        return $result;
    }
}
