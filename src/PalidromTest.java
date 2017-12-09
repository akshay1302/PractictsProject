
public class PalidromTest {

	public static void main(String[] args) {
		
		String string ="AMMA";
		String reverseString="";
		reverseString=getPalidromString(string,reverseString);

		if(string.equalsIgnoreCase(reverseString)){
			System.out.println(string+" is palindrome String .");
		}else{
			System.out.println(string+" is not palindrome String .");
		}
	}
	
	private static  String getPalidromString(String string,String reverseString){
        
		String string1=string.substring(string.length()-1);
		String string2=string.substring(0,string.length()-1);

		reverseString=reverseString+string1;
	
		if(string2.length()>0){
			reverseString=getPalidromString(string2,reverseString);
		}
	
		return reverseString;
	}

}
