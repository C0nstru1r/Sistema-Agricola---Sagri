
-- Arquivo para inicializar o banco de dados
-- Insere alguns dados padrões nas tabelas

-- Inserindo categorias de produtos
INSERT INTO categorias (id, nome) VALUES (1, 'Categoria A');
INSERT INTO categorias (id, nome) VALUES (2, 'Categoria B');

-- Inserindo unidades de medida
INSERT INTO unidades (id, nome, quantidade_por_unidade) VALUES (1, 'Saco', 50);
INSERT INTO unidades (id, nome, quantidade_por_unidade) VALUES (2, 'Saco', 60);

-- Inserindo alguns produtos
INSERT INTO produtos (id, codigo, descricao, preco_custo, preco_venda, unidade_id, categoria_id) 
VALUES (1, 'P001', 'Produto Exemplo 1', 10.00, 20.00, 1, 1);

INSERT INTO produtos (id, codigo, descricao, preco_custo, preco_venda, unidade_id, categoria_id) 
VALUES (2, 'P002', 'Produto Exemplo 2', 15.00, 30.00, 2, 2);
