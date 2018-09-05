package lab5;

import java.sql.*;

public class Data {

	Connection connection;
	Statement statement;
	
	static final int LOCKING=1;
	static final int NONLOCKING=0;
	static final int NUMBER_OF_ITERATIONS = 100;
	
	public static void main(String[] args) {
		new Data();
	}

	public Data(){
		//Load MySQL driver
		try{
			Class.forName("org.gjt.mm.mysql.Driver");
		}
		catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		//Open connection
		try{
			connection = DriverManager.getConnection("jdbc:mysql://dbserver1516-4056g7og.cloudapp.net:3306","owner","ImTheOwner");
			connection.setAutoCommit(false);
			statement = connection.createStatement();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	/*public ResultSet consultaBD(String pConsulta){		
		ResultSet result=null;
		try{
			Statement state = (Statement) connection.createStatement();
			result=(ResultSet) state.executeQuery(pConsulta);
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}*/
	
	/*public void actualizarBD(String pSentencia){
		try{
			Statement state=(Statement) connection.createStatement();
			state.executeUpdate(pSentencia);
		}catch(Exception e){
			e.printStackTrace();
		}
	}*/
	
	public boolean initializeSharedVariables(){
		String sentencia= "UPDATE concurrency_control.variables SET value=0 WHERE name='X' OR name='Y' OR name='Z';";
		try{
			statement.executeUpdate(sentencia);
			this.commit();
			System.out.println("Valores X,Y,Z inicializados a 0.");
			return true;
		}catch(Exception e){
			e.printStackTrace();
			this.rollback();
			return false;
		}
	}
	
	public void setXValue(int pValue) throws SQLException{
		String sentencia= "UPDATE concurrency_control.variables SET value="+pValue+" WHERE name='X';";
		statement.executeUpdate(sentencia);
	}
	
	public void setYValue(int pValue) throws SQLException{
		String sentencia= "UPDATE concurrency_control.variables SET value="+pValue+" WHERE name='Y';";
		statement.executeUpdate(sentencia);
	}
	
	public void setZValue(int pValue) throws SQLException{
		String sentencia= "UPDATE concurrency_control.variables SET value="+pValue+" WHERE name='Z';";
		statement.executeUpdate(sentencia);
	}
	
	//COMPROBAR
	public boolean showInitialValues(String pName){
		try{
			String sentencia= "SELECT value FROM concurrency_control.variables;";
			ResultSet res = statement.executeQuery(sentencia);
			res.next();
			int x = res.getInt("value");
			res.next();
			int y = res.getInt("value");
			res.next();
			int z=res.getInt("value");
			System.out.println(pName+" valores iniciales X="+x+",Y="+y+",Z="+z);
			return true;
		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean showFinalValues(String pName){
		try{
			String sentencia= "SELECT value FROM concurrency_control.variables;";
			ResultSet res = statement.executeQuery(sentencia);
			res.next();
			int x = res.getInt("value");
			res.next();
			int y = res.getInt("value");
			res.next();
			int z=res.getInt("value");
			System.out.println(pName+" valores finales X="+x+",Y="+y+",Z="+z);
			return true;
		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}
	}
	
	public int getXValue(int pMode) throws SQLException{
		String sentencia= "SELECT value FROM concurrency_control.variables WHERE name='X';";
		int value=0;
		if(pMode==LOCKING){
			sentencia=sentencia.replace(";", " FOR UPDATE;");
		}
		ResultSet res= statement.executeQuery(sentencia);
		if (res.next()){
			value = res.getInt("value");
		}
		return value;
	}
	
	public int getYValue(int pMode) throws SQLException{
		String sentencia= "SELECT value FROM concurrency_control.variables WHERE name='Y';";
		int value=0;
		if(pMode==LOCKING){
			sentencia=sentencia.replace(";", " FOR UPDATE;");
		}
		ResultSet res= statement.executeQuery(sentencia);
		if (res.next()){
			value = res.getInt("value");
		}
		return value;
	}
	
	public int getZValue(int pMode) throws SQLException{
		String sentencia= "SELECT value FROM concurrency_control.variables WHERE name='Z';";
		int value=0;
		if(pMode==LOCKING){
			sentencia=sentencia.replace(";", " FOR UPDATE;");
		}
		ResultSet res= statement.executeQuery(sentencia);
		if (res.next()){
			value = res.getInt("value");
		}
		return value;
	}
	
	public boolean transactionA(String pName, int pCounter, int pMode){
		try{
			int xValue=getXValue(pMode);
			setXValue(xValue+1);
			System.out.println("WRITE("+pName+pCounter+",X,"+xValue+","+(xValue+1)+")");	

			int yValue=getYValue(pMode);
			setYValue(yValue+1);
			System.out.println("WRITE("+pName+pCounter+",Y,"+yValue+","+(yValue+1)+")");
			
			this.commit();
			System.out.println("COMMIT("+pName+pCounter+")");
			return true;
		}catch(SQLException e){
			e.printStackTrace();
			this.rollback();
			System.out.println("ROLLBACK("+pName+pCounter+")");
			return false;
		}
	}
	
	public boolean transactionB(String pName, int pCounter, int pMode){
		try{
			int yValue=getYValue(pMode);
			setYValue(yValue+1);
			System.out.println("WRITE("+pName+pCounter+",Y,"+yValue+","+(yValue+1)+")");
			
			int zValue=getZValue(pMode);
			setZValue(zValue+1);
			System.out.println("WRITE("+pName+pCounter+",Z,"+zValue+","+(zValue+1)+")");
			
			this.commit();
			System.out.println("COMMIT("+pName+pCounter+")");
			return true;
		}catch(Exception e){
			e.printStackTrace();
			this.rollback();
			System.out.println("ROLLBACK("+pName+pCounter+")");
			return false;
		}
	}
	
	public boolean transactionC(String pName, int pCounter, int pMode){
		try{
			int zValue=getZValue(pMode);
			setZValue(zValue+1);
			System.out.println("WRITE("+pName+pCounter+",Z,"+zValue+","+(zValue+1)+")");
			
			int xValue=getXValue(pMode);
			setXValue(xValue+1);
			System.out.println("WRITE("+pName+pCounter+",X,"+xValue+","+(xValue+1)+")");
			
			this.commit();
			System.out.println("COMMIT("+pName+pCounter+")");
			return true;
		}catch(Exception e){
			this.rollback();
			System.out.println("ROLLBACK("+pName+pCounter+")");
			e.printStackTrace();
			return false;
		}
	}
	
	public void commit() {
		try {
			connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void rollback() {
		try {
			connection.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void logout(){
		try{
			statement.close();
			connection.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
