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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author 41411803
 */
@Entity
@Table(name = "JOGO_USER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "JogoUser.findAll", query = "SELECT j FROM JogoUser j"),
    @NamedQuery(name = "JogoUser.findByIdJogo", query = "SELECT j FROM JogoUser j WHERE j.idJogo = :idJogo"),
    @NamedQuery(name = "JogoUser.findByNomeJogo", query = "SELECT j FROM JogoUser j WHERE j.nomeJogo = :nomeJogo"),
    @NamedQuery(name = "JogoUser.findByTempJogado", query = "SELECT j FROM JogoUser j WHERE j.tempJogado = :tempJogado")})
public class JogoUser implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_JOGO")
    private Long idJogo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "NOME_JOGO")
    private String nomeJogo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "TEMP_JOGADO")
    private Double tempJogado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codJogo")
    private Collection<Ranking> rankingCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codJogo")
    private Collection<Usuario> usuarioCollection;

    public JogoUser() {
    }

    public JogoUser(Long idJogo) {
        this.idJogo = idJogo;
    }

    public JogoUser(Long idJogo, String nomeJogo) {
        this.idJogo = idJogo;
        this.nomeJogo = nomeJogo;
    }

    public Long getIdJogo() {
        return idJogo;
    }

    public void setIdJogo(Long idJogo) {
        this.idJogo = idJogo;
    }

    public String getNomeJogo() {
        return nomeJogo;
    }

    public void setNomeJogo(String nomeJogo) {
        this.nomeJogo = nomeJogo;
    }

    public Double getTempJogado() {
        return tempJogado;
    }

    public void setTempJogado(Double tempJogado) {
        this.tempJogado = tempJogado;
    }

    @XmlTransient
    public Collection<Ranking> getRankingCollection() {
        return rankingCollection;
    }

    public void setRankingCollection(Collection<Ranking> rankingCollection) {
        this.rankingCollection = rankingCollection;
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
        hash += (idJogo != null ? idJogo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof JogoUser)) {
            return false;
        }
        JogoUser other = (JogoUser) object;
        if ((this.idJogo == null && other.idJogo != null) || (this.idJogo != null && !this.idJogo.equals(other.idJogo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.br.lp3.entities.JogoUser[ idJogo=" + idJogo + " ]";
    }
    
}
