package com.vornetran.marc.servlets;

import com.vornetran.marc.beans.Address;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Marc on 30.04.2015.
 */
@WebServlet("/delete")
public class DeleteAddress extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String paramId = request.getParameter("id");

        if(paramId == null) {
            response.sendError(400);
            return;
        }

        int id;

        try{
            id = Integer.parseInt(paramId);
        }catch(Exception ex){
            ex.printStackTrace();
            response.sendError(400);
            return;
        }

        Address address = new Address(id);

        address.delete();
        response.sendRedirect("/AddressList.jsp");
    }

}
