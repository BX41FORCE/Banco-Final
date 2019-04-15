SELECT /*personas.nombre, personas.apellido*/ id_cliente FROM clientes 
INNER JOIN personas
ON clientes.persona_id = personas.id_persona 
INNER JOIN cuentas ON clientes.cuenta = cuentas.id_cuenta and cuentas.numero_cuenta ='1066';