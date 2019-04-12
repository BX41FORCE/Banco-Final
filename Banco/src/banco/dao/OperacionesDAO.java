/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco.dao;

import banco.connection.DbConnection;
import banco.vo.Clientes;
import banco.vo.Operaciones;
import banco.vo.Personas;
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
            estatuto.executeUpdate("INSERT INTO operaciones (nombre_depositante, valor, empleado, cliente, transaccion) VALUES ('" + operacion.getDepositante() + "', '" + operacion.getValor() + "', '"
                    + operacion.getEmpleado() + "', ' " + operacion.getCliente() + "', ' " + operacion.getidTipoTransaccion() + "');");
            JOptionPane.showMessageDialog(null, "Se ha registrado Exitosamente", "Información", JOptionPane.INFORMATION_MESSAGE);
            estatuto.close();
            conex.desconectar();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "No se Registro la operacion");
        }

    }

    public String consultarIdCliente(String cuenta) {
        DbConnection conex = new DbConnection();
        String id_Cuenta = "";
        try {
            PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT id_cliente FROM clientes \n"
                    + "INNER JOIN personas\n"
                    + "ON clientes.persona_id = personas.id_persona \n"
                    + "INNER JOIN cuentas ON clientes.cuenta = cuentas.id_cuenta and cuentas.numero_cuenta ='" + cuenta + "';");
            ResultSet res = consulta.executeQuery();
            if (res.next()) {
                id_Cuenta = res.getString("id_cliente");
                res.close();
                consulta.close();
                conex.desconectar();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No Se Pudo Encontrar el Cliente \n" + e);
        }
        return id_Cuenta;
    }

    public String comprobarSaldo(String cuenta) {
        DbConnection conex = new DbConnection();
        String Saldo = "";
        try {
            PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT cuentas.saldo FROM cuentas \n"
                    + "INNER JOIN clientes ON clientes.cuenta = cuentas.id_cuenta AND cuentas.numero_cuenta = '" + cuenta + "';");
            ResultSet res = consulta.executeQuery();
            if (res.next()) {
                Saldo = res.getString("saldo");
                res.close();
                consulta.close();
                conex.desconectar();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No Se Pudo Encontrar el Cliente \n" + e);
        }
        return Saldo;
    }

    public String comprobarTipoCuenta(String cuenta) {
        DbConnection conex = new DbConnection();
        String tipo = "";
        try {
            PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT tipo_cuenta.descripcion FROM cuentas \n"
                    + "INNER JOIN clientes ON clientes.cuenta = cuentas.id_cuenta AND cuentas.numero_cuenta = '" + cuenta + "'\n"
                    + "INNER JOIN tipo_cuenta ON cuentas.tipo_cuenta = tipo_cuenta.id_tipo_cuenta;");
            ResultSet res = consulta.executeQuery();
            if (res.next()) {
                tipo = res.getString("descripcion");
                res.close();
                consulta.close();
                conex.desconectar();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No Se Pudo Encontrar el Tipo de Cuenta \n" + e);
        }
        return tipo;
    }

    public String comprobarCliente(String cuenta) {
        DbConnection conex = new DbConnection();
        String nombre = "";
        try {
            PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT personas.nombre,personas.apellido FROM cuentas \n"
                    + "INNER JOIN clientes ON clientes.cuenta = cuentas.id_cuenta AND cuentas.numero_cuenta = '" + cuenta + "'\n"
                    + "INNER JOIN personas ON clientes.persona_id = personas.id_persona;");
            ResultSet res = consulta.executeQuery();
            if (res.next()) {
                nombre = res.getString("nombre") + " " + res.getString("apellido");
                res.close();
                consulta.close();
                conex.desconectar();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No Se Pudo Encontrar el Cliente \n" + e);
        }
        return nombre;
    }

    public String registrarSaldo(int valor, String cuenta) {
        DbConnection conex = new DbConnection();
        try {
            PreparedStatement consulta = conex.getConnection().prepareStatement("UPDATE cuentas SET saldo = " + valor + " WHERE cuentas.numero_cuenta = '" + cuenta + "';");
            consulta.executeQuery();
            consulta.close();
            conex.desconectar();
        } catch (Exception e) {

        }
        return null;
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
