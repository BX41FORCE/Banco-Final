/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco.dao;

import banco.connection.DbConnection;
import banco.vo.Empleados;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.sql.*;

/**
 *
 * @author hflores
 */
public class EmpleadosDAO {
    public void registrarEmpleado (Empleados empleado){
    DbConnection conex = new DbConnection();
    try {
            Statement estatuto = conex.getConnection().createStatement();
            estatuto.executeUpdate("INSERT INTO empleado (cuenta) VALUES ('" + empleado.getCodigo()+ "');");
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
            PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM empleado where id_empleado = ? ");
            consulta.setInt(1, documento);
            ResultSet res = consulta.executeQuery();

            if (res.next()) {
                Empleados empleado = new Empleados();
                empleado.setCodigo(res.getString("codigo"));
                miEmpleado.add(empleado);
            }
            res.close();
            consulta.close();
            conex.desconectar();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "no se pudo consultar el Cliente\n" + e);
        }
        return miEmpleado;
    }
    public ArrayList<Empleados> listaDeEmpleados() {
        ArrayList<Empleados> miEmpleado = new ArrayList<Empleados>();
        DbConnection conex = new DbConnection();

        try {
            PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM empleado");
            ResultSet res = consulta.executeQuery();
            while (res.next()) {
                Empleados empleado = new Empleados();
                empleado.setCodigo(res.getString("codigo"));
                
                miEmpleado.add(empleado);
            }
            res.close();
            consulta.close();
            conex.desconectar();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "no se pudo consultar el Cliente\n" + e);
        }
        return miEmpleado;
    }
    
}
