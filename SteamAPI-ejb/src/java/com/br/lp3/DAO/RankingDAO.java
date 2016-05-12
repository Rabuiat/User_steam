/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.DAO;

import com.br.lp3.entities.Ranking;
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
public class RankingDAO implements GenericDAO <Ranking> {
    
    @PersistenceContext(unitName = "STEAMPU", type = PersistenceContextType.TRANSACTION)
    private EntityManager em;

    @Override
    public void persist(Ranking e) {
        try{
            em.persist(e);
        } catch (Exception ex){
            throw new DBException(DBExceptionEnum.PERSIST_ERROR);
        }
    }

    @Override
    public List<Ranking> find() {
         List<Ranking> lista = em.createNamedQuery("Ranking.findAll", Ranking.class).getResultList();
        if(lista==null || lista.isEmpty()) throw new DBException(DBExceptionEnum.FIND_ERROR);
        return lista;
    }

    @Override
    public Ranking findById(long id) {
        Ranking ranking = em.find(Ranking.class, id);
        if(ranking==null) 
            throw new DBException(DBExceptionEnum.FIND_ERROR);
        return ranking;
    }

    @Override
    public void remove(Ranking e) {
                try{
            em.remove(e);
        } catch (Exception ex){
            throw new DBException(DBExceptionEnum.PERSIST_ERROR);
        }
    }
    
}
