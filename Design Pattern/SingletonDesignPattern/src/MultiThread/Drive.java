package MultiThread;

public class Drive {

	public static void main(String[] args) {
		
        Thread thread1= new Thread(new Runnable() {
			
			public void run() {
				
				Singleton object1=Singleton.getInstance();
			}
		});
		
         Thread thread2 = new Thread(new Runnable() {
			
			public void run() {
				
				Singleton object2=Singleton.getInstance();
			}
		});
         
        thread1.start();
    //    try {Thread.sleep(10);}catch(Exception e) {}
 		thread2.start();

	}

}
