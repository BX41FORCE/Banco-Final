CREATE TABLE Reportes(
id_Reporte serial  NOT NULL,
tipo_transaccion varchar(50) NOT NULL,
tipo_cuenta varchar(50) NOT NULL,
numero_cuenta varchar(50) NOT NULL,
titular varchar(100) NOT NULL,
monto varchar(10) NULL,
depositante varchar(100) NOT NULL,
empleado varchar(100) NOT NULL,
CONSTRAINT PK_Reportes PRIMARY KEY (id_Reporte));