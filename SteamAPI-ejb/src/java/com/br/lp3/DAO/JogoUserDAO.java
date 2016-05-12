/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.DAO;

import com.br.lp3.entities.JogoUser;
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
public class JogoUserDAO implements GenericDAO <JogoUser> {
    
    @PersistenceContext(unitName = "STEAMPU", type = PersistenceContextType.TRANSACTION)
    private EntityManager em;

    @Override
    public void persist(JogoUser e) {
        try{
            em.persist(e);
        } catch (Exception ex){
            throw new DBException(DBExceptionEnum.PERSIST_ERROR);
        }
    }

    @Override
    public List<JogoUser> find() {
         List<JogoUser> lista = em.createNamedQuery("JogoUser.findAll", JogoUser.class).getResultList();
        if(lista==null || lista.isEmpty()) throw new DBException(DBExceptionEnum.FIND_ERROR);
        return lista;
    }

    @Override
    public JogoUser findById(long id) {
        JogoUser jogoUser = em.find(JogoUser.class, id);
        if(jogoUser==null) 
            throw new DBException(DBExceptionEnum.FIND_ERROR);
        return jogoUser;
    }

    @Override
    public void remove(JogoUser e) {
                try{
            em.remove(e);
        } catch (Exception ex){
            throw new DBException(DBExceptionEnum.PERSIST_ERROR);
        }
    }
    
}
