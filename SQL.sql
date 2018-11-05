DROP DATABASE WEB2;


CREATE DATABASE WEB2;


USE WEB2;



create table tb_usuario (
id_usuario serial primary key,
login_usuario varchar(50),
senha_usuario varchar(50),
nome_usuario varchar(100)
);

select * from tb_usuario;

insert into tb_usuario (login_usuario, senha_usuario, nome_usuario) values ('tiago', 'senha', 'Tiago');
insert into tb_usuario (login_usuario, senha_usuario, nome_usuario) values ('itay', 'senha', 'Itay');
insert into tb_usuario (login_usuario, senha_usuario, nome_usuario) values ('admin', 'admin', 'Administrador');


create table tb_estado (
id_estado serial primary key,
nome_estado varchar(100)
);

insert into tb_estado (id_estado, nome_estado) values (1, 'PR');
insert into tb_estado (id_estado, nome_estado) values (2, 'SP');
insert into tb_estado (id_estado, nome_estado) values (3, 'MG');

DROP TABLE tb_cidade;

create table tb_cidade (
	id_cidade serial primary key,
	nome_cidade varchar(100),
	id_estado integer
);

select * from tb_cidade;

insert into tb_cidade (id_cidade, nome_cidade, id_estado) values (1, 'Curitiba', 1);
insert into tb_cidade (id_cidade, nome_cidade, id_estado) values (2, 'Londrina', 1);
insert into tb_cidade (id_cidade, nome_cidade, id_estado) values (3, 'Maringá', 1);
insert into tb_cidade (id_cidade, nome_cidade, id_estado) values (4, 'São Paulo', 2);
insert into tb_cidade (id_cidade, nome_cidade, id_estado) values (5, 'São Carlos', 2);
insert into tb_cidade (id_cidade, nome_cidade, id_estado) values (6, 'Barretos', 2);
insert into tb_cidade (id_cidade, nome_cidade, id_estado) values (7, 'Ouro Preto', 3);
insert into tb_cidade (id_cidade, nome_cidade, id_estado) values (8, 'Belo Horizonte', 3);
insert into tb_cidade (id_cidade, nome_cidade, id_estado) values (9, 'Uberlândia', 3);


DROP table tb_cliente;


SELECT * FROM tb_cliente;

create table tb_cliente (
	id_cliente serial primary key,
	cpf_cliente varchar(100),
	nome_cliente varchar(100),
	email_cliente varchar(100),
	data_cliente date,
	rua_cliente varchar(100),
	nr_cliente integer,
	cep_cliente char(8),
	id_cidade integer,
	id_estado integer
);


insert into tb_cliente (nome_cliente, cpf_cliente, email_cliente, data_cliente, cep_cliente, rua_cliente, nr_cliente, id_cidade, id_estado) values (
'Tiago', '2456856', 'tiago@email.com.br', '1986-01-30', '52545548', 'Quadra QNN 5 Conjunto E', 745, 1, 1);

insert into tb_cliente (nome_cliente, cpf_cliente, email_cliente, data_cliente, cep_cliente, rua_cliente, nr_cliente, id_cidade, id_estado) values (
'Itay', '2456856', 'itay@email.com.br', '1986-01-30', '52545548', 'Quadra QNN 5 Conjunto E', 745, 2, 1);

insert into tb_cliente (nome_cliente, cpf_cliente, email_cliente, data_cliente, cep_cliente, rua_cliente, nr_cliente, id_cidade, id_estado) values (
'Herik', '2456856', 'herik@email.com.br', '1986-01-30', '52545548', 'Quadra QNN 5 Conjunto E', 745, 3, 1);

insert into tb_cliente (nome_cliente, cpf_cliente, email_cliente, data_cliente, cep_cliente, rua_cliente, nr_cliente, id_cidade, id_estado) values (
'Razer', '2456856', 'razer@email.com.br', '1986-01-30', '52545548', 'Quadra QNN 5 Conjunto E', 745, 4, 2);

insert into tb_cliente (nome_cliente, cpf_cliente, email_cliente, data_cliente, cep_cliente, rua_cliente, nr_cliente, id_cidade, id_estado) values (
'Rafaela', '2456856', 'rafaela@email.com.br', '1986-01-30', '52545548', 'Quadra QNN 5 Conjunto E', 745, 5, 2);

insert into tb_cliente (nome_cliente, cpf_cliente, email_cliente, data_cliente, cep_cliente, rua_cliente, nr_cliente, id_cidade, id_estado) values (
'Neves', '2456856', 'neves@email.com.br', '1986-01-30', '52545548', 'Quadra QNN 5 Conjunto E', 745, 6, 2);

insert into tb_cliente (nome_cliente, cpf_cliente, email_cliente, data_cliente, cep_cliente, rua_cliente, nr_cliente, id_cidade, id_estado) values (
'Sandramara', '2456856', 'sandramara@email.com.br', '1986-01-30', '52545548', 'Quadra QNN 5 Conjunto E', 745, 7, 3);

insert into tb_cliente (nome_cliente, cpf_cliente, email_cliente, data_cliente, cep_cliente, rua_cliente, nr_cliente, id_cidade, id_estado) values (
'Jerozina', '2456856', 'jeroniza@email.com.br', '1986-01-30', '52545548', 'Quadra QNN 5 Conjunto E', 745, 8, 3);

insert into tb_cliente (nome_cliente, cpf_cliente, email_cliente, data_cliente, cep_cliente, rua_cliente, nr_cliente, id_cidade, id_estado) values (
'Tommy', '2456856', 'tommy@email.com.br', '1986-01-30', '52545548', 'Quadra QNN 5 Conjunto E', 745, 9, 3);

insert into tb_cliente (nome_cliente, cpf_cliente, email_cliente, data_cliente, cep_cliente, rua_cliente, nr_cliente, id_cidade, id_estado) values (
'Claisa', '2456856', 'claisa@email.com.br', '1986-01-30', '52545548', 'Quadra QNN 5 Conjunto E', 745, 9, 3);

insert into tb_cliente (nome_cliente, cpf_cliente, email_cliente, data_cliente, cep_cliente, rua_cliente, nr_cliente, id_cidade, id_estado) values (
'Bianca', '2456856', 'bianca@email.com.br', '1986-01-30', '52545548', 'Quadra QNN 5 Conjunto E', 745, 9, 3);


SELECT tb_cliente.*, tb_cidade.nome_cidade as nome_cidade, tb_estado.nome_estado as nome_estado  FROM tb_cliente
                INNER JOIN tb_cidade ON(tb_cliente.id_cidade = tb_cidade.id_cidade)
                INNER JOIN tb_estado ON(tb_cidade.id_estado = tb_estado.id_estado)
				WHERE id_cliente = (2) LIMIT 1;
                 
create table tb_produto (
id_produto serial primary key,
nome_produto varchar(100)
);

insert into tb_produto (nome_produto) values ('Banana');
insert into tb_produto (nome_produto) values ('PC');
insert into tb_produto (nome_produto) values ('Garrafa pet');
insert into tb_produto (nome_produto) values ('Televisao');
insert into tb_produto (nome_produto) values ('Microfone');
insert into tb_produto (nome_produto) values ('Salsicha');
insert into tb_produto (nome_produto) values ('Abacate');
insert into tb_produto (nome_produto) values ('Morango');
insert into tb_produto (nome_produto) values ('Chocolate');
insert into tb_produto (nome_produto) values ('Batata');


create table tb_tipo_atendimento (
id_tipo_atendimento  serial primary key,
nome_tipo_atendimento varchar(50)
);

DROP table tb_tipo_atendimento;

insert into tb_tipo_atendimento (nome_tipo_atendimento) values ('reclamação');
insert into tb_tipo_atendimento (nome_tipo_atendimento) values ('dúvida');
insert into tb_tipo_atendimento (nome_tipo_atendimento) values ('sugestão');
insert into tb_tipo_atendimento (nome_tipo_atendimento) values ('elogio');


create table tb_atendimento (
id_atendimento  serial primary key,
dt_hr_atendimento DATETIME,
dsc_atendimento  varchar(250),
id_produto  BIGINT,
id_tipo_atendimento BIGINT,
id_usuario BIGINT,
id_cliente BIGINT,
res_atendimento varchar(1),
CHECK (res_atendimento='s' OR res_atendimento='S' OR res_atendimento='n' OR res_atendimento='N'),
FOREIGN KEY (id_produto) REFERENCES tb_produto(id_produto),
FOREIGN KEY (id_tipo_atendimento) REFERENCES tb_tipo_atendimento(id_tipo_atendimento),
FOREIGN KEY (id_usuario) REFERENCES tb_usuario(id_usuario),
FOREIGN KEY (id_cliente) REFERENCES tb_cliente(id_cliente)
);

DROP table tb_atendimento;

insert into tb_atendimento (dt_hr_atendimento, dsc_atendimento, id_produto, id_tipo_atendimento, id_usuario, id_cliente, res_atendimento)
values ('1986-01-30', 'desc', 1, 1, 1, 1, 's');

select * from tb_atendimento;