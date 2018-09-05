package lab5;

public class ThreadA extends Thread{
	
	String myName="A";
	Data myData;
	int myMode;
	
	public ThreadA(){
		myData= new Data();
		myMode=Data.NONLOCKING;
	}
	
	public ThreadA(int bloqueo){
		myData= new Data();
		myMode=bloqueo;
	}
	
	@Override
	public void run() {
		int counter=0;
		Boolean commited;	
		myData.showInitialValues(myName);	
		while(counter<Data.NUMBER_OF_ITERATIONS){
			commited = myData.transactionA(myName, counter, myMode);
			if(commited){
				counter+=1;
			}
		}
		myData.showFinalValues(myName);
		myData.logout();
	}
}
