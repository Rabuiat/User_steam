/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author 41411803
 */
@Entity
@Table(name = "SUMMARIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Summario.findAll", query = "SELECT s FROM Summario s"),
    @NamedQuery(name = "Summario.findByIdSummario", query = "SELECT s FROM Summario s WHERE s.idSummario = :idSummario"),
    @NamedQuery(name = "Summario.findBySummario", query = "SELECT s FROM Summario s WHERE s.summario = :summario")})
public class Summario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_SUMMARIO")
    private Long idSummario;
    @Size(max = 300)
    @Column(name = "SUMMARIO")
    private String summario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codSummario")
    private Collection<Usuario> usuarioCollection;

    public Summario() {
    }

    public Summario(Long idSummario) {
        this.idSummario = idSummario;
    }

    public Long getIdSummario() {
        return idSummario;
    }

    public void setIdSummario(Long idSummario) {
        this.idSummario = idSummario;
    }

    public String getSummario() {
        return summario;
    }

    public void setSummario(String summario) {
        this.summario = summario;
    }

    @XmlTransient
    public Collection<Usuario> getUsuarioCollection() {
        return usuarioCollection;
    }

    public void setUsuarioCollection(Collection<Usuario> usuarioCollection) {
        this.usuarioCollection = usuarioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSummario != null ? idSummario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Summario)) {
            return false;
        }
        Summario other = (Summario) object;
        if ((this.idSummario == null && other.idSummario != null) || (this.idSummario != null && !this.idSummario.equals(other.idSummario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.br.lp3.entities.Summario[ idSummario=" + idSummario + " ]";
    }
    
}
