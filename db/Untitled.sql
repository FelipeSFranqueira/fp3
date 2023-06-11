drop database if exists teste;
create database teste;
use teste;

create table teste (
	nome varchar(14),
    nascimento date,
    valor int
);

insert into teste values ("Felipe", '2023-03-07', 11);
insert into teste values ("pedro", '2023-04-11', 1);
insert into teste values ("joao", '2023-05-15',23);
insert into teste values ("ana", '2023-05-23', 5);
insert into teste values ("maria", '2023-07-30', 54);

select count(nome), sum(valor) from teste where month(nascimento) = 05;