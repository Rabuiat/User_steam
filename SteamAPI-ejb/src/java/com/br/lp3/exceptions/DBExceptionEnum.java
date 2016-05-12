/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.exceptions;

/**
 *
 * @author 31596861
 */
public enum DBExceptionEnum {
    PERSIST_ERROR{
        @Override
        public String toString(){
            return "Erro na persistência!";
        } 
    }, 
    
    REMOVE_ERROR{
        @Override
        public String toString(){
            return "Erro na remoção!";
        } 
    }, 
    
    FIND_ERROR{
        @Override
        public String toString(){
            return "Erro na busca!";
        } 
    }
}