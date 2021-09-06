@component('mail::message')
    # Movie Started

    The movie {{ $subscription->title }} it's starting now!

    You're seeing this notification because you're subscribed to the gender {{ $subscription->movie_gender }}
@endcomponent
