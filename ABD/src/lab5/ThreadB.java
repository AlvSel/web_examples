package lab5;

public class ThreadB extends Thread{
	
	String myName="B";
	Data myData;
	int myMode;
	
	public ThreadB(){
		myData= new Data();
		myMode = Data.NONLOCKING;
	}
	
	public ThreadB(int bloqueo){
		myData= new Data();
		myMode=bloqueo;
	}
	
	@Override
	public void run() {
		try{
			int counter=0;
			Boolean commited;		
			myData.showInitialValues(myName);
			
			while(counter<Data.NUMBER_OF_ITERATIONS){
				commited = myData.transactionB(myName, counter, myMode);
				if(commited){
					counter+=1;
				}
			}	
			myData.showFinalValues(myName);
			myData.logout();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
