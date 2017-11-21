/* IMPORTANT: class must not be public. */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.StringTokenizer;

class TestClass {
    public static void main(String args[] ) throws Exception {
        
       /* BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		int a[] = new int[t];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int i = 0;
		while(st.hasMoreTokens()){
			a[i++] = Integer.parseInt(st.nextToken());
		}
		
		System.out.println(t);
        
        for (int j = 0; j < t; ++j) {
            int num = a[j];
            for (int k = 1; k <= num; ++k) {
                if (k % 15 == 0)
                    System.out.println("FizzBuzz");
                else if (k % 3 == 0)
                    System.out.println("Fizz");
                else if (k % 5 == 0)
                    System.out.println("Buzz");
                else
                    System.out.println(k);
            }   
        }*/
    	
    	try{
    	
	    	Map<String,String> map =new HashMap<String, String>();
	    	
	    	
	    	/*map.put("A","1000");
	    	map.put(null,"2000");
	    	map.put(null,"5555");
	    	
	    	System.out.println(map);
	    	
	    	
	    	Hashtable<String,String>  map1 =new Hashtable<String, String>(); 
	    	
	    	map1.put("A","1000");
	    	map1.put(null,"2000");
	    	map1.put(null,"5555");
	    	
	    	System.out.println(map1);*/
	    	
	    	String s1 = new String("akshay");
	    	String s2 = new String("akshay");
	    	
	    	System.out.println("equlals ---->"+(s1.equals(s2)));
	    	
	    	System.out.println("== --->"+(s1==s2));
    	}
    	catch(Exception e){
    		System.out.println("in catch "+e.getMessage());
    		
    	}finally{
    		System.out.println("in finalllyyyyy ");
    		
    	}

    }
}