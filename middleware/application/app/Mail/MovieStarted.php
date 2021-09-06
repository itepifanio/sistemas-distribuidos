<?php

namespace App\Mail;

use App\Models\Subscription;
use Illuminate\Bus\Queueable;
use Illuminate\Mail\Mailable;
use Illuminate\Queue\SerializesModels;

class MovieStarted extends Mailable
{
    use Queueable, SerializesModels;

    protected $subscription;

    public function __construct(Subscription $subscription)
    {
        $this->subscription = $subscription;
    }

    public function build()
    {
        return $this->markdown('mail.movie-started', [
            'subscription' => $this->subscription,
        ]);
    }
}
