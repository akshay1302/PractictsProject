public class Java8DefaultMethodTest  {

 public static  void main(String ar[]){
	 
	 System.out.println("java 8 interface default method  example");
	 A a1 =new ImplementingClass();
	 a1.print();
 }
 
}

class ImplementingClass  implements A,B,C {

	public void print() {
		
		A.super.print();
	    B.super.print();
	    C.super.print();
	}
}
	 

interface A {
	
	default void print(){
	 System.out.println("in AAAAAA");	
	}
}

interface B{
	
	default void print(){
		 System.out.println("in BBBB");	
		
	}
}

interface C {
	
	default void print(){
	   System.out.println("in CCCC");	
	}
}

