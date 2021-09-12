<?php

namespace App\Services\Fiware;

abstract class FiwareAbstractService
{
    public string $baseUrl;

    public function __construct()
    {
        $this->baseUrl = config('services.fiware.host') . '/v2';
    }
}
