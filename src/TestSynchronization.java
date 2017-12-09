
public class TestSynchronization {
	public static void main(String[] args) {
		
		Table t1= new Table();
		Table t2= new Table();
		
		
		 ThreadDemo1 T1 = new ThreadDemo1( "Thread - 1 ", t1 ,2);
		 ThreadDemo1 T2 = new ThreadDemo1( "Thread - 2 ", t1,3);
		 ThreadDemo1 T3 = new ThreadDemo1( "Thread - 3 ", t2, 4);
		 ThreadDemo1 T4 = new ThreadDemo1( "Thread - 4 ", t2,5);
		 ThreadDemo1 T5 = new ThreadDemo1( "Thread - 5 ", t2,6);
		 
		  T1.start();
	      T2.start();
	      T3.start();
	      T4.start();
	      T5.start();
	      
	   // wait for threads to end
	      try {
	         T1.join();
	         T2.join();
	         T3.join();
	         T4.join();
	         T5.start();
	      } catch ( Exception e) {
	         System.out.println("Interrupted");
	      }
	}
	
	

}
class Table{    
	 synchronized static  void printTable(Integer n,String threadName){  
		 
		 System.out.println("thread for  --->"+threadName + "for table "+n);
	   for(int i=1;i<=10;i++){  
	     System.out.println(n*i);  
	     try{  
	       Thread.sleep(400);  
	     }catch(Exception e){}  
	   }  
	 }  
}  

class ThreadDemo1 extends Thread {
	
	private Thread thread;
	private String threadName;
	private Integer number;
	Table  table;
	
	
	 ThreadDemo1( String threadName,  Table table,Integer number) {
	        this.threadName = threadName;
	        this.table =table;
	        this.number=number;
	     }
	 
	 public void run() {
		 Table.printTable(number,threadName);
		 
	 }
	 public void start () {
	        System.out.println("Starting " +  threadName );
	        if (thread == null) {
	        	thread = new Thread (this, threadName);
	        	thread.start ();
	        }
	  }

	
}
	  
