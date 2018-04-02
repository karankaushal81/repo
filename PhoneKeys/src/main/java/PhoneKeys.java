

import java.util.HashMap;
import java.util.Map;


/*
 * type any number of keys on a phone and list the resulting words
 * the words are created with the letters the digit represents
 */
public class PhoneKeys {

	private static Map<Integer, String> digitLetters = new HashMap<Integer, String>();
	private static int resultCount = 0;
	
	public static void main(String[] args)
	{
		digitLetters.put(2,"abc");
		digitLetters.put(3, "def");
		digitLetters.put(4, "ghi");
		digitLetters.put(5, "jkl");
		digitLetters.put(6, "mno");
		digitLetters.put(7, "pqrs");
		digitLetters.put(8, "tuv");
		digitLetters.put(9, "wxyz");
		
		resultCount=0;
		
		String input = "65876587";
		generateWords(input, "");
		System.out.println("result Count : "+resultCount);
		
	}

	private static void generateWords(String input, String result) {
		
		if(input == null || input.length()==0)
		{
			System.out.println(result);
			resultCount++;
			return;
		}
		
		Character digit = input.charAt(0);
		
			
			for(Character alphabet : digitLetters.get(Integer.parseInt(String.valueOf(digit))).toCharArray())
			{
				generateWords(input.substring(1), result+alphabet);
			}
		
		
	}
}
