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
public class Empleados {

    private String codigo;
    private int idPersona;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo() {
        String codigo = "";
        for (int i = 0; i < 5; i++) {
            int numero = (int) (Math.random() * 10);
            String con = numero + "";
            codigo += con;
        }
        this.codigo = codigo;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public Empleados(int idPersona) {
        this.idPersona = idPersona;
    }

    public Empleados() {
    }

}
