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

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public Empleados(String codigo, int idPersona) {
        this.codigo = codigo;
        this.idPersona = idPersona;
    }

    public Empleados() {
    }

}
