package banco.vo;

/**
 *
 * @author bcortez
 */
public class TipoCuenta {

    private String descripcion;

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public TipoCuenta(String descripcion) {
        this.descripcion = descripcion;
    }

    public TipoCuenta() {
    }

}
