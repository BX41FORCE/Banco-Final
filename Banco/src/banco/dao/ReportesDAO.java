/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco.dao;

import banco.connection.DbConnection;
import banco.vo.Reportes;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author bcortez
 */
public class ReportesDAO {

    public void registrarReporte(Reportes reporte) {
        DbConnection conex = new DbConnection();
        try {
            Statement estatuto = conex.getConnection().createStatement();
            estatuto.executeUpdate("INSERT INTO reportes (tipo_transaccion,tipo_cuenta,numero_cuenta,titular,monto,depositante,empleado)\n"
                    + "VALUES ('" + reporte.getTipoTransaccion() + "','" + reporte.getTipoCuenta() + "','" + reporte.getNumeroCuenta() + "','" + reporte.getTitular() + "','" + reporte.getMonto() + "','" + reporte.getDepositante() + "','" + reporte.getEmpleado() + "');");
            JOptionPane.showMessageDialog(null, "Se ha registrado Exitosamente", "Información", JOptionPane.INFORMATION_MESSAGE);
            estatuto.close();
            conex.desconectar();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "No se Registro el Reporte");
        }

    }

    public ArrayList<Reportes> verTodos() {
        ArrayList<Reportes> miReporte = new ArrayList<Reportes>();
        DbConnection conex = new DbConnection();
        try {
            PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM reportes");
            ResultSet res = consulta.executeQuery();
            while (res.next()) {
                Reportes reporte = new Reportes();
                reporte.setTipoTransaccion(res.getString("tipo_transaccion"));
                reporte.setTipoCuenta(res.getString("tipo_cuenta"));
                reporte.setNumeroCuenta(res.getString("numero_cuenta"));
                reporte.setTitular(res.getString("titular"));
                reporte.setMonto(res.getString("monto"));
                reporte.setDepositante(res.getString("depositante"));
                reporte.setEmpleado(res.getString("empleado"));
                miReporte.add(reporte);
            }
            res.close();
            consulta.close();
            conex.desconectar();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "no se pudo consultar la operacion\n" + e);
        }
        return miReporte;
    }

    public ArrayList<Reportes> filtro1() {
        ArrayList<Reportes> miReporte = new ArrayList<Reportes>();
        DbConnection conex = new DbConnection();
        try {
            PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM reportes   WHERE tipo_transaccion = 'Depósito';");
            ResultSet res = consulta.executeQuery();
            while (res.next()) {
                Reportes reporte = new Reportes();
                reporte.setTipoTransaccion(res.getString("tipo_transaccion"));
                reporte.setTipoCuenta(res.getString("tipo_cuenta"));
                reporte.setNumeroCuenta(res.getString("numero_cuenta"));
                reporte.setTitular(res.getString("titular"));
                reporte.setMonto(res.getString("monto"));
                reporte.setDepositante(res.getString("depositante"));
                reporte.setEmpleado(res.getString("empleado"));
                miReporte.add(reporte);
            }
            res.close();
            consulta.close();
            conex.desconectar();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "no se pudo consultar la operacion\n" + e);
        }
        return miReporte;
    }

    public ArrayList<Reportes> filtro2() {
        ArrayList<Reportes> miReporte = new ArrayList<Reportes>();
        DbConnection conex = new DbConnection();
        try {
            PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM reportes  WHERE tipo_transaccion = 'Retiro';");
            ResultSet res = consulta.executeQuery();
            while (res.next()) {
                Reportes reporte = new Reportes();
                reporte.setTipoTransaccion(res.getString("tipo_transaccion"));
                reporte.setTipoCuenta(res.getString("tipo_cuenta"));
                reporte.setNumeroCuenta(res.getString("numero_cuenta"));
                reporte.setTitular(res.getString("titular"));
                reporte.setMonto(res.getString("monto"));
                reporte.setDepositante(res.getString("depositante"));
                reporte.setEmpleado(res.getString("empleado"));
                miReporte.add(reporte);
            }
            res.close();
            consulta.close();
            conex.desconectar();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "no se pudo consultar la operacion\n" + e);
        }
        return miReporte;
    }

    public ArrayList<Reportes> filtro3() {
        ArrayList<Reportes> miReporte = new ArrayList<Reportes>();
        DbConnection conex = new DbConnection();
        try {
            PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM reportes  WHERE tipo_cuenta = 'Cta.Ahorro';");
            ResultSet res = consulta.executeQuery();
            while (res.next()) {
                Reportes reporte = new Reportes();
                reporte.setTipoTransaccion(res.getString("tipo_transaccion"));
                reporte.setTipoCuenta(res.getString("tipo_cuenta"));
                reporte.setNumeroCuenta(res.getString("numero_cuenta"));
                reporte.setTitular(res.getString("titular"));
                reporte.setMonto(res.getString("monto"));
                reporte.setDepositante(res.getString("depositante"));
                reporte.setEmpleado(res.getString("empleado"));
                miReporte.add(reporte);
            }
            res.close();
            consulta.close();
            conex.desconectar();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "no se pudo consultar la operacion\n" + e);
        }
        return miReporte;
    }

    public ArrayList<Reportes> filtro4() {
        ArrayList<Reportes> miReporte = new ArrayList<Reportes>();
        DbConnection conex = new DbConnection();
        try {
            PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM reportes  WHERE tipo_cuenta = 'Cta.Corriente';");
            ResultSet res = consulta.executeQuery();
            while (res.next()) {
                Reportes reporte = new Reportes();
                reporte.setTipoTransaccion(res.getString("tipo_transaccion"));
                reporte.setTipoCuenta(res.getString("tipo_cuenta"));
                reporte.setNumeroCuenta(res.getString("numero_cuenta"));
                reporte.setTitular(res.getString("titular"));
                reporte.setMonto(res.getString("monto"));
                reporte.setDepositante(res.getString("depositante"));
                reporte.setEmpleado(res.getString("empleado"));
                miReporte.add(reporte);
            }
            res.close();
            consulta.close();
            conex.desconectar();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "no se pudo consultar la operacion\n" + e);
        }
        return miReporte;
    }

    public ArrayList<Reportes> filtro5(String cuenta) {
        ArrayList<Reportes> miReporte = new ArrayList<Reportes>();
        DbConnection conex = new DbConnection();
        try {
            PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM reportes  WHERE numero_cuenta = '" + cuenta + "';");
            ResultSet res = consulta.executeQuery();
            while (res.next()) {
                Reportes reporte = new Reportes();
                reporte.setTipoTransaccion(res.getString("tipo_transaccion"));
                reporte.setTipoCuenta(res.getString("tipo_cuenta"));
                reporte.setNumeroCuenta(res.getString("numero_cuenta"));
                reporte.setTitular(res.getString("titular"));
                reporte.setMonto(res.getString("monto"));
                reporte.setDepositante(res.getString("depositante"));
                reporte.setEmpleado(res.getString("empleado"));
                miReporte.add(reporte);
            }
            res.close();
            consulta.close();
            conex.desconectar();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "no se pudo consultar la operacion\n" + e);
        }
        return miReporte;
    }

    public ArrayList<Reportes> filtro6(String empleado) {
        ArrayList<Reportes> miReporte = new ArrayList<Reportes>();
        DbConnection conex = new DbConnection();
        try {
            PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM reportes  WHERE empleado = '" + empleado + "';");
            ResultSet res = consulta.executeQuery();
            while (res.next()) {
                Reportes reporte = new Reportes();
                reporte.setTipoTransaccion(res.getString("tipo_transaccion"));
                reporte.setTipoCuenta(res.getString("tipo_cuenta"));
                reporte.setNumeroCuenta(res.getString("numero_cuenta"));
                reporte.setTitular(res.getString("titular"));
                reporte.setMonto(res.getString("monto"));
                reporte.setDepositante(res.getString("depositante"));
                reporte.setEmpleado(res.getString("empleado"));
                miReporte.add(reporte);
            }
            res.close();
            consulta.close();
            conex.desconectar();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "no se pudo consultar la operacion\n" + e);
        }
        return miReporte;
    }

    public ArrayList<Reportes> filtro7(String cuenta, String empleado) {
        ArrayList<Reportes> miReporte = new ArrayList<Reportes>();
        DbConnection conex = new DbConnection();
        try {
            PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM reportes  WHERE tipo_transaccion = 'Depósito' \n"
                    + "AND numero_cuenta = '" + cuenta + "' AND empleado = '" + empleado + "';");
            ResultSet res = consulta.executeQuery();
            while (res.next()) {
                Reportes reporte = new Reportes();
                reporte.setTipoTransaccion(res.getString("tipo_transaccion"));
                reporte.setTipoCuenta(res.getString("tipo_cuenta"));
                reporte.setNumeroCuenta(res.getString("numero_cuenta"));
                reporte.setTitular(res.getString("titular"));
                reporte.setMonto(res.getString("monto"));
                reporte.setDepositante(res.getString("depositante"));
                reporte.setEmpleado(res.getString("empleado"));
                miReporte.add(reporte);
            }
            res.close();
            consulta.close();
            conex.desconectar();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "no se pudo consultar la operacion\n" + e);
        }
        return miReporte;
    }
}
