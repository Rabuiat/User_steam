/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.DAO;

import com.br.lp3.entities.Summario;
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
public class SummarioDAO implements GenericDAO <Summario> {
    
    @PersistenceContext(unitName = "STEAMPU", type = PersistenceContextType.TRANSACTION)
    private EntityManager em;

    @Override
    public void persist(Summario e) {
        try{
            em.persist(e);
        } catch (Exception ex){
            throw new DBException(DBExceptionEnum.PERSIST_ERROR);
        }
    }

    @Override
    public List<Summario> find() {
         List<Summario> lista = em.createNamedQuery("Summario.findAll", Summario.class).getResultList();
        if(lista==null || lista.isEmpty()) throw new DBException(DBExceptionEnum.FIND_ERROR);
        return lista;
    }

    @Override
    public Summario findById(long id) {
        Summario sumario = em.find(Summario.class, id);
        if(sumario==null) 
            throw new DBException(DBExceptionEnum.FIND_ERROR);
        return sumario;
    }

    @Override
    public void remove(Summario e) {
        try{
            em.remove(e);
        } catch (Exception ex){
            throw new DBException(DBExceptionEnum.PERSIST_ERROR);
        }
    }
    
}
