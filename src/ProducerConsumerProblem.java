import java.util.LinkedList;


public class ProducerConsumerProblem {
	
	public static void main(String[] args) throws InterruptedException {
		
		// Object of a class that has both produce()  and consume() methods
        final PC pc = new PC();
        
        Thread t1 = new Thread( new Runnable() {
			
			@Override
			public void run() {	
				 try
	                {
	                    pc.producer();
	                }
	                catch(InterruptedException e)
	                {
	                    e.printStackTrace();
	                }
			}
		});
        
        Thread t2 = new Thread( new Runnable() {
			
			@Override
			public void run() {
				 try
	                {
	                    pc.consume();;
	                }
	                catch(InterruptedException e)
	                {
	                    e.printStackTrace();
	                }
				
			}
		});
        
     // Start both threads
        t1.start();
        t2.start();
 
        // t1 finishes before t2
        t1.join();
        t2.join();
		
		
		
	}

}


//This class has a list, producer (adds items to list  and consumer (removes items).
class PC {
	
	// Create a list shared by producer and consumer
    // Size of list is 2.
	LinkedList<Integer>  list = new  LinkedList<Integer>();
	int capicty=2;
	
	
	public  void producer() throws InterruptedException{
		
		int value =0;
		while(true){
			
			synchronized(this){
				
				while(list.size()==capicty){
						wait();
				}
				System.out.println("Producer produced-" + value);

				// to insert the jobs in the list
				list.add(value++);

				// notifies the consumer thread that
				// now it can start consuming
				notify();

				// makes the working of program easier
				// to  understand
				Thread.sleep(1000);
			}
			
			
		}
	}
	
	// Function called by consumer thread
	 public void consume() throws InterruptedException
     {
         while (true)
         {
        	 synchronized(this){
        		 
        		 // consumer thread waits while list is empty
                 while (list.size()==0)
                     wait();

                 //to reterive the first job in the list
                 int val = list.removeFirst();

                 System.out.println("Consumer consumed-"  + val);

                 // Wake up producer thread
                 notify();

                 // and sleep
                 Thread.sleep(1000);
        	 }
        	 
        	 
         }
         
     } 
		
}


