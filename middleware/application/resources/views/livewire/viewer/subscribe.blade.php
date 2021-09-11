<x-card class="flex flex-row p-4 items-end justify-between">
    <x-select wire:model="subscription.gender_id" id="gender" name="gender" label="Genero">
        <option></option>
        @foreach($this->genders as $gender)
            <option value="{{ $gender->id }}">{{ $gender->name }}</option>
        @endforeach
    </x-select>

    <x-button wire:click="save">
        Salvar
    </x-button>
</x-card>
