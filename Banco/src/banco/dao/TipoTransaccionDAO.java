/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco.dao;

import banco.connection.DbConnection;
import banco.vo.TipoTransaccion;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.sql.*;

/**
 *
 * @author hflores
 */
public class TipoTransaccionDAO {
    public void registrarTipoTransaccion (TipoTransaccion tipotransaccion){
    DbConnection conex = new DbConnection();
    try {
            Statement estatuto = conex.getConnection().createStatement();
            estatuto.executeUpdate("INSERT INTO tipo_transaccion (descripcion) VALUES ('" + tipotransaccion.getDescripcion()+ "');");
            JOptionPane.showMessageDialog(null, "Se ha registrado Exitosamente", "Información", JOptionPane.INFORMATION_MESSAGE);
            estatuto.close();
            conex.desconectar();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "No se Registro el tipo de transaccion");
        }
    
    }
    
    public ArrayList<TipoTransaccion> consultarCliente(int documento) {
        ArrayList<TipoTransaccion> miTipoTransaccion = new ArrayList<TipoTransaccion>();
        DbConnection conex = new DbConnection();

        try {
            PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM tipo_transaccion where id_tipo_transaccion = ? ");
            consulta.setInt(1, documento);
            ResultSet res = consulta.executeQuery();

            if (res.next()) {
                TipoTransaccion tipotransaccion = new TipoTransaccion();
                tipotransaccion.setDescripcion(res.getString("descripcion"));
                miTipoTransaccion.add(tipotransaccion);
            }
            res.close();
            consulta.close();
            conex.desconectar();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "no se pudo consultar el tipo de transaccion\n" + e);
        }
        return miTipoTransaccion;
    }
    public ArrayList<TipoTransaccion> listaDeClientes() {
        ArrayList<TipoTransaccion> miTipoTransaccion = new ArrayList<TipoTransaccion>();
        DbConnection conex = new DbConnection();

        try {
            PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM tipo_transaccion");
            ResultSet res = consulta.executeQuery();
            while (res.next()) {
                TipoTransaccion tipotransaccion = new TipoTransaccion();
                tipotransaccion.setDescripcion(res.getString("descripcion"));
                
                miTipoTransaccion.add(tipotransaccion);
            }
            res.close();
            consulta.close();
            conex.desconectar();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "no se pudo consultar el tipo de transaccion\n" + e);
        }
        return miTipoTransaccion;
    }
    
}
