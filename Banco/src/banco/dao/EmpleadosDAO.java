/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco.dao;

import banco.connection.DbConnection;
import banco.vo.Empleados;
import banco.vo.Personas;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.sql.*;

/**
 *
 * @author hflores
 */
public class EmpleadosDAO {

    public void registrarEmpleado(Empleados empleado) {
        DbConnection conex = new DbConnection();
        try {
            Statement estatuto = conex.getConnection().createStatement();
            estatuto.executeUpdate("INSERT INTO empleados (codigo, persona_id) VALUES ('" + empleado.getCodigo() + "', '" + empleado.getIdPersona() + "');");
            JOptionPane.showMessageDialog(null, "Se ha registrado Exitosamente", "Información", JOptionPane.INFORMATION_MESSAGE);
            estatuto.close();
            conex.desconectar();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "No se Registro el empleado");
        }

    }

    public ArrayList<Empleados> consultarEmpleado(int documento) {
        ArrayList<Empleados> miEmpleado = new ArrayList<Empleados>();
        DbConnection conex = new DbConnection();

        try {
            PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM empleados where id_empleado = ? ");
            consulta.setInt(1, documento);
            ResultSet res = consulta.executeQuery();

            if (res.next()) {
                Empleados empleado = new Empleados();
                empleado.setCodigo();
                miEmpleado.add(empleado);
            }
            res.close();
            consulta.close();
            conex.desconectar();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "no se pudo consultar el empleado\n" + e);
        }
        return miEmpleado;
    }

    public ArrayList<Personas> listaDeEmpleados() {
        ArrayList<Personas> miEmpleado = new ArrayList<Personas>();
        DbConnection conex = new DbConnection();

        try {
            PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT personas.nombre , personas.apellido FROM empleados inner join personas ON empleados.persona_id = personas.id_persona;");
            ResultSet res = consulta.executeQuery();
            while (res.next()) {
                Personas empleado = new Personas();
                empleado.setNombre(res.getString("nombre"));
                empleado.setApellido(res.getString("apellido"));
                miEmpleado.add(empleado);
            }
            res.close();
            consulta.close();
            conex.desconectar();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "no se pudo consultar el empleado\n" + e);
        }
        return miEmpleado;
    }

}
