
public class PrintNumberTozero {
	
	public static void  main (String  ... ar){
		
		//printNumber(10);
		
		Person p1 =new Person();
		String name="akshay";
		p1.setName(name);
		
		System.out.println("1 -----"+p1.getName()+"------"+name);
		m1(p1,name);
		System.out.println("2 -----"+p1.getName()+"------"+name);
	}
	
	public static  void printNumber(int n){
		System.out.println(n);
		printNumber(n-1);
	}
	
	
	public static void  m1(Person p ,String name){
	
		p.setName("gaurav");
		name="yash";
		
	}
}
