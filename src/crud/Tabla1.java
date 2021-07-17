/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author PEREIRA
 */
@Entity
@Table(name = "tabla1", catalog = "crud", schema = "public")
@NamedQueries({
    @NamedQuery(name = "Tabla1.findAll", query = "SELECT t FROM Tabla1 t"),
    @NamedQuery(name = "Tabla1.findByNumero", query = "SELECT t FROM Tabla1 t WHERE t.numero = :numero"),
    @NamedQuery(name = "Tabla1.findByNombre", query = "SELECT t FROM Tabla1 t WHERE t.nombre = :nombre"),
    @NamedQuery(name = "Tabla1.findByAddress", query = "SELECT t FROM Tabla1 t WHERE t.address = :address")})
public class Tabla1 implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "numero")
    private Short numero;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "address")
    private String address;

    public Tabla1() {
    }

    public Tabla1(Short numero) {
        this.numero = numero;
    }

    public Short getNumero() {
        return numero;
    }

    public void setNumero(Short numero) {
        Short oldNumero = this.numero;
        this.numero = numero;
        changeSupport.firePropertyChange("numero", oldNumero, numero);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        String oldNombre = this.nombre;
        this.nombre = nombre;
        changeSupport.firePropertyChange("nombre", oldNombre, nombre);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        String oldAddress = this.address;
        this.address = address;
        changeSupport.firePropertyChange("address", oldAddress, address);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numero != null ? numero.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tabla1)) {
            return false;
        }
        Tabla1 other = (Tabla1) object;
        if ((this.numero == null && other.numero != null) || (this.numero != null && !this.numero.equals(other.numero))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "crud.Tabla1[ numero=" + numero + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
