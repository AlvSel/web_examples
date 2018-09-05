package servlet;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

public class MainServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	public void init(ServletConfig config) {
		System.out.println("---> Entering init() MainServlet");
		System.out.println("---> Exiting init() MainServlet");
	}
	
    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        System.out.println("---> Entering doGet() MainServlet");		
        doPost(request, response);
        System.out.println("---> Exiting doGet() MainServlet");
    }
    
    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    	System.out.println("---> Entering doPost() MainServlet");
		System.out.println("     Redirecting the user to inicio.jsp");
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/inicio.jsp");
		rd.forward(request, response);
    }
}