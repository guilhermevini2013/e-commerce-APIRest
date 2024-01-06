INSERT INTO categories (name) VALUES ('Livros');
INSERT INTO categories (name) VALUES ('Eletrônicos');
INSERT INTO categories (name) VALUES ('Computadores');

INSERT INTO product (name, price, description, img_url) VALUES ('Computador Gamer',550,'deste','https://exitocol.vtexassets.com/arquivos/ids/5347301/computador-de-escritorio-gamer-navinox-ryzen-5-3600-ssd-m2-512gb-ram-16gb-xpg.jpg?v=637438626358370000');
insert into tb_product_category(product_id,category_id) values (1,2);
insert into tb_product_category(product_id,category_id) values (1,3);

INSERT INTO product (name, price, description, img_url) VALUES ('Computador Gamer',610,'deste','https://a-static.mlcdn.com.br/800x560/pc-gamer-completo-intel-core-i5-8gb-nvidia-geforce-gt-hd-500gb-monitor-21-5-full-hd-kit-gamer-easypc-light/3greentechnology/24867/efbe26479ca93bb4a2a4c9f5d400ca54.jpeg');
insert into tb_product_category(product_id,category_id) values (2,2);
insert into tb_product_category(product_id,category_id) values (2,3);


INSERT INTO product (name, price, description, img_url) VALUES ('Priorize Deus',10,'deste','https://http2.mlstatic.com/D_NQ_NP_827380-MLB72604027945_102023-O.webp');
insert into tb_product_category(product_id,category_id) values (3,1);