SELECT personas.nombre , personas.apellido FROM empleados inner join personas ON empleados.persona_id = personas.id_persona;
