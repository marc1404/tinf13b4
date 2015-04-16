package com.vornetran.marc;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/sqrt")
public class SqrtServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

    public SqrtServlet() {
        super();
    }

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String paramX = req.getParameter("x");
		
		OutputStreamWriter out = new OutputStreamWriter(new BufferedOutputStream(res.getOutputStream()));
		
		out.write("<!doctype html><html><head>");
		out.write("<title>Wurzelzieher v4.8.15</title>");
		out.write("<link href=\"https://maxcdn.bootstrapcdn.com/bootswatch/3.3.4/cosmo/bootstrap.min.css\" rel=\"stylesheet\">");
		out.write("</head><body>");
		out.write("<div class=\"container\"><div class=\"row\"><div class=\"col-xs-12 col-sm-6\">");
		out.write("<h1>Wurzelzieher v4.8.15</h1>");
		out.write("<form>");
		out.write("<input type=\"number\" name=\"x\" placeholder=\"Quadratzahl\" class=\"form-control\">");
		out.write("</form>");
		
		if(paramX != null){
			int x = Integer.parseInt(paramX);
			
			out.write("<hr>");
			out.write("Die Quadratwurzel von <code>" + x + "</code> ist <code>" + Math.sqrt(x) + "</code>");
		}
		
		out.write("</div></div></div>");
		out.write("</body></html>");
		out.flush();
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {}

}
