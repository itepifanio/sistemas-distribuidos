<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

class CreateFiwareSubscriptionsTable extends Migration
{
    public function up()
    {
        Schema::create('fiware_subscriptions', function (Blueprint $table) {
            $table->id();
            $table->string('title');
            $table->text('description')->nullable();
            $table->string('movie_gender');
            $table->string('subscription_id');
            $table->string('movie_id')->unique();
            $table->dateTime('date_of_notification');
            $table->boolean('sent')->default(false);
            $table->timestamps();
        });
    }

    public function down()
    {
        Schema::dropIfExists('subscriptions');
    }
}
