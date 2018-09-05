package ntpajax;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.google.gson.Gson;

public class NTPajax extends HttpServlet {
	private static final long serialVersionUID = -3394337839838818701L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {	
		Calendar cal = Calendar.getInstance();
		System.out.println(cal.getCalendarType());
		response.setContentType("text/xml");
		PrintWriter out = response.getWriter();

		out.print("<?xml version=\"1.0\"?>");
		out.print("<time>");
		out.print("<day>" + cal.get(Calendar.DAY_OF_MONTH) + "</day>");
		out.print("<month>" + (cal.get(Calendar.MONTH)+1) + "</month>");
		out.print("<year>" + cal.get(Calendar.YEAR) + "</year>");
		out.print("<hour>" + cal.get(Calendar.HOUR_OF_DAY) + "</hour>");
		out.print("<minute>" + cal.get(Calendar.MINUTE) + "</minute>");
		out.print("<second>" + cal.get(Calendar.SECOND) + "</second>");
		out.print("</time>");

		out.flush();
		out.close();

		// Log
		System.out.println("XML ntp servlet has been hit");
		System.out.println(cal.getTime());
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		Calendar cal = Calendar.getInstance();
		response.setContentType("application/json");
		
		
		PrintWriter out = response.getWriter();

		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		hashMap.put("day", cal.get(Calendar.DAY_OF_MONTH));
		hashMap.put("month", cal.get(Calendar.MONTH)+1);
		hashMap.put("year", cal.get(Calendar.YEAR));
		hashMap.put("hour", cal.get(Calendar.HOUR_OF_DAY));
		hashMap.put("minute", cal.get(Calendar.MINUTE));
		hashMap.put("second", cal.get(Calendar.SECOND));

		Gson gson = new Gson();
		String json = gson.toJson(hashMap);
		response.setContentType("application/json");

		out.println(json);
		out.flush();
		out.close();

		// Log
		System.out.println("JSON ntp servlet has been hit");
		System.out.println(json);
	}

}