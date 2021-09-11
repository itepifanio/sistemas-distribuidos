<?php

namespace Database\Seeders;

use App\Models\Gender;
use Illuminate\Database\Seeder;

class GenderSeeder extends Seeder
{
    public function run()
    {
        $genders = $this->genders();

        foreach ($genders as $gender) {
            Gender::create($gender);
        }
    }

    protected function genders(): array
    {
        return [
            ['name' => 'drama'],
            ['name' => 'romance'],
            ['name' => 'policial'],
            ['name' => 'suspense'],
            ['name' => 'faroeste'],
        ];
    }
}
