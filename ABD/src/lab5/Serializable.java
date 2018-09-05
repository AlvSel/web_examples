package lab5;

public class Serializable {
	//cambiar la configuracion de mysql y reiniciar servicio mysql
	//transaction-isolation CON GUION!!! NO BARRABAJA
	public static void main(String[] args) throws Exception{
		ThreadA threadA = new ThreadA();
		ThreadB threadB = new ThreadB();
		ThreadC threadC = new ThreadC();
		System.out.println("INICIO");
		threadA.myData.initializeSharedVariables();
		
		new Thread(threadA).start();
		new Thread(threadB).start();
		new Thread(threadC).start();
	}
}
