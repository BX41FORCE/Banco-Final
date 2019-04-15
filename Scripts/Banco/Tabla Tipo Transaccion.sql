CREATE TABLE Tipo_Transaccion(
id_Tipo_Transaccion serial  NOT NULL,
descripcion varchar(50) NOT NULL,
CONSTRAINT PK_Tipo_Transaccion PRIMARY KEY (id_Tipo_Transaccion));