<x-card class="flex flex-col p-4 items-end justify-between space-y-2">
    <div class="w-full">
        <x-input id="titulo" type="text" class="w-full" label="Título" wire:model="movie.name"></x-input>
    </div>

    <div class="w-full">
        <x-textarea id="descricao" label="Descrição" wire:model="movie.description"></x-textarea>
    </div>

    <div class="w-full">
        <x-input id="date-notification" type="text" class="w-full" label="Data de Exibição" wire:model="movie.date_of_notification"></x-input>
        <div class="text-xs border-l-2 border-yellow-400 text-gray-600 mt-1">
            <span class="ml-1">Esse campo deve ter o formato YYYY-MM-DD HH:MM</span>
        </div>
    </div>

    <div class="w-full">
        <x-select wire:model="movie.gender_id" id="genre" name="genre" label="Genero">
            <option></option>
            @foreach($this->genres as $genre)
                <option value="{{ $genre->id }}">{{ $genre->name }}</option>
            @endforeach
        </x-select>
    </div>

    <x-button wire:click="save">
        Salvar
    </x-button>
</x-card>
