/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco.dao;

import banco.connection.DbConnection;
import banco.vo.Clientes;
import banco.vo.TipoCuenta;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.sql.*;

/**
 *
 * @author hflores
 */
public class TipoCuentaDAO {
     public void registrarTipoCuenta (TipoCuenta tipocuenta){
    DbConnection conex = new DbConnection();
    try {
            Statement estatuto = conex.getConnection().createStatement();
            estatuto.executeUpdate("INSERT INTO tipo_cuenta (descripcion) VALUES ('" + tipocuenta.getDescripcion() + "');");
            JOptionPane.showMessageDialog(null, "Se ha registrado Exitosamente", "Información", JOptionPane.INFORMATION_MESSAGE);
            estatuto.close();
            conex.desconectar();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "No se Registro el tipo de cuenta");
        }
    
    }
    
    public ArrayList<TipoCuenta> consultarTipoCuenta(int documento) {
        ArrayList<TipoCuenta> miTipoCuenta = new ArrayList<TipoCuenta>();
        DbConnection conex = new DbConnection();

        try {
            PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM tipo_cuenta where id_tipo_cuenta = ? ");
            consulta.setInt(1, documento);
            ResultSet res = consulta.executeQuery();

            if (res.next()) {
                TipoCuenta tipocuenta = new TipoCuenta();
                tipocuenta.setDescripcion(res.getString("descripcion"));
                miTipoCuenta.add(tipocuenta);
            }
            res.close();
            consulta.close();
            conex.desconectar();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "no se pudo consultar el tipo de cuenta\n" + e);
        }
        return miTipoCuenta;
    }
    public ArrayList<TipoCuenta> listaDeTipoCuenta() {
        ArrayList<TipoCuenta> miTipoCuenta = new ArrayList<TipoCuenta>();
        DbConnection conex = new DbConnection();

        try {
            PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM cliente");
            ResultSet res = consulta.executeQuery();
            while (res.next()) {
                TipoCuenta tipocuenta = new TipoCuenta();
                tipocuenta.setDescripcion(res.getString("descripcion"));
                miTipoCuenta.add(tipocuenta);
            }
            res.close();
            consulta.close();
            conex.desconectar();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "no se pudo consultar el tipo de Cuenta\n" + e);
        }
        return miTipoCuenta;
    }
    
}
