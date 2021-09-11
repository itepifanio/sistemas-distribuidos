<?php

namespace Database\Seeders;

use App\Models\User;
use Illuminate\Database\Seeder;
use Illuminate\Support\Facades\Hash;

class UserSeeder extends Seeder
{
    public function run()
    {
        $users = $this->getUsers();

        foreach ($users as $user) {
            User::create($user);
        }
    }

    protected function getUsers(): array
    {
        $password = 'password';

        return [
            [
                'name' => 'canal',
                'email' => 'user@gmail.com',
                'type' => User::TYPE_VIEWER,
                'password' => Hash::make($password),
            ],
            [
                'name' => 'canal',
                'email' => 'canal@gmail.com',
                'type' => User::TYPE_CHANNEL,
                'password' => Hash::make($password),
            ]
        ];
    }
}
