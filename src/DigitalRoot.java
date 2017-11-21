import java.util.Scanner;


public class DigitalRoot {

	public static void main(String[] args) {
	
		Scanner sc=new Scanner(System.in);
		System.out.println("***************** Start ********************************");
		System.out.println("Enter Value of k and n");
		String k=sc.nextLine();
		Integer n=Integer.parseInt(sc.nextLine());
		
		System.out.println("Enterd Value of k-----> "+k);
		System.out.println("Enterd Value of n-----> "+n);
		
		System.out.println("****************************************************");
		
		Integer p=calculateP(k,n);
		System.out.println("calculate Value of P------>"+p);
		
		System.out.println("****************************************************");
		
		System.out.println("calculated SuperDigit------>"+calculateSuperDigit(p));
		
		System.out.println("**************** End ******************************");
		
		sc.close();

	}
	
	public static Integer   calculateP(String k,Integer n){
		String p="";
		for(int i=0;i<n;i++){
			p+=k;
		}
	   return Integer.parseInt(p);
	}
	
	public static Integer calculateSuperDigit(Integer n){
		
		Integer sum = 0;
		 while (n > 0) {
	            int rem;
	            rem = n % 10;
	            sum = sum + rem;
	            n = n / 10;
	        }
		 if(sum>9){
			return calculateSuperDigit(sum);
		 }else{
			 return sum;
		 }
}

}
