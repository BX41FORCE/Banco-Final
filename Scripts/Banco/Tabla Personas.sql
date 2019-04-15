CREATE TABLE Personas(
id_Persona serial  NOT NULL,
nombre varchar(41) NOT NULL,
apellido varchar(41) NOT NULL,
fecha_Nacimiento varchar(10) NOT NULL,
edad varchar(2) NOT NULL,
CONSTRAINT PK_Personas PRIMARY KEY (id_Persona));