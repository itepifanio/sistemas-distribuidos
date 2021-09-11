<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class FiwareSubscription extends Model
{
    use HasFactory;

    protected $fillable = [
        'title',
        'description',
        'movie_id',
        'movie_gender',
        'subscription_id',
        'date_of_notification',
        'sent',
    ];

    protected $dates = [
        'date_of_notification',
    ];
}
