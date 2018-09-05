package lab5;

/* fail: innodb is limited to row-logging  when transaction isolation...
 * solution1: desactivar bin_log de my.cnf
 * solution2: add in my.cnf binlog_format=row 
 * https://confluence.atlassian.com/jirakb/mysql-binary-logging-problem-with-innodb-when-creating-a-workflow-196116927.html
 */

public class ReadCommitted {
	//cambiar la configuracion de mysql y reiniciar servicio mysql
	public static void main(String[] args) throws Exception{
		//probar para LOCKING y NONLOCKING
		ThreadA threadA = new ThreadA(Data.LOCKING);
		ThreadB threadB = new ThreadB(Data.LOCKING);
		ThreadC threadC = new ThreadC(Data.LOCKING);
		threadA.myData.initializeSharedVariables();
		
		new Thread(threadA).start();
		new Thread(threadB).start();
		new Thread(threadC).start();
	}
}
