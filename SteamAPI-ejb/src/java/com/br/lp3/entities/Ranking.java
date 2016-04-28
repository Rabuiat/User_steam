/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.entities;

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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 41411803
 */
@Entity
@Table(name = "RANKING")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ranking.findAll", query = "SELECT r FROM Ranking r"),
    @NamedQuery(name = "Ranking.findByIdBusca", query = "SELECT r FROM Ranking r WHERE r.idBusca = :idBusca"),
    @NamedQuery(name = "Ranking.findByPorcentagem", query = "SELECT r FROM Ranking r WHERE r.porcentagem = :porcentagem")})
public class Ranking implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_BUSCA")
    private Long idBusca;
    @Size(max = 50)
    @Column(name = "PORCENTAGEM")
    private String porcentagem;
    @JoinColumn(name = "COD_JOGO", referencedColumnName = "ID_JOGO")
    @ManyToOne(optional = false)
    private JogoUser codJogo;
    @JoinColumn(name = "COD_USER", referencedColumnName = "ID_USER")
    @ManyToOne(optional = false)
    private Usuario codUser;

    public Ranking() {
    }

    public Ranking(Long idBusca) {
        this.idBusca = idBusca;
    }

    public Long getIdBusca() {
        return idBusca;
    }

    public void setIdBusca(Long idBusca) {
        this.idBusca = idBusca;
    }

    public String getPorcentagem() {
        return porcentagem;
    }

    public void setPorcentagem(String porcentagem) {
        this.porcentagem = porcentagem;
    }

    public JogoUser getCodJogo() {
        return codJogo;
    }

    public void setCodJogo(JogoUser codJogo) {
        this.codJogo = codJogo;
    }

    public Usuario getCodUser() {
        return codUser;
    }

    public void setCodUser(Usuario codUser) {
        this.codUser = codUser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBusca != null ? idBusca.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ranking)) {
            return false;
        }
        Ranking other = (Ranking) object;
        if ((this.idBusca == null && other.idBusca != null) || (this.idBusca != null && !this.idBusca.equals(other.idBusca))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.br.lp3.entities.Ranking[ idBusca=" + idBusca + " ]";
    }
    
}
