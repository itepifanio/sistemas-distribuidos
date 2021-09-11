<?php

namespace App\Http\Livewire\Viewer;

use App\Models\Subscription;
use Illuminate\Database\Eloquent\Collection;
use Livewire\Component;

class ListSubscriptions extends Component
{
    protected $listeners = [
        'subscribe::saved' => '$refresh',
    ];

    public function getSubscriptionsProperty(): Collection
    {
        return Subscription::query()
            ->where('user_id', auth()->user()->id)
            ->get();
    }

    public function render()
    {
        return view('livewire.viewer.list-subscriptions');
    }
}
