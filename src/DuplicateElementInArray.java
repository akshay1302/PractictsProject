import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;


public class DuplicateElementInArray {
	
	public static  void main(String ar[]){
		
		Integer array [] ={1,1,2,2,3,4,5,8,8,8,4,4,4};
		
		/**
		 * Using Set
		 */
		Set<Integer> duplicateSet= new HashSet<Integer>();
		
		for(Integer element : array){
		 if(duplicateSet.add(element)==false){
			System.out.println("Found Duplicate elements  from array "+element);
		  }	
		}
	
		/**
		 * Using HasMap
		 */
		
		Map<Integer, Integer> duplicateElement =new HashMap<Integer, Integer>();
		
		for(Integer element : array){
			
			Integer count=duplicateElement.get(element);
			
			if(count==null){
				duplicateElement.put(element,1);
			}else{
				duplicateElement.put(element,++count);
			}
		}
		
		Set<Entry<Integer,Integer>>  enterySet = duplicateElement.entrySet();
		
		for(Entry<Integer,Integer> entry : enterySet){
			if(entry.getValue()>1){
				System.out.println("Duplicate elements  from array "+entry.getKey() +  "  "+entry.getValue() +" times");
			}
		}
		
	}

}
