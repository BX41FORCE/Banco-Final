CREATE TABLE Empleados(
id_Empleado serial  NOT NULL,
codigo varchar(5)NOT NULL,
Persona_id int REFERENCES Personas(id_Persona),
CONSTRAINT PK_Empleados PRIMARY KEY (id_Empleado));