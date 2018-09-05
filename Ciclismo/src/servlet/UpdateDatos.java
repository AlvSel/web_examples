package servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import helper.db.*;

public class UpdateDatos extends HttpServlet{
	
	/***/
	private static final long serialVersionUID = 1L;
	private MySQLdb mySQLdb;
	
	public void init(final ServletConfig config) {
		System.out.println("---> Entering init() UpdateDatos");
		mySQLdb = new MySQLdb();
		System.out.println("---> Exiting init() UpdateDatos");
	}

    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    	System.out.println("---> Entering doPost() UpdateDatos");
		System.out.println("     Extracting request parameters: ");
    	HttpSession sesion = request.getSession();
		String nombre = request.getParameter("nombre");
    	String apellidos = request.getParameter("apellidos");
    	String calle = request.getParameter("calle");
    	String cp = request.getParameter("cp");
    	String ciudad = request.getParameter("ciudad");
    	String email = request.getParameter("email");
    	String tlf = request.getParameter("tlf");		
		System.out.println("     Updating users table in the database");
		mySQLdb.actualizarUsuario(nombre, apellidos, calle, cp, ciudad, email, tlf,sesion.getAttribute("username").toString());
		if(sesion.getAttribute("tipoSesion").toString().compareTo("admin")==0){
			response.sendRedirect("/Ciclismo/servlet/MenuAdminServlet");
		}else{
			response.sendRedirect("/Ciclismo/servlet/MenuPrincipalServlet");
		}
        System.out.println("---> Exiting doPost() UpdateDatos");
    }
}

