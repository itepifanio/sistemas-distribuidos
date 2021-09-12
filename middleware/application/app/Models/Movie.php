<?php

namespace App\Models;

use Illuminate\Broadcasting\Channel;
use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;
use Illuminate\Database\Eloquent\Relations\BelongsTo;

class Movie extends Model
{
    use HasFactory;

    protected $fillable = [
        'name',
        'description',
        'gender_id',
        'channel_id',
        'date_of_notification',
    ];

    public function gender(): BelongsTo
    {
        return $this->belongsTo(Gender::class);
    }

    public function channel(): BelongsTo
    {
        return $this->belongsTo(Channel::class);
    }
}
