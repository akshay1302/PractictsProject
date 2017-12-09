
public class SyncThreadDemo {

	public static void main(String[] args) {
		
		 PrintDemo PD = new PrintDemo();
		/* PrintDemo PD1 = new PrintDemo();
		 
		 PrintDemo PD2 = new PrintDemo();
		 PrintDemo PD3 = new PrintDemo();*/
		

	      ThreadDemo T1 = new ThreadDemo( "Thread - 1 ", PD );
	      ThreadDemo T2 = new ThreadDemo( "Thread - 2 ", PD);
	      ThreadDemo T3 = new ThreadDemo( "Thread - 3 ", PD );
	      ThreadDemo T4 = new ThreadDemo( "Thread - 4 ", PD);

	      T1.start();
	      T2.start();
	      T3.start();
	      T4.start();
	      
	   // wait for threads to end
	      try {
	         T1.join();
	         T2.join();
	         T3.join();
	         T4.join();
	      } catch ( Exception e) {
	         System.out.println("Interrupted");
	      }
	      
	      
	
	}

}

class PrintDemo {
	   public  void printCount(String threadName) {
	      try {
	         for(int i = 5; i > 0; i--) {
	            System.out.println("Counter  " +threadName+ " ---"     + i );
	         }
	      } catch (Exception e) {
	         System.out.println("Thread  interrupted.");
	      }
	      getMessage(threadName);
	   }
	   
	   public  void  getMessage(String threadName){
		   System.out.println("Message from --->"+threadName);
		   getMessage1(threadName);
	   }
	   public  void  getMessage1(String threadName){
		   System.out.println("Message from  method 2--->"+threadName);
	   }
	}

class ThreadDemo extends Thread {
	
	private Thread thread;
	private String threadName;
    PrintDemo  PD;
    
    ThreadDemo( String name,  PrintDemo pd) {
        threadName = name;
        PD = pd;
     }
    
    public void run() {
       
    	/*
    	 * object level Lock
    	 * 
    	 */
    	
    	
    	  synchronized(PD) {
           PD.printCount(threadName);
        }
        /*synchronized(PD) {
        	PrintDemo.getMessage(threadName);
         }*/
    	
    /*	synchronized(PD) {
    		PrintDemo.printCount(threadName);
        }
         synchronized(PD) {
    	    PrintDemo.getMessage(threadName);
        }*/
    	

    	/*
    	 * class level Lock
    	 * 
    	 */
    	
        /*synchronized(PrintDemo.class) {
        	PD.printCount(threadName);
         }
        synchronized(PrintDemo.class) {
        	 PrintDemo.getMessage(threadName);
          }*/
    	
    	
        
         
         
        
        System.out.println("Thread " +  threadName + " exiting.");
     }
    
    public void start () {
        System.out.println("Starting " +  threadName );
        if (thread == null) {
        	thread = new Thread (this, threadName);
        	thread.start ();
        }
     }

	
}
