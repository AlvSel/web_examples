package servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import helper.db.*;

public class Certificado extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private MySQLdb mySQLdb;
	//public static HttpSession sesion;
	
	public void init(final ServletConfig config) {
		System.out.println("---> Entering init() MainServlet");
		mySQLdb = new MySQLdb();
		System.out.println("---> Exiting init() MainServlet");
	}

    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    	System.out.println("---> Entering doPost() CertificadoServel");
    	System.out.println("Creando documento pdf.");
    	processRequest(request, response);
    	System.out.println("Documento creado.");
        System.out.println("---> Exiting doPost() CertificadoServel");
    }
	
    //http://thinktibits.blogspot.com.es/2011/06/java-itext-pdf-servlet-example-tutorial.html
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{	
		HttpSession sesion = request.getSession();
        //Set content type to application / pdf
        //browser will open the document only if this is set
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment;filename=certificado_"+sesion.getAttribute("username").toString()+".pdf");
        //Get the output stream for writing PDF object        
        OutputStream out=response.getOutputStream();
        Document document = new Document();
    	try{
        	PdfWriter.getInstance(document, out);
        	document.open();
        	document.addAuthor("Federación Vasca de Ciclismo");
        	document.addTitle("Certificado Federación Vasca de Ciclismo");
        	document.add(new Paragraph("Federación Vasca de Ciclismo\n\n\n\n"));
        	document.add(new Paragraph("\tEl usuario "+sesion.getAttribute("username").toString()+" posee una licencia de tipo: "+mySQLdb.getLicencia(sesion.getAttribute("username").toString())));
        	document.close();
        }
        catch (DocumentException exc){
        	exc.printStackTrace();
        }
        finally {            
            out.close();
        }
    }
}
