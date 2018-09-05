create database ciclismo;

<!-- licencia N=no licencia, E=Elite, M=Master, C=Cicloturista
create table usuario(
	usuario varchar(20) not null,
	password varchar(20) not null,
	nombre varchar(20),
	apellidos varchar(20),
	calle varchar(100),
	cp varchar(5),
	ciudad varchar(20),
	email varchar(20),
	tlf varchar(10),
	licencia varchar(1) default 'N',
	PRIMARY KEY(usuario));
	
create table licencia(
	usuario varchar(20) not null,
	licencia varchar(1),
	fechaTiempo DATETIME,
	FOREIGN KEY(usuario) REFERENCES usuario(usuario));