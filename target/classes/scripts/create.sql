create table IF NOT EXISTS duenos (
	nombreDueño varchar(25) PRIMARY KEY,
	dni varchar(25),
	mascota bigint;
);

create table IF NOT EXISTS animales (
	id bigint auto_increment,
	nombreMascota varchar(25),
	identificadorChip bigint,
);

 ALTER TABLE duenos
    ADD FOREIGN KEY (mascota) 
    REFERENCES animales(id)