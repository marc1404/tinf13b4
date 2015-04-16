package com.vornetran.marc;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/halloduda")
public class HalloDuDa extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public HalloDuDa() {
        super();
    }

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String name = req.getParameter("name");
		
		OutputStreamWriter out = new OutputStreamWriter(new BufferedOutputStream(res.getOutputStream()));
		
		out.write("<!doctype html><html><head><title>HalloDuDa</title></head><body>");
		
		if(name != null){
			out.write("<h1>Hallo " + name + "</h1>");
		}else{
			out.write("<h1>Hallo Du Da</h1>");
		}
		
		out.write("<form>");
		out.write("<input type=\"text\" name=\"name\" placeholder=\"Wie ist dein Name?\">");
		out.write("</form>");
		out.write("</body></html>");
		out.flush();
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {}

}
