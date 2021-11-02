drop database test;
create database test;
use test;

create table usuario(
    id int primary key auto_increment,
    correo varchar(255) unique,
    nombre varchar(255) ,
    tipo varchar(255),
    password varchar(255)
    
);
create table agente(
		id int primary key auto_increment,
		cedula varchar(10) unique,
		nombre varchar(255),
		apellido varchar(255),
		tipo varchar(255),
		fotografia mediumblob
);

create table camion(
	id int primary key auto_increment,
    placa varchar(255),
	unidad varchar(255),
    marca varchar(255),
	tipo varchar(255),
	color varchar(255),
	modelo varchar(255)

);


create table remesa(
id int primary key auto_increment,
valor decimal(8,2),
estado boolean,
id_emisor int not null,
id_receptor int not null,
id_camion int not null,
tipo varchar(255),
fecha date,
foreign key (id_emisor) references usuario(id),
foreign key (id_receptor) references usuario(id),
foreign key (id_camion) references camion(id)
);

create table agente_remesa(
  id_remesa int not null,
  foreign key(id_remesa) references remesa(id),
  id_agente int not null,
  foreign key(id_agente) references agente(id),
  primary key(id_agente,id_remesa)
);
insert into usuario(correo,nombre,tipo,password)
values("admin","admin","ADMINISTRADOR","admin");

select * from agente;
select * from remesa;
select * from usuario;
select * from camion;
select * from agente_remesa;

