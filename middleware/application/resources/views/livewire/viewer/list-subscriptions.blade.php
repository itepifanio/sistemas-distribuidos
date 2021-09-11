<x-table>
    <x-slot name="thead">
        <tr>
            <th scope="col" class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">
                Nome
            </th>
            <th scope="col" class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">
                Data da Inscrição
            </th>
            <th scope="col" class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">
                Opções
            </th>
        </tr>
    </x-slot>
    <div>
        @foreach($this->subscriptions as $index => $subscription)
            <tr class="{{ $index % 2 == 0 ? 'bg-white' : 'bg-gray-50' }}">
                <td class="px-6 py-4 whitespace-nowrap text-sm font-medium text-gray-900">
                    {{ $subscription->gender->name }}
                </td>
                <td class="px-6 py-4 whitespace-nowrap text-sm text-gray-500">
                    {{ $subscription->created_at->diffForHumans() }}
                </td>
                <td class="px-6 py-4 whitespace-nowrap text-sm text-gray-500">

                </td>
            </tr>
        @endforeach
    </div>
</x-table>
