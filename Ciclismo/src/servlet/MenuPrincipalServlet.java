package servlet;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

public class MenuPrincipalServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	public void init(ServletConfig config) {
		System.out.println("---> Entering init() MenuPrincipalServlet");
		System.out.println("---> Exiting init() MenuPrincipalServlet");
	}
	
    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        System.out.println("---> Entering doGet() MenuPrincipalServlet");		
        doPost(request, response);
        System.out.println("---> Exiting doGet() MenuPrincipalServlet");
    }
    
    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    	System.out.println("---> Entering doPost() MenuPrincipalServlet");
		System.out.println("     Redirecting the user to menuPrincipal.jsp");
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/menuPrincipal.jsp");
		rd.forward(request, response);
    }
}
