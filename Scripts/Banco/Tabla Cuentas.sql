CREATE TABLE Cuentas(
id_Cuenta serial  NOT NULL,
numero_Cuenta varchar(4) NOT NULL,
saldo bigint NOT NULL,
Tipo_Cuenta int REFERENCES Tipo_Cuenta(id_Tipo_Cuenta),
CONSTRAINT PK_Cuenta PRIMARY KEY (id_Cuenta));