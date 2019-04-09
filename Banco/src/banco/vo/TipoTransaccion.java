package banco.vo;

/**
 *
 * @author bcortez
 */
public class TipoTransaccion {

    private String descripcion;

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public TipoTransaccion(String descripcion) {
        this.descripcion = descripcion;
    }

    public TipoTransaccion() {
    }

}
