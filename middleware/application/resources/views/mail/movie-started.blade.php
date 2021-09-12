@component('mail::message')
# O Filme Começou!

O filme **{{ $subscription->title }}** acabou de começar!

Você está vendo essa notificação porque está inscrito para visualizar todos os filme do gênero **{{ $subscription->movie_gender }}**.
@endcomponent
