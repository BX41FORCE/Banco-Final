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
public class Cuentas {

    private String numeroCuenta;
    private int saldo;
    private int idTipoCuenta;

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public int getIdTipoCuenta() {
        return idTipoCuenta;
    }

    public void setIdTipoCuenta(int idTipoCuenta) {
        this.idTipoCuenta = idTipoCuenta;
    }

    public Cuentas(String numeroCuenta, int saldo, int idTipoCuenta) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
        this.idTipoCuenta = idTipoCuenta;
    }

    public Cuentas() {
    }

}
