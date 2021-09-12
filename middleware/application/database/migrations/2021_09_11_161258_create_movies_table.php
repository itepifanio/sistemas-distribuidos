<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

class CreateMoviesTable extends Migration
{
    public function up()
    {
        Schema::create('movies', function (Blueprint $table) {
            $table->id();
            $table->string('name');
            $table->text('description')->nullable();
            $table->dateTime('date_of_notification');

            $table->foreignId('gender_id')
                ->references('id')
                ->on('genders')
                ->cascadeOnDelete();

            // workaround for time limitation the channel will never be a user
            $table->foreignId('channel_id')
                ->references('id')
                ->on('users')
                ->cascadeOnDelete();

            $table->timestamps();
        });
    }

    public function down()
    {
        Schema::dropIfExists('movies');
    }
}
