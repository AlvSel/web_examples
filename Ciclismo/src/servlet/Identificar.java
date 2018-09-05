package servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import helper.db.*;

public class Identificar extends HttpServlet{
	
	/***/
	private static final long serialVersionUID = 1L;
	private MySQLdb mySQLdb;
	public static HttpSession sesion;
	
	public void init(final ServletConfig config) {
		System.out.println("---> Entering init() MainServlet");
		mySQLdb = new MySQLdb();
		System.out.println("---> Exiting init() MainServlet");
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("---> Entering doGet() Identificar");		
        doPost(request, response);
        System.out.println("---> Exiting doGet() Identificar");
    }
	
    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    	System.out.println("---> Entering doPost() IdentificarServlet");
    	System.out.println("     Extracting request parameters: ");
    	String usuario = request.getParameter("usuario");
    	String password = request.getParameter("password");
		System.out.println("     Comprobando user y pass");
		if(mySQLdb.identificarUsuario(usuario, password)){			
    		System.out.println("Creando sesion");
    		sesion= request.getSession(true);
    		String sesionID = sesion.getId();
    		sesion.setAttribute("username", usuario);
    		System.out.println("Sesion creada para "+sesion.getAttribute("username").toString()+" con identificador "+sesionID);	
    		if(usuario.compareTo("admin")==0){
    			sesion.setAttribute("tipoSesion", "admin");
    			System.out.println("Sesion de administrador iniciada.");
    			response.sendRedirect("/Ciclismo/servlet/MenuAdminServlet");
    		}
    		else{
    			sesion.setAttribute("tipoSesion", "usuario");
    			System.out.println("Sesion de usuario iniciada.");
    			response.sendRedirect("/Ciclismo/servlet/MenuPrincipalServlet");
    		}
	        System.out.println("---> Exiting doPost() IdentificarServlet");
    	}else{
    		System.out.println("Necesarios usuario y pass.");
    		System.out.println("     Redirecting the user to identificar.jsp");
    		request.setAttribute("error", "ERROR");
    		RequestDispatcher rd = request.getRequestDispatcher("/jsp/identificarUsuario.jsp");
    		rd.forward(request, response);
            System.out.println("---> Exiting doPost() IdentificarServlet");
    	}
    }
}

