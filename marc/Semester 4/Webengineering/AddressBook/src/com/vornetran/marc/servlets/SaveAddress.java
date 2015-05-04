package com.vornetran.marc.servlets;

import com.vornetran.marc.beans.Address;
import com.vornetran.marc.models.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Marc on 30.04.2015.
 */
@WebServlet("/save")
public class SaveAddress extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String[] paramNames = { "id", "addressForm", "christianName", "name", "street", "number", "postcode", "city", "country", "email", "phone", "mobile", "birthday" };
        Map<String, String> params = new HashMap<>();

        for(String paramName:paramNames){
            String param = request.getParameter(paramName);
            System.out.println(paramName + " = " + param);
            if(param == null && !paramName.equals("id")){
                sendErrorRedirect(request, response, "Alle Felder müssen ausgefüllt werden!");
                return;
            }

            params.put(paramName, param);
        }

        String paramId = params.get("id");
        Integer id = null;

        if(paramId != null) {
            try {
                id = Integer.parseInt(paramId);
            } catch (Exception ex) {
                ex.printStackTrace();
                response.sendError(400);
                return;
            }
        }

        int number;

        try{
            number = Integer.parseInt(params.get("number"));
        }catch(Exception ex){
            ex.printStackTrace();
            sendErrorRedirect(request, response, "Die Hausnummer muss eine gültige Zahl sein!");
            return;
        }

        Birthday birthday;

        try{
            birthday = new Birthday(params.get("birthday"));
        }catch(Exception ex){
            ex.printStackTrace();
            sendErrorRedirect(request, response, "Der Geburtstag muss ein gültiges Datum sein!");
            return;
        }

        Name name = new Name(params.get("addressForm"), params.get("christianName"), params.get("name"));
        Street street = new Street(params.get("street"), number);
        City city = new City(params.get("postcode"), params.get("city"));
        String country = params.get("country");
        Location location = new Location(street, city, country);
        ContactDetails contactDetails = new ContactDetails(params.get("email"), params.get("phone"), params.get("mobile"));
        Address address = new Address(id, name, location, contactDetails, birthday);

        if(address.save()) {
            id = address.getId();

            response.sendRedirect("/Address.jsp?id=" + id);
        }else{
            sendErrorRedirect(request, response, "Ein unerwarteter Serverfehler ist aufgetreten!");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}

    private void sendErrorRedirect(HttpServletRequest request, HttpServletResponse response, String errorMessage) throws IOException {
        String url = "/AddressForm.jsp?error=" + errorMessage + "&";
        String id = request.getParameter("id");

        if(id != null){
            url += "id=" + id;
        }

        response.sendRedirect(url);
    }

}
