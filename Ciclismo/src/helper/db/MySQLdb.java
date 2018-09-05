package helper.db;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

import helper.info.MessageInfo;

public class MySQLdb {
	private String url = "jdbc:mysql://localhost:3306/";
    private String user = "root"; 
    private String passwd = "";
	private String driver = "com.mysql.jdbc.Driver";
	
    private static Connection conn;
	
	public MySQLdb() {
		try {
        	Class.forName(this.driver).newInstance();
        	conn = DriverManager.getConnection(this.url,this.user,this.passwd);
    	} catch(Exception e) {
        	System.out.println("Exception: " + e.getMessage());
    	}
	}

	public boolean existeUsuario(String pUser){
		boolean existe=false;
		String query = "SELECT nombre FROM ciclismo.usuario WHERE usuario= '"+pUser+"';";
		System.out.println("     DB query: " + query);
    	try {
	    	Statement st = conn.createStatement();
        	ResultSet res = st.executeQuery(query); 
        	if(res.next()) {
        		existe=true;
        	} 	
        } catch(Exception e) {
        	System.out.println("Exception: " + e.getMessage());
    	}		
		return existe;
	}
	
	//PRE: no existe 'usuario' en la BD
	public void registrarUsuario(String usuario, String password,String nombre, String apellidos, String calle, String cp, 
																					String ciudad, String email, String tlf) {
		String query = "INSERT INTO ciclismo.usuario VALUES ('" + usuario + "','" + password + "','" + nombre + "', '" + apellidos 
						+ "', '" + calle + "', '" + cp + "', '" + ciudad + "', '" + email + "', '" + tlf + "' , 'N');";
		System.out.println("     DB query: " + query);
    	try {
	    	Statement st = conn.createStatement();
	    	st.executeUpdate(query);  	
        } catch(Exception e) {
        	System.out.println("Exception: " + e.getMessage());
    	}
	}
	
	public void actualizarUsuario(String nombre, String apellidos, String calle, String cp, 
																	String ciudad, String email, String tlf, String username) {
		String query = "UPDATE ciclismo.usuario SET nombre='" + nombre + "', apellidos= '" + apellidos 
											+ "', calle= '" + calle + "', cp= '" + cp + "', ciudad= '" + ciudad 
											+ "', email= '" + email + "', tlf= '" + tlf + "' "
											+ "WHERE usuario= '"+username+"';";
		System.out.println("     DB query: " + query);
		try {
			Statement st = conn.createStatement();
			st.executeUpdate(query);  	
		} catch(Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}
	}
	
	public boolean identificarUsuario(String pUser, String pPass){
		boolean correcto=false;
		String query = "SELECT nombre FROM ciclismo.usuario WHERE usuario= '"+pUser+"' AND password= '"+pPass+"';";
		System.out.println("     DB query: " + query);
    	try {
	    	Statement st = conn.createStatement();
        	ResultSet res = st.executeQuery(query); 
        	if(res.next()) {
        		correcto=true;
        	} 	
        } catch(Exception e) {
        	System.out.println("Exception: " + e.getMessage());
    	}		
		return correcto;
	}
	
	public void updatePassword(String pUser, String pPass){
		String query = "UPDATE ciclismo.usuario SET password='" + pPass + "' WHERE usuario= '"+pUser+"';";
		System.out.println("     DB query: " + query);
		try {
			Statement st = conn.createStatement();
			st.executeUpdate(query);  	
		} catch(Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}
	}
	
	public String getLicencia(String pUser) {
		String query = "SELECT usuario.licencia FROM ciclismo.usuario WHERE usuario = '"+pUser+"';";
		System.out.println("     DB query: " + query);
		String licencia="N";
    	try {
	    	Statement st = conn.createStatement();
        	ResultSet res = st.executeQuery(query);
        	res.next();
        	licencia = res.getString("licencia");
        } catch(Exception e) {
        	System.out.println("Exception: " + e.getMessage());
    	}
    	return parseLicencia(licencia);
	}
	
	public void insertLicencia(String pLicencia, String pUsername){
		String query = "INSERT INTO ciclismo.licencia VALUES ('"+pUsername+"','"+pLicencia+"','"+LocalDateTime.now()+"');";
		System.out.println("     DB query: " + query);
		try {
			Statement st = conn.createStatement();
			st.executeUpdate(query);  	
		} catch(Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}
	}
	
	public void updateLicencia(String pUser, String pLicencia){
		String query = "UPDATE ciclismo.usuario SET licencia='" + pLicencia + "' WHERE usuario= '"+pUser+"';";
		System.out.println("     DB query: " + query);
		try {
			Statement st = conn.createStatement();
			st.executeUpdate(query);  	
		} catch(Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}
	}
	
	private String parseLicencia(String pLicencia){
		String licenciaCompleta="Sin Licencia";
		if(pLicencia.compareTo("M")==0){
			licenciaCompleta="Master";
		}else if(pLicencia.compareTo("E")==0){
			licenciaCompleta="Elite";
		}else if(pLicencia.compareTo("C")==0){
			licenciaCompleta="Cicloturista";
		}
		return licenciaCompleta;
	}
	
	public static ArrayList<MessageInfo> getAllLicenciasUsuario(String pUser) {
		String query = "SELECT * FROM ciclismo.licencia WHERE usuario='"+pUser+"' ORDER BY licencia.fechaTiempo DESC;";
		System.out.println("     DB query: " + query);
		ArrayList<MessageInfo> licenciasList = new ArrayList<MessageInfo>(); 
    	try {
	    	Statement st = conn.createStatement();
        	ResultSet res = st.executeQuery(query); 
        	while(res.next()) {
        		licenciasList.add(new MessageInfo(res.getString("usuario"), res.getString("licencia"), res.getString("fechaTiempo")));
        	} 	
        } catch(Exception e) {
        	System.out.println("Exception: " + e.getMessage());
    	}
    	return licenciasList;
	}
	
	public static ArrayList<MessageInfo> getAllLicencias() {
		String query = "SELECT * FROM ciclismo.licencia ORDER BY licencia.fechaTiempo DESC;";
		System.out.println("     DB query: " + query);
		ArrayList<MessageInfo> licenciasList = new ArrayList<MessageInfo>(); 
    	try {
	    	Statement st = conn.createStatement();
        	ResultSet res = st.executeQuery(query); 
        	while(res.next()) {
        		licenciasList.add(new MessageInfo(res.getString("usuario"), res.getString("licencia"), res.getString("fechaTiempo")));
        	} 	
        } catch(Exception e) {
        	System.out.println("Exception: " + e.getMessage());
    	}
    	return licenciasList;
	}
	
	public static ArrayList<String> getUsersConLicencia(){
		String query = "SELECT usuario FROM ciclismo.usuario WHERE licencia!='N';";
		System.out.println("     DB query: " + query);
		ArrayList<String> usersList = new ArrayList<String>(); 
    	try {
	    	Statement st = conn.createStatement();
        	ResultSet res = st.executeQuery(query); 
        	while(res.next()) {
        		usersList.add(res.getString("usuario"));
        	} 	
        } catch(Exception e) {
        	System.out.println("Exception: " + e.getMessage());
    	}
    	return usersList;
	}
	
	public void retirarLicencia(String pUser){
		String query = "UPDATE ciclismo.usuario SET licencia='N' WHERE usuario= '"+pUser+"';";
		System.out.println("     DB query: " + query);
		try {
			Statement st = conn.createStatement();
			st.executeUpdate(query);  	
		} catch(Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}
	}
}