package shareinfo;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

import helper.db.*;

public class LoginServlet extends HttpServlet{
	/***/
	private static final long serialVersionUID = 1L;
	private MySQLdb mySQLdb;
	
	public void init(ServletConfig config) {
		System.out.println("---> Entering init() LoginServlet");
		
		mySQLdb = new MySQLdb();
		
		System.out.println("---> Exiting init() LoginServlet");
	}
 
    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    	System.out.println("---> Entering doGet() LoginServlet");
    	
    	String email = request.getParameter("email");
		String password = request.getParameter("password");
		System.out.println("     Extracting request parameters: " + email + " " + password);

		String username = mySQLdb.getUsername(email, password);
		if(username == null) {
			System.out.println("     Login error: redirecting the user to loginForm.html");
			
			request.setAttribute("error", "ERROR");
			//Anterior: RequestDispatcher rd = request.getRequestDispatcher("/html/loginForm.html");
			RequestDispatcher rd = request.getRequestDispatcher("/jsp/loginForm.jsp");
			rd.forward(request, response);
		} else {
			HttpSession session = request.getSession(true);
			String sessionID = session.getId();
			
			session.setAttribute("username", username);
			
			System.out.println("     User session for " + username + ": " + sessionID);
			System.out.print("     Getting loggedin userlist from servlet context: ");
			ServletContext context = request.getServletContext();
			HashMap<String, String> loggedinUsers = (HashMap) context.getAttribute("loggedin_users");
			if(loggedinUsers == null) {
				System.out.println("list is empty");
				loggedinUsers = new HashMap();
				loggedinUsers.put(username, sessionID);
			} else {
				if(!loggedinUsers.containsKey(username)) {
					System.out.println(username + " is not in the list");
					loggedinUsers.put(username, sessionID);
				} else {
					System.out.println(username + " is already in the list");
				}
			}
			context.setAttribute("loggedin_users", loggedinUsers);
			System.out.println("     Loggedin users: " + loggedinUsers.toString());
			
			System.out.println("     Redirecting the user to MainServlet");
			RequestDispatcher rd = context.getNamedDispatcher("MainServlet");
			rd.forward(request, response);
		}
		
		System.out.println("---> Exiting doGet() LoginServlet");
    }
}

