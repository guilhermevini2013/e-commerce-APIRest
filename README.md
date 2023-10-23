# e-commerce-APIRest
e-commerce-APIRest
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Documentação da API de E-commerce</title>
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

  <!-- Continue a documentação dos outros endpoints de categorias seguindo o mesmo padrão -->

  <h2>Endpoints de Produtos</h2>

  <!-- Documente os endpoints de produtos seguindo o mesmo padrão como feito para categorias -->

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
Depois de criar essa estrutura HTML, você pode copiá-la e colá-la em seu README no GitHub. Lembre-se de que você pode personalizar o estilo e a formatação usando CSS, se desejar. Certifique-se de manter a estrutura e o conteúdo atualizados à medida que sua API evolui e adquire mais recursos.





