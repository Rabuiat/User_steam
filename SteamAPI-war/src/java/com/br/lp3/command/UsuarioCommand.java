/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.command;

import com.br.lp3.DAO.UsuarioDAO;
import com.br.lp3.entities.Usuario;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Rafael
 */
public class UsuarioCommand implements Command{

    UsuarioDAO usuarioDAO = lookupUsuarioDAOBean();
  
    
    private String returnPage = "index.jsp";
    private HttpServletRequest request;
    private HttpServletResponse response;

    @Override
    public void init(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }

    @Override
    public void execute() {
        String action = request.getParameter("action");
        switch(action){
            case "registrar":
                String nome = request.getParameter("nome");
                String pwd1 = request.getParameter("pwd1");
                String pwd2 = request.getParameter("pwd2");
                String email = request.getParameter("email");
                
                Usuario usuario = new Usuario();
                usuario.setEmail(email);
                usuario.setNome(nome);
                usuario.setSenha(pwd2);
                
                usuarioDAO.persist(usuario);
                
                System.out.println(usuario);
                System.out.println("_________________________________________________________________________________");
                
                break;
            
            
            
        }
    }

    @Override
    public String getReturnPage() {
        return returnPage;
    }

    private UsuarioDAO lookupUsuarioDAOBean() {
        try {
            Context c = new InitialContext();
            return (UsuarioDAO) c.lookup("java:global/SteamAPI/SteamAPI-ejb/UsuarioDAO!com.br.lp3.DAO.UsuarioDAO");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }


    
}
