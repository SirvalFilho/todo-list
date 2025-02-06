<h1 align="center" style="font-weight: bold;">API de Gerenciamento de Tarefas 💻</h1>

<p align="center">
 <a href="#technologies">Tecnologias</a> • 
 <a href="#started">Como Começar</a> • 
  <a href="#routes">Endpoints da API</a> •
 <a href="#contribute">Contribuir</a>
</p>

<p align="center">
    <b>Uma API simples para gerenciar tarefas, permitindo operações CRUD para criar, ler, atualizar e excluir tarefas.</b>
</p>

<h2 id="technologies">💻 Tecnologias</h2>

- Spring Boot
- Java
- PostgreSQL

<h2 id="started">🚀 Como Começar</h2>

Para rodar esse projeto localmente, siga os passos abaixo.

<h3>Pré-requisitos</h3>

Certifique-se de ter os seguintes pré-requisitos instalados:

- [Java 17](https://adoptium.net/)
- [Maven](https://maven.apache.org/)
- [PostgreSQL](https://www.postgresql.org/download/)

<h3>Clonando</h3>

Clone o repositório do projeto:

```bash
git clone https://github.com/SirvalFilho/todo-list.git
```
<h3>Configurações</h2>
Certifique-se de configurar sua conexão com o PostgreSQL no arquivo aplication.properties :

```yaml
spring.datasource.url=jdbc:postgresql://localhost:5432/seu_banco_de_dados
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
```
<h3>Rodando o projeto</h3>
Acesse o diretório do projeto e execute a aplicação:

```bash
cd todo-list
mvn spring-boot:run
```
<h2 id="routes">📍 Endpoints da API</h2>
Aqui estão os principais endpoints para gerenciar tarefas:

| rotas               | descrição                                          
|----------------------|-----------------------------------------------------
| <kbd>GET /api/tasks</kbd>     | Retorna todas as tarefas 
| <kbd>POST /api/tasks/add</kbd>     | Adiciona uma nova tarefa
| <kbd>PUT /api/tasks/update/{id}</kbd>     | Atualiza uma tarefa existente
| <kbd>DELETE /api/tasks/delete/{id}</kbd>     | Exclui uma tarefa

<h3 id="get-all-tasks">GET /api/tasks</h3>
RESPOSTA

```json
[
  {
    "id": 1,
    "title": "Terminar dever de casa",
    "description": "Completar o exercício de matemática",
    "completed": false,
    "dueDate": "2025-02-05"
  },
  {
    "id": 2,
    "title": "Comprar mantimentos",
    "description": "Comprar mantimentos para a semana",
    "completed": true,
    "dueDate": "2025-02-06"
  }
]
```
<h3 id="post-add-task">POST /api/tasks/add</h3>
REQUISIÇÃO

```json
{
  "title": "Limpar a casa",
  "description": "Passar o aspirador e limpar o chão",
  "completed": false,
  "dueDate": "2025-02-10"
}
```
RESPOSTA

```json
[
  {
    "id": 1,
    "title": "Terminar dever de casa",
    "description": "Completar o exercício de matemática",
    "completed": false,
    "dueDate": "2025-02-05"
  },
  {
    "id": 2,
    "title": "Comprar mantimentos",
    "description": "Comprar mantimentos para a semana",
    "completed": true,
    "dueDate": "2025-02-06"
  },
  {
    "id": 3,
    "title": "Limpar a casa",
    "description": "Passar o aspirador e limpar o chão",
    "completed": false,
    "dueDate": "2025-02-10"
  }
]
```
<h3 id="put-update-task">PUT /api/tasks/update/{id}</h3>
REQUISIÇÃO

```json
{
  "title": "Comprar mantimentos",
  "description": "Comprar mantimentos e lanches para o fim de semana",
  "completed": true,
  "dueDate": "2025-02-07"
}
```
RESPOSTA

```json
{
  "id": 2,
  "title": "Comprar mantimentos",
  "description": "Comprar mantimentos e lanches para o fim de semana",
  "completed": true,
  "dueDate": "2025-02-07"
}
```
<h3 id="delete-task">DELETE /api/tasks/delete/{id}</h3>
RESPOSTA

```json
[
  {
    "id": 1,
    "title": "Terminar dever de casa",
    "description": "Completar o exercício de matemática",
    "completed": false,
    "dueDate": "2025-02-05"
  },
  {
    "id": 2,
    "title": "Comprar mantimentos",
    "description": "Comprar mantimentos para a semana",
    "completed": true,
    "dueDate": "2025-02-06"
  }
]
```
Para contribuir com esse projeto:

1. Faça um fork do repositório.
2. Crie uma nova branch   `git checkout -b feature/sua-feature`.
3. Faça suas alterações.
4. Commit suas alterações `git commit -am 'Adicionar nova feature'`.
5. Envie para a branch    `git push origin feature/sua-feature`.
6. Abra um Pull Request.

