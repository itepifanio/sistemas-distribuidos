@props([
'id',
'label' => null,
])
<div>
    @if($label)
        <label class="block text-sm font-medium text-gray-700">{{ $label }}</label>
    @endif
    <textarea {{ $attributes }} rows="3"
              class="shadow-sm block w-full
                focus:ring-indigo-500 focus:border-indigo-500
                sm:text-sm border border-gray-300 rounded-md">{{ $slot }}</textarea>
</div>
