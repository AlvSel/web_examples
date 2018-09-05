package servlet;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.google.gson.Gson;

import helper.db.*;
import helper.info.*;

public class LicenciasAllAjax extends HttpServlet {

	private static final long serialVersionUID = 3819131950680525278L;
	
	public void init(ServletConfig config) {
		System.out.println("---> Entering init() LicenciasAjax");
		System.out.println("---> Exiting init() LicenciasAjax");
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		ArrayList<MessageInfo> licenciasList = MySQLdb.getAllLicencias();
		System.out.println("Numero de licencias: " + licenciasList.size() );
		response.setContentType("application/json");
		
		PrintWriter out = response.getWriter();
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		hashMap.put("licenciaslist", licenciasList);
					
		Gson gson = new Gson();
		String json = gson.toJson(licenciasList);
	
		out.println(json);
		out.flush();
		out.close();

		// Log
		System.out.println("JSON LicenciasAjax servlet has been hit");
		System.out.println(json);
	}
}