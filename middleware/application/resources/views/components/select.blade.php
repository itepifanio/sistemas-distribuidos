@props([
    'id',
    'label' => null,
])

<div>
    @if($label)
        <label class="block text-sm font-medium text-gray-700">{{ $label }}</label>
    @endif

    <select class="mt-1 block w-full pl-3 pr-10 py-2 text-base border-gray-300 focus:outline-none focus:ring-indigo-500 focus:border-indigo-500 sm:text-sm rounded-md" {{ $attributes }}>
        {{ $slot }}
    </select>
</div>
