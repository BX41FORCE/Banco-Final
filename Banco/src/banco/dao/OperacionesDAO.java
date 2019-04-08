/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco.dao;

import banco.connection.DbConnection;
import banco.vo.Operaciones;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.sql.*;

/**
 *
 * @author hflores
 */
public class OperacionesDAO {

    public void registrarOperacion(Operaciones operacion) {
        DbConnection conex = new DbConnection();
        try {
            Statement estatuto = conex.getConnection().createStatement();
            estatuto.executeUpdate("INSERT INTO cuenta (nombre_depositante, valor, empleado, cliente, transaccion) VALUES ('" + operacion.getDepositante() + "', '" + operacion.getValor() + "', '"
                    + operacion.getEmpleado() + "', ' " + operacion.getCliente() + "', ' " + operacion.getidTipoTransaccion() + "');");
            JOptionPane.showMessageDialog(null, "Se ha registrado Exitosamente", "Información", JOptionPane.INFORMATION_MESSAGE);
            estatuto.close();
            conex.desconectar();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "No se Registro la operacion");
        }

    }

    public ArrayList<Operaciones> consultarOperacion(int documento) {
        ArrayList<Operaciones> miOperacion = new ArrayList<Operaciones>();
        DbConnection conex = new DbConnection();

        try {
            PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM operacion where id_operacion= ? ");
            consulta.setInt(1, documento);
            ResultSet res = consulta.executeQuery();

            if (res.next()) {
                Operaciones operacion = new Operaciones();
                operacion.setDepositante(res.getString("nombre_depositante"));
                operacion.setValor(Integer.parseInt(res.getString("valor")));
                operacion.setEmpleado(Integer.parseInt(res.getString("empleado")));
                operacion.setCliente(Integer.parseInt(res.getString("cliente")));
                operacion.setidTipoTransaccion(Integer.parseInt(res.getString("transaccion")));
                miOperacion.add(operacion);
            }
            res.close();
            consulta.close();
            conex.desconectar();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "no se pudo consultar la operacion\n" + e);
        }
        return miOperacion;
    }

    public ArrayList<Operaciones> listaDeOperaciones() {
        ArrayList<Operaciones> miOperacion = new ArrayList<Operaciones>();
        DbConnection conex = new DbConnection();

        try {
            PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM operacion");
            ResultSet res = consulta.executeQuery();
            while (res.next()) {
                Operaciones operacion = new Operaciones();
                operacion.setDepositante(res.getString("nombre_depositante"));
                operacion.setValor(Integer.parseInt(res.getString("valor")));
                operacion.setEmpleado(Integer.parseInt(res.getString("empleado")));
                operacion.setCliente(Integer.parseInt(res.getString("cliente")));
                operacion.setidTipoTransaccion(Integer.parseInt(res.getString("transaccion")));
                miOperacion.add(operacion);
            }
            res.close();
            consulta.close();
            conex.desconectar();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "no se pudo consultar la operacion\n" + e);
        }
        return miOperacion;
    }

}
