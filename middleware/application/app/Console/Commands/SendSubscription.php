<?php

namespace App\Console\Commands;

use App\Mail\MovieStarted;
use App\Models\FiwareSubscription;
use Illuminate\Console\Command;
use Illuminate\Notifications\Messages\MailMessage;
use Illuminate\Support\Facades\Mail;

class SendSubscription extends Command
{
    protected $signature = 'send:subscriptions';

    protected $description = 'Send notification to users subscribed.';

    public function handle()
    {
        $query = FiwareSubscription::where('date_of_notification', '<', now())
            ->whereSent(false);

        $subscriptions = (clone $query)->get();

        foreach ($subscriptions as $subscription) {
            Mail::to(env('MAIL_FROM_ADDRESS'))->send(new MovieStarted($subscription));
        }

        (clone $query)->update(['sent' => true]);

        return 0;
    }
}
