package recursion;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Anagram {
	public static void main(String[] args) {
      String str="silent";
      String str2="listen";
      Map<Character,Integer> map =new HashMap<>();
      for(char c:str.toCharArray()) {
    	  map.put(c, map.getOrDefault(c, 0)+1);
      }
      for(char c:str2.toCharArray()) {
    	  if(map.containsKey(c)) {
    		  map.put(c, map.get(c)-1);
    		  if(map.get(c)==0) {
    			  map.remove(c);
    		  }
    	  }
      }
      if(map.isEmpty()) {
    	  System.out.println("anagram");
      }else {
    	  System.out.println("not anagram");
      }
      
      char[] charArray = str.toCharArray();
      char[] charArray2 = str2.toCharArray();
      Arrays.sort(charArray);
      Arrays.sort(charArray2);
      if(Arrays.equals(charArray, charArray2)) {
    	  System.out.println("anagram");
      }
	}
}
