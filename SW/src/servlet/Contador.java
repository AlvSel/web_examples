package servlet;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Contador extends HttpServlet{

	private static final long serialVersionUID = 6954869549118182609L;
	private int contador;
	private ServletConfig config;
	private final static String strFichero="fichero";
	
	//metodo para guardar el contador antes de finalizar y leerlo al empezar
	private synchronized int incrementa(){
		contador++;
		return contador;
	}
	
	public final void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		int n=incrementa();
		ServletOutputStream out=response.getOutputStream();
		response.setContentType("text/html); charset=UTF-8");
		out.println("<h1><p>Numero de accesos: "+n+"</p></h1>");
	}
	
	public final void init(final ServletConfig c) throws ServletException{
		config=c;
		ServletContext ctx= config.getServletContext();
		String fichero=config.getInitParameter(strFichero);
		try{
			BufferedReader f = new BufferedReader(new FileReader(ctx.getRealPath(fichero)));
			contador = Integer.parseInt(f.readLine());
			f.close();
		}catch(FileNotFoundException e){
			contador=0;
		}catch (IOException e) {
			contador=0;
		}
		
	}

	public final void destroy(){
		ServletContext ctx=config.getServletContext();
		String fichero= config.getInitParameter(strFichero);
		try{
			FileWriter f= new FileWriter(ctx.getRealPath(fichero));
			f.write(contador+"\n");
			f.close();
		}catch(IOException e){
			throw new RuntimeException(e.getLocalizedMessage());
		}
	}
}
