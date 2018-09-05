package lab5;

public class ThreadC extends Thread{
	
	String myName="C";
	Data myData;
	int myMode;
	
	public ThreadC(){
		myData= new Data();
		myMode = Data.NONLOCKING;
	}
	
	public ThreadC(int bloqueo){
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
				commited = myData.transactionC(myName, counter, myMode);		
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
