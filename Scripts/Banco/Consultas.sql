Select nombre, apellido ,fecha_nacimiento, edad , cuentas.numero_cuenta, tipo_cuenta.descripcion as Tipo_Cuenta  from personas 
inner join clientes ON persona_id = id_persona 
inner join cuentas on cuenta = id_cuenta and numero_cuenta = '2251'
inner join tipo_cuenta on tipo_cuenta = id_tipo_cuenta;