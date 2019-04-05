/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco.vo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author bcortez
 */
@Entity
@Table(name = "operaciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Operaciones.findAll", query = "SELECT o FROM Operaciones o"),
    @NamedQuery(name = "Operaciones.findByIdOperacion", query = "SELECT o FROM Operaciones o WHERE o.idOperacion = :idOperacion"),
    @NamedQuery(name = "Operaciones.findByNombreDepositante", query = "SELECT o FROM Operaciones o WHERE o.nombreDepositante = :nombreDepositante"),
    @NamedQuery(name = "Operaciones.findByValor", query = "SELECT o FROM Operaciones o WHERE o.valor = :valor")})
public class Operaciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_operacion")
    private Integer idOperacion;
    @Basic(optional = false)
    @Column(name = "nombre_depositante")
    private String nombreDepositante;
    @Basic(optional = false)
    @Column(name = "valor")
    private long valor;
    @JoinColumn(name = "cliente", referencedColumnName = "id_cliente")
    @ManyToOne
    private Clientes cliente;
    @JoinColumn(name = "empleado", referencedColumnName = "id_empleado")
    @ManyToOne
    private Empleados empleado;
    @JoinColumn(name = "transaccion", referencedColumnName = "id_tipo_transaccion")
    @ManyToOne
    private TipoTransaccion transaccion;

    public Operaciones() {
    }

    public Operaciones(Integer idOperacion) {
        this.idOperacion = idOperacion;
    }

    public Operaciones(Integer idOperacion, String nombreDepositante, long valor) {
        this.idOperacion = idOperacion;
        this.nombreDepositante = nombreDepositante;
        this.valor = valor;
    }

    public Integer getIdOperacion() {
        return idOperacion;
    }

    public void setIdOperacion(Integer idOperacion) {
        this.idOperacion = idOperacion;
    }

    public String getNombreDepositante() {
        return nombreDepositante;
    }

    public void setNombreDepositante(String nombreDepositante) {
        this.nombreDepositante = nombreDepositante;
    }

    public long getValor() {
        return valor;
    }

    public void setValor(long valor) {
        this.valor = valor;
    }

    public Clientes getCliente() {
        return cliente;
    }

    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }

    public Empleados getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleados empleado) {
        this.empleado = empleado;
    }

    public TipoTransaccion getTransaccion() {
        return transaccion;
    }

    public void setTransaccion(TipoTransaccion transaccion) {
        this.transaccion = transaccion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOperacion != null ? idOperacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Operaciones)) {
            return false;
        }
        Operaciones other = (Operaciones) object;
        if ((this.idOperacion == null && other.idOperacion != null) || (this.idOperacion != null && !this.idOperacion.equals(other.idOperacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "banco.vo.Operaciones[ idOperacion=" + idOperacion + " ]";
    }
    
}
