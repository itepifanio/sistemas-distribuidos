### GingaJ

Aplicação que recebe as notificações do FIWARE.

- [x] Canal adicionar um filme
- [x] Usuário se subscrever a gêneros de filme
- [x] Schedule enviar dados para o email do usuário de acordo com suas subscrições
- [] Usuário remover subscrição
- [] Fix typo 'gender' to 'genre'

### Instalação

- Execute `docker-compose up` para executar o FIWARE
- Accesse a aplicação web `cd application`
- Crie um arquivo `.env` a partir do arquivo ` .env.example `: ` cp .env.example .env `
- Adicione as informações de email no arquivo ` .env `
- Crie um banco de dados MySQL
- Adicione as informações do banco de dados ao arquivo ` .env `
- Execute ` php artisan migrate:fresh --seed ` para criar as tabelas do sistema
- Execute ` npm install && npm run dev ` para compilar o javascript
- Execute ` php artisan serve ` para executar o servidor
- Execute ` php artisan schedule:work ` para executar o schedule de notificações

Por padrão 2 usuários foram criados previamente no sistema, um do tipo canal e outro do tipo telespectador.
Para acessa-los basta utilizar os emails canal@gmail.com ou user@gmail.com com a senha password. 
