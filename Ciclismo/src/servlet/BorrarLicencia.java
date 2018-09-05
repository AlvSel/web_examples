package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import helper.db.MySQLdb;

public class BorrarLicencia  extends HttpServlet{
	
	/***/
	private static final long serialVersionUID = 1L;
	private MySQLdb mySQLdb;
	
	public void init(final ServletConfig config) {
		System.out.println("---> Entering init() BorrarLicencia");
		mySQLdb = new MySQLdb();
		System.out.println("---> Exiting init() BorrarLicencia");
	}

    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    	System.out.println("---> Entering doPost() BorrarLicencia");
		System.out.println("     Extracting request parameters: ");
		String nombreUsuario = request.getParameter("nombreUsuario");		
		HttpSession sesion = request.getSession();
		if(sesion.getAttribute("tipoSesion").toString().compareTo("admin")==0){
			mySQLdb.retirarLicencia(nombreUsuario);
			System.out.println("Licencia retirada.");
			System.out.println("     Redirecting the user to menuAdmin.jsp");
			RequestDispatcher rd = request.getRequestDispatcher("/jsp/menuAdmin.jsp");
			rd.forward(request, response);
		}else{
			System.out.println("No eres admin!!");
			System.out.println("     Redirecting the user to menuPrincipal.jsp");
			RequestDispatcher rd = request.getRequestDispatcher("/jsp/menuPrincipal.jsp");
			rd.forward(request, response);
		}
        System.out.println("---> Exiting doPost() BorrarLicencia");
    }
}
