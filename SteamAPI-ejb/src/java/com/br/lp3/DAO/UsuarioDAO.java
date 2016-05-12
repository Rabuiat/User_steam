/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.DAO;

import com.br.lp3.entities.Usuario;
import com.br.lp3.exceptions.DBException;
import com.br.lp3.exceptions.DBExceptionEnum;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

/**
 *
 * @author 31596861
 */
@Stateful
@LocalBean
public class UsuarioDAO implements GenericDAO <Usuario> {
    
    @PersistenceContext(unitName = "STEAMPU", type = PersistenceContextType.TRANSACTION)
    private EntityManager em;

    @Override
    public void persist(Usuario e) {
        try{
            em.persist(e);
        } catch (Exception ex){
            throw new DBException(DBExceptionEnum.PERSIST_ERROR);
        }
    }

    @Override
    public List<Usuario> find() {
         List<Usuario> lista = em.createNamedQuery("Usuario.findAll", Usuario.class).getResultList();
        if(lista==null || lista.isEmpty()) throw new DBException(DBExceptionEnum.FIND_ERROR);
        return lista;
    }

    @Override
    public Usuario findById(long id) {
        Usuario user = em.find(Usuario.class, id);
        if(user==null) 
            throw new DBException(DBExceptionEnum.FIND_ERROR);
        return user;
    }

    @Override
    public void remove(Usuario e) {
        try{
            em.remove(e);
        } catch (Exception ex){
            throw new DBException(DBExceptionEnum.PERSIST_ERROR);
        }
    }
    
}
