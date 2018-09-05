package lab5;

public class RepeatableRead {
	//cambiar la configuracion de mysql y reiniciar servicio mysql
	//transaction-isolation CON GUION!!! NO BARRABAJA
	public static void main(String[] args) throws Exception{
		//probar para LOCKING y NONLOCKING
		ThreadA threadA = new ThreadA(Data.NONLOCKING);
		ThreadB threadB = new ThreadB(Data.NONLOCKING);
		ThreadC threadC = new ThreadC(Data.NONLOCKING);
		threadA.myData.initializeSharedVariables();
		
		new Thread(threadA).start();
		new Thread(threadB).start();
		new Thread(threadC).start();
	}
}