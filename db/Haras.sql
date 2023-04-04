drop database if exists Haras;
create database Haras;
use Haras;

create table Usuarios (
	id int primary key auto_increment,
    nome varchar(255),
    nome_usuario varchar(30) unique,
    senha varchar(30)
);

insert into Usuarios (nome, nome_usuario, senha) values (
	"Administrador",
	"admin",
    "admin"
);

create table Clientes (
	id int primary key auto_increment,
    nome varchar(255) not null,
    telefone varchar(20),
    email varchar(60) unique,
    documento varchar(60) not null,
	endereco varchar(255)
);

insert into Clientes (nome, telefone, email, documento, endereco) values (
	"João da Silva",
    "5515998767456",
    "joao.da.silva@email.com",
    "38746589234",
    "Rua Geraldo, 123"
),
(
	"Pedro Mendonça",
    "5576384637484",
    "pedro.mendonca@email.com",
    "638929873784",
    "Rua Bartolomeu, 456"
),
(
	"Carlos Ortega",
    "9828874839982",
    "carlos.ortega@email.com",
    "9837487892395233425",
    "Rua Benicio, 321"
),
(
	"Manoel Juarez",
    "837485661123",
    "manoel.juarez@email.com",
    "932874838298",
    "Rua Osvaldo, 654"
);

create table Cavalos (
	registro int primary key auto_increment,
    nome varchar(60) not null,
    pelagem varchar(60) not null,
    sexo varchar(5) not null,
    axame_aie varchar(3) not null,
    axame_mormo varchar(3) not null,
    gta varchar(3)
);

insert into Cavalos (nome, pelagem, sexo, axame_aie, axame_mormo, gta) values (
	"Black",
    "Preta",
    "Macho",
    "Sim",
    "Não",
    "Sim"
),
(
	"White",
    "Branco",
    "Femea",
    "Sim",
    "Não",
    "Não"
),
(
	"Jack",
    "Persa",
    "Macho",
    "Não",
    "Sim",
    "Não"
);

create table ClientesXCavalos (
	clientes_id int not null references Clientes(id),
    cavalos_id int not null references Cavalos(registro),
    
    primary key (clientes_id, cavalos_id)
);

insert into ClientesXCavalos values (
	1,
    1
),
(
	2,
    2
),
(
	3,
    2
),
(
	4,
    3
);

create table Produtos (
	id int primary key auto_increment,
    nome varchar(60),
    estoque int,
    preco_custo decimal(6,2),
    preco_venda decimal(6,2)
);

insert into Produtos (nome, estoque, preco_custo, preco_venda) values (
	"Vitamina",
    10,
    '100.00',
    '150.00'
),
(
	"Medicamento",
    14,
    '120.00',
    '180.00'
),
(
	"Seringa",
    30,
    '10.00',
    '15.00'
),
(
	"Agulha",
    50,
    '5.00',
    '7.00'
);

create table Servicos (
	id int primary key auto_increment,
    tipo varchar(45),
    preco decimal(6,2)
);

insert into Servicos (tipo, preco) values (
	"Casqueamento",
    '320.00'
),
(
	"Ferrajamento",
    '280.00'
);

create table Tipo_de_estadia (
	id int primary key auto_increment,
    tipo varchar(45),
    preco decimal(6,2)
);

insert into Tipo_de_estadia (tipo, preco) values (
	"Reprodução",
    '500.00'
),
(
	"Treinamento",
    '650.00'
);

create table Estadias (
	id int primary key auto_increment,
    cavalo_registro int not null references Cavalos(registro),
    entrada datetime not null,
    saida datetime,
    tipo_de_estadia_id int not null references Tipo_de_estadia(id),
    cocheira int
);

insert into Estadias (entrada, saida, tipo_de_estadia_id, cocheira) values (
	'2023-04-02 13:00:00',
    '2023-04-12 14:00:00',
    1,
    1
),
(
	'2023-04-04 13:00:00',
    '2023-04-25 16:00:00',
    2,
    2
),
(
	'2023-04-10 13:00:00',
    '2023-05-01 11:00:00',
    1,
    3
);

create table EstadiasXProdutos (
	estadias_id int not null references Estadias(id),
    produtos_id int not null references Produtos(id),
    quantidade int,
    
    primary key (estadias_id, produtos_id)
);

insert into EstadiasXProdutos values (
	1,
    1,
    3
),
(
	2,
    2,
    2
),
(
	2,
    1,
    4
),
(
	3,
    3,
    2
),
(
	3,
    4,
    2
);

create table EstadiasXServicos (
    estadias_id int not null references Estadias(id),
    servicos_id int not null references Servicos(id),
    
    primary key(estadias_id,servicos_id)
);

insert into EstadiasXServicos values (
	1,
    1
),
(
	2,
    2
),
(
	3,
    1
);



































