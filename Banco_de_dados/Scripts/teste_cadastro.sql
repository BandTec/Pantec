create database pantec;
use pantec;

create table cliente(
id int primary key auto_increment,
nome varchar(80),
email varchar(80),
telefone char(14),
senha varchar(80)
);

select * from cliente;