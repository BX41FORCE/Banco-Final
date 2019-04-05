package banco.dao;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import banco.connection.DbConnection;
import banco.vo.Personas;

public class PersonasDAO {

    public void registrarPersona(Personas persona) {
        DbConnection conex = new DbConnection();
        try {
            Statement estatuto = conex.getConnection().createStatement();
            estatuto.executeUpdate("INSERT INTO persona (nombre,apellido,fecha_nacimiento,edad) VALUES ('" + persona.getNombre() + "', '" + persona.getApellido() + "', '"
                    + persona.getFechaNacimiento() + "', '" + persona.getEdad() + "');");
            JOptionPane.showMessageDialog(null, "Se ha registrado Exitosamente", "Información", JOptionPane.INFORMATION_MESSAGE);
            estatuto.close();
            conex.desconectar();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "No se Registro la persona");
        }
    }

    public ArrayList<Personas> consultarPersona(int documento) {
        ArrayList<Personas> miPersona = new ArrayList<Personas>();
        DbConnection conex = new DbConnection();

        try {
            PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM persona where id_persona = ? ");
            consulta.setInt(1, documento);
            ResultSet res = consulta.executeQuery();

            if (res.next()) {
                Personas persona = new Personas();
                persona.setIdPersona(Integer.parseInt(res.getString("id_persona")));
                persona.setNombre(res.getString("nombre"));
                persona.setApellido(res.getString("apellido"));
                persona.setFechaNacimiento(res.getString("fecha_nacimiento"));
                persona.setEdad(res.getString("edad"));
                miPersona.add(persona);
            }
            res.close();
            consulta.close();
            conex.desconectar();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "no se pudo consultar la Persona\n" + e);
        }
        return miPersona;
    }

    public ArrayList<Personas> listaDePersonas() {
        ArrayList<Personas> miPersona = new ArrayList<Personas>();
        DbConnection conex = new DbConnection();

        try {
            PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM persona");
            ResultSet res = consulta.executeQuery();
            while (res.next()) {
                Personas persona = new Personas();
                persona.setIdPersona(Integer.parseInt(res.getString("id_persona")));
                persona.setNombre(res.getString("nombre"));
                persona.setApellido(res.getString("apellido"));
                persona.setFechaNacimiento(res.getString("fecha_nacimiento"));
                persona.setEdad(res.getString("edad"));
                miPersona.add(persona);
            }
            res.close();
            consulta.close();
            conex.desconectar();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "no se pudo consultar la Persona\n" + e);
        }
        return miPersona;
    }
}
