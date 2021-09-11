<?php

namespace App\Http\Livewire\Channel;

use App\Models\Gender;
use App\Models\Movie;
use App\Services\Fiware;
use Exception;
use Illuminate\Database\Eloquent\Collection;
use Livewire\Component;

class CreateMovie extends Component
{
    public Movie $movie;

    public function mount()
    {
        $this->initMovie();
    }

    protected function getRules()
    {
        return [
            'movie.name' => ['required', 'max:255'],
            'movie.description' => ['nullable'],
            'movie.date_of_notification' => ['required', 'date'],
            'movie.gender_id' => ['required', 'exists:genders,id'],
            'movie.channel_id' => ['required', 'exists:users,id'],
        ];
    }

    public function getGenresProperty(): Collection
    {
        return Gender::all();
    }

    public function save(Fiware\Entity $service): void
    {
        $this->validate();

        try {
            $this->movie->save();

            $service->create($this->movie);

            $this->emit('create-movie::saved');

            $this->initMovie();
        } catch (Exception $e) {
            dd($e); // I'll not handle this right now
        }
    }

    protected function initMovie(): void
    {
        $this->movie = new Movie([
            'channel_id' => auth()->user()->id,
        ]);
    }
}
