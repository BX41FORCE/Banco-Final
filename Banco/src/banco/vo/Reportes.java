/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco.vo;

/**
 *
 * @author bcortez
 */
public class Reportes {

    String tipoTransaccion;
    String tipoCuenta;
    String numeroCuenta;
    String titular;
    String monto;
    String depositante;
    String empleado;

    public String getTipoTransaccion() {
        return tipoTransaccion;
    }

    public void setTipoTransaccion(String tipoTransaccion) {
        this.tipoTransaccion = tipoTransaccion;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public String getMonto() {
        return monto;
    }

    public void setMonto(String monto) {
        this.monto = monto;
    }

    public String getDepositante() {
        return depositante;
    }

    public void setDepositante(String depositante) {
        this.depositante = depositante;
    }

    public String getEmpleado() {
        return empleado;
    }

    public void setEmpleado(String empleado) {
        this.empleado = empleado;
    }

    public Reportes() {
    }

    public Reportes(String tipoTransaccion, String tipoCuenta, String numeroCuenta, String titular, String monto, String depositante, String empleado) {
        this.tipoTransaccion = tipoTransaccion;
        this.tipoCuenta = tipoCuenta;
        this.numeroCuenta = numeroCuenta;
        this.titular = titular;
        this.monto = monto;
        this.depositante = depositante;
        this.empleado = empleado;
    }

}
