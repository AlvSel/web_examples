package shareinfo;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.google.gson.Gson;

import helper.db.*;
import helper.info.*;

public class MsgAjax extends HttpServlet {

	private MySQLdb mySQLdb;
	
	public void init(ServletConfig config) {
		System.out.println("---> Entering init() MsgAjax");
		mySQLdb = new MySQLdb();
		System.out.println("---> Exiting init() MsgAjax");
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		ArrayList<MessageInfo> messageList = mySQLdb.getAllMessages();
		System.out.println("Numero de mensajes: " + messageList.size() );
		response.setContentType("application/json");
		
		PrintWriter out = response.getWriter();
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		hashMap.put("msglist", messageList);
					
		Gson gson = new Gson();
		String json = gson.toJson(messageList);
	
		out.println(json);
		out.flush();
		out.close();

		// Log
		System.out.println("JSON MsgAjax servlet has been hit");
		System.out.println(json);
	}
}