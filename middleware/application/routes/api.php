<?php

use Illuminate\Http\Request;
use Illuminate\Support\Facades\Route;

/*
|--------------------------------------------------------------------------
| API Routes
|--------------------------------------------------------------------------
|
| Here is where you can register API routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| is assigned the "api" middleware group. Enjoy building your API!
|
*/

Route::middleware('auth:sanctum')->get('/user', function (Request $request) {
    return $request->user();
});

Route::post('notifications', function () {
    \Illuminate\Support\Facades\Log::info('hue');
   \Illuminate\Support\Facades\Log::info(json_encode(request()->all()));

   return response()->json(['success' => 'success']);
});
