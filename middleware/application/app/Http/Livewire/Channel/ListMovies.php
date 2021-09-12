<?php

namespace App\Http\Livewire\Channel;

use App\Models\Movie;
use Illuminate\Database\Eloquent\Collection;
use Livewire\Component;

class ListMovies extends Component
{
    protected $listeners = [
        'create-movie::saved' => '$refresh',
    ];

    public function getMoviesProperty(): Collection
    {
        return Movie::query()
            ->where('channel_id', auth()->user()->id)
            ->get();
    }

    public function render()
    {
        return view('livewire.channel.list-movies');
    }
}
