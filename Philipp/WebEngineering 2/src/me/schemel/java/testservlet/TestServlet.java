package me.schemel.java.testservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      PrintWriter w = response.getWriter();
	      
	      String name = request.getParameter("username");
	      
	      if(!(name == null)) {
	    	  if(name.equalsIgnoreCase("Simon")) {
	    		  throw new SimonSucksException("Simon sucks cocks in hell!");  
	    	  }
	      }
	      
	      if(!(name == null)) {
	    	  if(name.equalsIgnoreCase("error")) {
	    		  throw new ServletException();  
	    	  }
	      }
	      
	      
	      w.println("<!DOCTYPE HTML>");
	      w.println("<html>");
	      w.println("<head>");
	      w.println("</head>");
	      w.println("<body>");
	      if(!(name == null)) {
	    	  w.println("<h2>Hallo " + name + "</h2>");
	      } else {
	    	  w.println("<h2>Hallo du da</h2>");
	      }
	      
	      w.println("<form method=\"GET\">");
	      w.println("<input type=\"text\" name=\"username\" placeholder=\"Trage deinen Namen ein\" size=\"100\"/>");
	      w.println("</form>");
	      w.println("</body>");
	      w.println("</html>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
