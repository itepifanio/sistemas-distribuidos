<x-app-layout>
    <x-slot name="header">
        <h2 class="font-semibold text-xl text-gray-800 leading-tight">
            {{ __('Dashboard') }}
        </h2>
    </x-slot>

    <div class="py-8">
        <div class="max-w-8xl mx-auto sm:px-6 lg:px-8  space-y-4">
            <livewire:viewer.subscribe/>

            <livewire:viewer.list-subscriptions/>
        </div>
    </div>
</x-app-layout>
