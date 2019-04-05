/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco.dao;

import banco.connection.DbConnection;
import banco.vo.Cuentas;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.sql.*;

/**
 *
 * @author hflores
 */
public class CuentasDAO {
    public void registrarCuenta (Cuentas cuenta){
    DbConnection conex = new DbConnection();
    try {
            Statement estatuto = conex.getConnection().createStatement();
            estatuto.executeUpdate("INSERT INTO cuenta (numero_cuenta, saldo, tipo_cuenta) VALUES ('" + cuenta.getNumeroCuenta()+ "', '" + cuenta.getSaldo() + "', '"
                    + cuenta.getTipoCuenta()+ "');");
            JOptionPane.showMessageDialog(null, "Se ha registrado Exitosamente", "Información", JOptionPane.INFORMATION_MESSAGE);
            estatuto.close();
            conex.desconectar();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "No se Registro la cuenta");
        }
    
    }
    
    public ArrayList<Cuentas> consultarCuenta(int documento) {
        ArrayList<Cuentas> miCuenta = new ArrayList<Cuentas>();
        DbConnection conex = new DbConnection();

        try {
            PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM cuenta where id_cuenta = ? ");
            consulta.setInt(1, documento);
            ResultSet res = consulta.executeQuery();

            if (res.next()) {
                Cuentas cuenta = new Cuentas();
                cuenta.setNumeroCuenta(res.getString("numero_cuenta"));
                cuenta.setSaldo(res.getLong("saldo"));
                //cuenta.setTipoCuenta(res.getString("tipoCuenta"));
                miCuenta.add(cuenta);
            }
            res.close();
            consulta.close();
            conex.desconectar();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "no se pudo consultar la cuenta\n" + e);
        }
        return miCuenta;
    }
    public ArrayList<Cuentas> listaDeCuentas() {
        ArrayList<Cuentas> miCuenta = new ArrayList<Cuentas>();
        DbConnection conex = new DbConnection();

        try {
            PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM cuenta");
            ResultSet res = consulta.executeQuery();
            while (res.next()) {
                Cuentas cuenta = new Cuentas();
                cuenta.setNumeroCuenta(res.getString("numero_cuenta"));
                cuenta.setSaldo(res.getLong("saldo"));
                //cuenta.setTipoCuenta(res.getString("tipoCuenta"));
                miCuenta.add(cuenta);
            }
            res.close();
            consulta.close();
            conex.desconectar();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "no se pudo consultar el Cliente\n" + e);
        }
        return miCuenta;
    }
    
}
