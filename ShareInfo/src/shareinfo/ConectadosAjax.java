package shareinfo;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.google.gson.Gson;

import helper.db.*;
import helper.info.*;

public class ConectadosAjax extends HttpServlet {

	private MySQLdb mySQLdb;
	
	public void init(ServletConfig config) {
		System.out.println("---> Entering init() ConectadosAjax");
		mySQLdb = new MySQLdb();
		System.out.println("---> Exiting init() ConectadosAjax");
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		ServletContext context = request.getServletContext();
		HashMap<String, String> loggedinUsers = (HashMap) context.getAttribute("loggedin_users");
		response.setContentType("application/json");
		
		PrintWriter out = response.getWriter();
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		hashMap.put("userlist", loggedinUsers);
					
		Gson gson = new Gson();
		String json = gson.toJson(loggedinUsers);
	
		out.println(json);
		out.flush();
		out.close();

		// Log
		System.out.println("JSON MsgAjax servlet has been hit");
		System.out.println(json);
	}

}