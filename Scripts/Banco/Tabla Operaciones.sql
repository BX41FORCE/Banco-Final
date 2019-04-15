CREATE TABLE Operaciones(
id_Operacion serial  NOT NULL,
nombre_Depositante varchar(41) NOT NULL,
valor bigint NOT NULL,
empleado int REFERENCES Empleados(id_Empleado),
cliente int REFERENCES Clientes(id_Cliente),
transaccion int REFERENCES Tipo_Transaccion(id_Tipo_Transaccion),
CONSTRAINT PK_Operaciones PRIMARY KEY (id_Operacion));