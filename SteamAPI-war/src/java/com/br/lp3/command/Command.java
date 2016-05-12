/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 41411803
 */
public interface Command {

    public void init(HttpServletRequest request, HttpServletResponse response);

    public void execute();

    public String getReturnPage();

}
