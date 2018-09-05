package servlet;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

public class MenuAdminServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	public void init(ServletConfig config) {
		System.out.println("---> Entering init() MenuAdminServlet");
		System.out.println("---> Exiting init() MenuAdminServlet");
	}
	
    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        System.out.println("---> Entering doGet() MenuAdminServlet");		
        doPost(request, response);
        System.out.println("---> Exiting doGet() MenuAdminServlet");
    }
    
    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    	System.out.println("---> Entering doPost() MenuAdminServlet");
		System.out.println("     Redirecting the user to menuPrincipal.jsp");
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/menuAdmin.jsp");
		rd.forward(request, response);
    }
}
