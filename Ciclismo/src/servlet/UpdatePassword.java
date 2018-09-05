package servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import helper.db.*;

public class UpdatePassword extends HttpServlet{
	
	/***/
	private static final long serialVersionUID = 1L;
	private MySQLdb mySQLdb;
	
	public void init(final ServletConfig config) {
		System.out.println("---> Entering init() UpdatePasswordServlet");
		mySQLdb = new MySQLdb();
		System.out.println("---> Exiting init() UpdatePasswordServlet");
	}

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	System.out.println("---> Entering doPost() UpdatePasswordServlet");
    	HttpSession sesion = request.getSession();
		System.out.println("     Extracting request parameters: ");
    	String actual = request.getParameter("actual");
    	String pass1 = request.getParameter("nueva1");
    	String pass2 = request.getParameter("nueva2");
    	
    	if(mySQLdb.identificarUsuario(sesion.getAttribute("username").toString(), actual)&&pass1.compareTo(pass2)==0){
    		System.out.println("     Updating password");
    		mySQLdb.updatePassword(sesion.getAttribute("username").toString(), pass1);
    		
    		if(sesion.getAttribute("tipoSesion").toString().compareTo("admin")==0){
    			response.sendRedirect("/Ciclismo/servlet/MenuAdminServlet");
    		}else{
    			response.sendRedirect("/Ciclismo/servlet/MenuPrincipalServlet");
    		}
    		
            System.out.println("---> Exiting doPost() UpdatePasswordServlet");
    	}else{
    		System.out.println("Necesario que sea correcta password actual y sean iguales las nuevas.");
    		System.out.println("     Redirecting the user to updatePassword.jsp");
    		request.setAttribute("error", "ERROR");
    		RequestDispatcher rd = request.getRequestDispatcher("/jsp/updatePassword.jsp");
    		rd.forward(request, response);
            System.out.println("---> Exiting doPost() UpdatePasswordServlet");
	
    	}
    }
}