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
            estatuto.executeUpdate("INSERT INTO personas (nombre,apellido,fecha_nacimiento,edad) VALUES ('" + persona.getNombre() + "', '" + persona.getApellido() + "', '"
                    + persona.getFechaNacimiento() + "', '" + persona.getEdad() + "');");
            JOptionPane.showMessageDialog(null, "Se ha registrado Exitosamente", "Información", JOptionPane.INFORMATION_MESSAGE);
            estatuto.close();
            conex.desconectar();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "No se Registro la persona");
        }
    }

    public String consultarIdPersona() {
        DbConnection conex = new DbConnection();
        String id_Persona = "";
        try {
            PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT MAX (id_persona) AS id_persona FROM personas;");
            ResultSet res = consulta.executeQuery();
            if (res.next()) {
                id_Persona = res.getString("id_persona");
                res.close();
                consulta.close();
                conex.desconectar();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "no se pudo enlazar a la persona\n" + e);
        }
        return id_Persona;
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
                persona.setNombre(res.getString("nombre"));
                persona.setApellido(res.getString("apellido"));
                persona.setFechaNacimiento(res.getString("fecha_nacimiento"));
                persona.setEdad();
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
                persona.setNombre(res.getString("nombre"));
                persona.setApellido(res.getString("apellido"));
                persona.setFechaNacimiento(res.getString("fecha_nacimiento"));
                persona.setEdad();
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
