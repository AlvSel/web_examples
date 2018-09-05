package shareinfo;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import helper.db.*;

public class SignupServlet extends HttpServlet{
	
	/***/
	private static final long serialVersionUID = 1L;
	private MySQLdb mySQLdb;
	
	public void init(final ServletConfig config) {
		System.out.println("---> Entering init() SignupServlet");
		
		mySQLdb = new MySQLdb();
		
		System.out.println("---> Exiting init() SignupServlet");
	}

    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    	System.out.println("---> Entering doPost() SignupServlet");
    	
    	String email = request.getParameter("email");
		String password = request.getParameter("password");
		String nickname = request.getParameter("nickname");
		System.out.println("     Extracting request parameters: " + email + " " + password + " " + nickname);
		
		mySQLdb.setUserInfo(email, password, nickname);
		System.out.println("     Updating users table in the database");
		
		System.out.println("     Redirecting the user to loginForm.jsp");
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/loginForm.jsp");
		rd.forward(request, response);
		
        System.out.println("---> Exiting doPost() SignupServlet");
    }
}

