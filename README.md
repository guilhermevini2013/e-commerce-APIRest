Documentação da API de E-commerce
Introdução
Esta API de E-commerce oferece funcionalidades de gerenciamento de categorias e produtos. Ela permite a criação, leitura, atualização e exclusão (CRUD) de categorias e produtos, além de permitir a associação de produtos a categorias.

Endpoints de Categorias
Listar Categorias
Retorna uma lista de categorias paginada.

URL: GET /categories
Parâmetros de consulta:
page (opcional): Número da página (padrão: 0).
linesPerPage (opcional): Número de categorias por página (padrão: 15).
direction (opcional): Direção da ordenação (ASC ou DESC, padrão: ASC).
orderBy (opcional): Campo para ordenação (padrão: "id").
Buscar Categoria por ID
Retorna uma categoria específica com base no ID fornecido.

URL: GET /categories/{id}
Parâmetros de URL:
id (obrigatório): ID da categoria que deseja buscar.
Inserir Categoria
Cria uma nova categoria.

URL: POST /categories
Corpo da solicitação (JSON):
name (obrigatório): Nome da categoria.
Atualizar Categoria
Atualiza uma categoria existente com base no ID fornecido.

URL: PUT /categories/{id}
Parâmetros de URL:
id (obrigatório): ID da categoria que deseja atualizar.
Corpo da solicitação (JSON):
name (obrigatório): Nome atualizado da categoria.
Excluir Categoria
Exclui uma categoria com base no ID fornecido.

URL: DELETE /categories/{id}
Parâmetros de URL:
id (obrigatório): ID da categoria que deseja excluir.
Endpoints de Produtos
Listar Produtos
Retorna uma lista de produtos paginada.

URL: GET /products
Parâmetros de consulta:
page (opcional): Número da página (padrão: 0).
linesPerPage (opcional): Número de produtos por página (padrão: 15).
direction (opcional): Direção da ordenação (ASC ou DESC, padrão: ASC).
orderBy (opcional): Campo para ordenação (padrão: "id").
Buscar Produto por ID
Retorna um produto específico com base no ID fornecido.

URL: GET /products/{id}
Parâmetros de URL:
id (obrigatório): ID do produto que deseja buscar.
Inserir Produto
Cria um novo produto.

URL: POST /products
Corpo da solicitação (JSON):
name (obrigatório): Nome do produto.
description (opcional): Descrição do produto.
price (obrigatório): Preço do produto.
categoryId (obrigatório): ID da categoria à qual o produto pertence.
Atualizar Produto
Atualiza um produto existente com base no ID fornecido.

URL: PUT /products/{id}
Parâmetros de URL:
id (obrigatório): ID do produto que deseja atualizar.
Corpo da solicitação (JSON):
name (opcional): Nome atualizado do produto.
description (opcional): Descrição atualizada do produto.
price (opcional): Preço atualizado do produto.
categoryId (opcional): ID da categoria à qual o produto pertence (opcional).
Excluir Produto
Exclui um produto com base no ID fornecido.

URL: DELETE /products/{id}
Parâmetros de URL:
id (obrigatório): ID do produto que deseja excluir.
Status de Resposta
200 OK: A solicitação foi bem-sucedida.
201 Created: A solicitação de criação foi bem-sucedida.
204 No Content: A solicitação de exclusão foi bem-sucedida.
400 Bad Request: A solicitação possui parâmetros inválidos ou ausentes.
404 Not Found: O recurso solicitado não foi encontrado.
500 Internal Server Error: Erro interno do servidor.





