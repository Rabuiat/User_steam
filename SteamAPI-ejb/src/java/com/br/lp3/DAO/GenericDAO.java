/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.DAO;

import java.util.List;
import javax.ejb.Local;


/**
 *
 * @author 31596861
     * @param <E>
 */
@Local
public interface GenericDAO<E>{
    public void persist(E e);// CREATE - UPDATE
    public List<E> find();// READ
    public E findById(long id);
    public void remove(E e);//DELETE  
    
}
