package banco.vo;

/**
 *
 * @author bcortez
 */
public class Operaciones {

    private String depositante;
    private int valor;
    private int cliente;
    private int empleado;
    private int idTipoTransaccion;

    public String getDepositante() {
        return depositante;
    }

    public void setDepositante(String depositante) {
        this.depositante = depositante;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getCliente() {
        return cliente;
    }

    public void setCliente(int cliente) {
        this.cliente = cliente;
    }

    public int getEmpleado() {
        return empleado;
    }

    public void setEmpleado(int empleado) {
        this.empleado = empleado;
    }

    public int getidTipoTransaccion() {
        return idTipoTransaccion;
    }

    public void setidTipoTransaccion(int tipoTransaccion) {
        this.idTipoTransaccion = tipoTransaccion;
    }

    public Operaciones(String depositante, int valor, int cliente, int empleado, int idTipoTransaccion) {
        this.depositante = depositante;
        this.valor = valor;
        this.cliente = cliente;
        this.empleado = empleado;
        this.idTipoTransaccion = idTipoTransaccion;
    }

    public Operaciones() {
    }

}
