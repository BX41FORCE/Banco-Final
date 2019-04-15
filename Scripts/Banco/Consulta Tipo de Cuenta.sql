SELECT personas.nombre,personas.apellido FROM cuentas 
INNER JOIN clientes ON clientes.cuenta = cuentas.id_cuenta AND cuentas.numero_cuenta = '7191'
INNER JOIN personas ON clientes.persona_id = personas.id_persona;