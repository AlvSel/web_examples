package servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import helper.db.*;

public class Registro extends HttpServlet{
	
	/***/
	private static final long serialVersionUID = 1L;
	private MySQLdb mySQLdb;
	
	public void init(final ServletConfig config) {
		System.out.println("---> Entering init() MainServlet");
		
		mySQLdb = new MySQLdb();
		
		System.out.println("---> Exiting init() MainServlet");
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("---> Entering doGet() Registro");		
        doPost(request, response);
        System.out.println("---> Exiting doGet() Registro");
    }
	
    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    	System.out.println("---> Entering doPost() MainServlet");
		System.out.println("     Extracting request parameters: ");
    	String usuario = request.getParameter("usuario");
    	String password = request.getParameter("password");
		String nombre = request.getParameter("nombre");
    	String apellidos = request.getParameter("apellidos");
    	String calle = request.getParameter("calle");
    	String cp = request.getParameter("cp");
    	String ciudad = request.getParameter("ciudad");
    	String email = request.getParameter("email");
    	String tlf = request.getParameter("tlf");
    	//ha rellenado minimo user y pass
    	if(usuario.length()>0&&password.length()>0){
    		if(!mySQLdb.existeUsuario(usuario)){
        		System.out.println("     Updating users table in the database");
    			mySQLdb.registrarUsuario(usuario, password,nombre, apellidos, calle, cp, ciudad, email, tlf);
        		System.out.println("     Redirecting the user to inicio.jsp");
        		RequestDispatcher rd = request.getRequestDispatcher("/jsp/identificarUsuario.jsp");
        		rd.forward(request, response);
    		}else{
    			request.setAttribute("error", "existe");
        		System.out.println("     Redirecting the user to registrarUsuario.jsp");
        		RequestDispatcher rd = request.getRequestDispatcher("/jsp/registrarUsuario.jsp");
        		rd.forward(request, response);
    		}
            System.out.println("---> Exiting doPost() MainServlet");
    	}else{
    		System.out.println("Necesarios usuario y pass.");
    		request.setAttribute("error", "datos");
    		System.out.println("     Redirecting the user to registrarUsuario.jsp");
    		RequestDispatcher rd = request.getRequestDispatcher("/jsp/registrarUsuario.jsp");
    		rd.forward(request, response);
            System.out.println("---> Exiting doPost() MainServlet");
	
    	}
    }
}

