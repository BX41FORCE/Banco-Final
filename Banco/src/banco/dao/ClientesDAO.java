/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco.dao;

import banco.connection.DbConnection;
import java.sql.*;
import banco.vo.Clientes;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author hflores
 */
public class ClientesDAO {

    public void registrarCliente(Clientes cliente) {
        DbConnection conex = new DbConnection();
        try {
            Statement estatuto = conex.getConnection().createStatement();
            estatuto.executeUpdate("INSERT INTO clientes (persona_id,cuenta) VALUES ('" + cliente.getIdPersona() + "', '" + cliente.getIdCuenta() + "');");
            JOptionPane.showMessageDialog(null, "Se ha registrado Exitosamente", "Información", JOptionPane.INFORMATION_MESSAGE);
            estatuto.close();
            conex.desconectar();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "No se Registro el cliente");
        }

    }

    public ArrayList<Clientes> consultarCliente(int documento) {
        ArrayList<Clientes> miCliente = new ArrayList<Clientes>();
        DbConnection conex = new DbConnection();

        try {
            PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM cliente where id_cliente = ? ");
            consulta.setInt(1, documento);
            ResultSet res = consulta.executeQuery();

            if (res.next()) {
                Clientes cliente = new Clientes();
                cliente.setIdCuenta(Integer.parseInt(res.getString("cuenta")));
                miCliente.add(cliente);
            }
            res.close();
            consulta.close();
            conex.desconectar();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "no se pudo consultar el Cliente\n" + e);
        }
        return miCliente;
    }

    public ArrayList<Clientes> listaDeClientes() {
        ArrayList<Clientes> miCliente = new ArrayList<Clientes>();
        DbConnection conex = new DbConnection();

        try {
            PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM cliente");
            ResultSet res = consulta.executeQuery();
            while (res.next()) {
                Clientes cliente = new Clientes();
                cliente.setIdCuenta(Integer.parseInt(res.getString("cuenta")));
                miCliente.add(cliente);
            }
            res.close();
            consulta.close();
            conex.desconectar();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "no se pudo consultar el Cliente\n" + e);
        }
        return miCliente;
    }
}
