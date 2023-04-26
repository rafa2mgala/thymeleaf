drop table category if exists;
drop table product if exists;
drop table ranking if exists;
drop sequence if exists hibernate_sequence;

create sequence hibernate_sequence start with 100 increment by 1;

create table category (
	id bigint not null, 
	destacada boolean not null, 
	imagen varchar(512), 
	nombre varchar(512), 
	primary key (id)
);

create table product (
	id bigint not null, 
	descripcion clob, 
	descuento float not null, 
	imagen varchar(512), 
	nombre varchar(512), 
	pvp float not null, 
	categoria_id bigint, 
	primary key (id)
);

create table ranking (
	id bigint not null, 
	fecha timestamp, 
	puntuacion integer not null, 
	producto_id bigint, 
	primary key (id)
);

alter table product add constraint fk_producto_categoria foreign key (categoria_id) references category;
alter table ranking add constraint fk_puntuacion_producto foreign key (producto_id) references product;
