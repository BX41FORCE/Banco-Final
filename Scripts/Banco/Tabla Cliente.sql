CREATE TABLE Clientes(
id_Cliente serial  NOT NULL,
Persona_id int REFERENCES Personas(id_Persona),
Cuenta int REFERENCES Cuentas(id_Cuenta),
CONSTRAINT PK_Cleinte PRIMARY KEY (id_Cliente));