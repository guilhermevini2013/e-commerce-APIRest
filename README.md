<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Documentação da API de E-commerce</title>
  <style>
    body {
      font-family: Arial, sans-serif;
    }
    h1, h2, h3 {
      color: #333;
    }
    p {
      color: #666;
    }
    ul {
      list-style: disc;
      margin-left: 20px;
    }
    code {
      background-color: #f0f0f0;
      padding: 2px 4px;
      border: 1px solid #ccc;
    }
  </style>
</head>
<body>
  <h1>Documentação da API de E-commerce</h1>

  <h2>Introdução</h2>
  <p>Esta API de E-commerce oferece funcionalidades de gerenciamento de categorias e produtos. Ela permite a criação, leitura, atualização e exclusão (CRUD) de categorias e produtos, além de permitir a associação de produtos a categorias.</p>

  <h2>Endpoints de Categorias</h2>
  
  <h3>Listar Categorias</h3>
  <p><strong>URL:</strong> <code>GET /categories</code></p>
  <p><strong>Parâmetros de consulta:</strong></p>
  <ul>
    <li><code>page</code> (opcional): Número da página (padrão: 0).</li>
    <li><code>linesPerPage</code> (opcional): Número de categorias por página (padrão: 15).</li>
    <li><code>direction</code> (opcional): Direção da ordenação (ASC ou DESC, padrão: ASC).</li>
    <li><code>orderBy</code> (opcional): Campo para ordenação (padrão: "id").</li>
  </ul>

  <h3>Buscar Categoria por ID</h3>
  <p><strong>URL:</strong> <code>GET /categories/{id}</code></p>
  <p><strong>Parâmetros de URL:</strong></p>
  <ul>
    <li><code>id</code> (obrigatório): ID da categoria que deseja buscar.</li>
  </ul>

  <h3>Inserir Categoria</h3>
  <p><strong>URL:</strong> <code>POST /categories</code></p>
  <p><strong>Corpo da solicitação (JSON):</strong></p>
  <pre>
{
  "name": "Nome da Categoria"
}
  </pre>

  <h3>Atualizar Categoria</h3>
  <p><strong>URL:</strong> <code>PUT /categories/{id}</code></p>
  <p><strong>Parâmetros de URL:</strong></p>
  <ul>
    <li><code>id</code> (obrigatório): ID da categoria que deseja atualizar.</li>
  </ul>
  <p><strong>Corpo da solicitação (JSON):</strong></p>
  <pre>
{
  "name": "Novo Nome da Categoria"
}
  </pre>

  <h3>Excluir Categoria</h3>
  <p><strong>URL:</strong> <code>DELETE /categories/{id}</code></p>
  <p><strong>Parâmetros de URL:</strong></p>
  <ul>
    <li><code>id</code> (obrigatório): ID da categoria que deseja excluir.</li>
  </ul>

  <h2>Endpoints de Produtos</h2>

<h3>Listar Produtos</h3>
<p><strong>URL:</strong> <code>GET /products</code></p>
<p><strong>Parâmetros de consulta:</strong></p>
<ul>
  <li><code>page</code> (opcional): Número da página (padrão: 0).</li>
  <li><code>linesPerPage</code> (opcional): Número de produtos por página (padrão: 15).</li>
  <li><code>direction</code> (opcional): Direção da ordenação (ASC ou DESC, padrão: ASC).</li>
  <li><code>orderBy</code> (opcional): Campo para ordenação (padrão: "id").</li>
</ul>

<h3>Buscar Produto por ID</h3>
<p><strong>URL:</strong> <code>GET /products/{id}</code></p>
<p><strong>Parâmetros de URL:</strong></p>
<ul>
  <li><code>id</code> (obrigatório): ID do produto que deseja buscar.</li>
</ul>

<h3>Inserir Produto</h3>
<p><strong>URL:</strong> <code>POST /products</code></p>
<p><strong>Corpo da solicitação (JSON):</strong></p>
<pre>
{
  {
  "name": "PS5",
  "description": "The new generation PS5 video game",
  "price": 600.0,
  "imgUrl": "",
  "categories": [
    {
      "id": 3
    }
  ]
}
}
</pre>

<h3>Atualizar Produto</h3>
<p><strong>URL:</strong> <code>PUT /products/{id}</code></p>
<p><strong>Parâmetros de URL:</strong></p>
<ul>
  <li><code>id</code> (obrigatório): ID do produto que deseja atualizar.</li>
</ul>
<p><strong>Corpo da solicitação (JSON):</strong></p>
<pre>
{
  {
  "name": "Novo nome do Produto"(opcional),
  "description": "Nova descricao"(opcional),
  "price": 600.0,
  "imgUrl": "" (opcional),
  "categories": [
    {
      "id": 3 (opcional)
    }
  ]
}
}
</pre>

<h3>Excluir Produto</h3>
<p><strong>URL:</strong> <code>DELETE /products/{id}</code></p>
<p><strong>Parâmetros de URL:</strong></p>
<ul>
  <li><code>id</code> (obrigatório): ID do produto que deseja excluir.</li>
</ul>

  <h2>Status de Resposta</h2>
  <ul>
    <li><code>200 OK</code>: A solicitação foi bem-sucedida.</li>
    <li><code>201 Created</code>: A solicitação de criação foi bem-sucedida.</li>
    <li><code>204 No Content</code>: A solicitação de exclusão foi bem-sucedida.</li>
    <li><code>400 Bad Request</code>: A solicitação possui parâmetros inválidos ou ausentes.</li>
    <li><code>404 Not Found</code>: O recurso solicitado não foi encontrado.</li>
    <li><code>500 Internal Server Error</code>: Erro interno do servidor.</li>
  </ul>
  
  <!-- Adicione outras informações necessárias -->

</body>
</html>




