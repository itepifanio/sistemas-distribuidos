@props([
    'disabled' => false,
    'label'    => null,
])

<div>
    @if($label)
        <label class="block text-sm font-medium text-gray-700">{{ $label }}</label>
    @endif
    <input {{ $disabled ? 'disabled' : '' }} {!! $attributes->merge(['class' => 'rounded-md shadow-sm border-gray-300 focus:border-indigo-300 focus:ring focus:ring-indigo-200 focus:ring-opacity-50']) !!}>
</div>
