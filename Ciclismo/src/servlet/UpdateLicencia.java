package servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import helper.db.*;

public class UpdateLicencia extends HttpServlet{
	
	/***/
	private static final long serialVersionUID = 1L;
	private MySQLdb mySQLdb;

	public void init(final ServletConfig config) {
		System.out.println("---> Entering init() UpdateLicencia");
		
		mySQLdb = new MySQLdb();
		
		System.out.println("---> Exiting init() UpdateLicencia");
	}

    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    	System.out.println("---> Entering doPost() UpdateLicencia");
    	HttpSession sesion= request.getSession();
		String licencia = request.getParameter("licencia");	
		System.out.println("     Extracting request parameters: ");

		mySQLdb.updateLicencia(sesion.getAttribute("username").toString(), licencia);
		mySQLdb.insertLicencia(licencia,sesion.getAttribute("username").toString());
		System.out.println("     Updating licencia in the database");
		
		System.out.println("     Redirecting the user to menuPrincipal.jsp");
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/menuPrincipal.jsp");
		rd.forward(request, response);
		
        System.out.println("---> Exiting doPost() UpdateLicencia");
    }
    
    /*public String getLicencia(){
    	return mySQLdb.getLicencia(sesion.getAttribute("username").toString());
    }*/
}