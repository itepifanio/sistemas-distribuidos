<?php

namespace App\Http\Livewire\Viewer;

use Exception;
use App\Services\Fiware;
use App\Models\Gender;
use App\Models\Subscription;
use Illuminate\Database\Eloquent\Collection;
use Illuminate\Support\Facades\DB;
use Livewire\Component;

class Subscribe extends Component
{
    public Subscription $subscription;

    public function mount()
    {
        $this->initSubscription();
    }

    public function getRules()
    {
        return [
            'subscription.user_id'   => ['required'],
            'subscription.gender_id' => ['required'],
        ];
    }

    public function save(Fiware\Subscription $service)
    {
        $this->validate();

        DB::beginTransaction();

        try {
            $this->subscription->save();

            $service->subscribe($this->subscription);

            DB::commit();
        } catch (Exception $e) {
            dd($e); // I will not handle this

            DB::rollBack();
        }

        $this->emit('subscribe::saved');
    }

    public function getGendersProperty(): Collection
    {
        return Gender::all();
    }

    protected function initSubscription(): void
    {
        $this->subscription = new Subscription([
           'user_id' => auth()->user()->id,
        ]);
    }
}
