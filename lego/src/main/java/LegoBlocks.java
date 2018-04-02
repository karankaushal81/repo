

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LegoBlocks {
	
	public static long count = 0;
	public static long continousWallCount = 0;
	
	// inputs
	public static int h = 10000, w = 1000;
	public static int[] blocks = {1, 2, 3, 4};
	//--
	
	public static void main(String[] args)
	{
		
		System.out.println();
		System.out.println("Width : "+ w+", Height : "+h+", blocks : "+Arrays.toString(blocks));
	   
	   List<String> combinations = new ArrayList<String>();
	   getCombinations( w, blocks, "", combinations);
	   
	   List<String> arrangement = new ArrayList<String>(h);
	   arrangeCombinations(h, combinations, arrangement);
	   
	   System.out.println();
	   System.out.println("Total Combinations Of the blocks  : "+ count);
	   
	   System.out.println();
	   System.out.println("Continous Walls Combination Count : "+ continousWallCount);
		
	}

	
	public static void forTest()
	{
		 List<String> combinations = new ArrayList<String>();
		   getCombinations( w, blocks, "", combinations);
		   
		   List<String> arrangement = new ArrayList<String>(h);
		   arrangeCombinations(h, combinations, arrangement);
		   
		   System.out.println();
		   System.out.println("Total Combinations Of the blocks  : "+ count);
		   
		   System.out.println();
		   System.out.println("Continous Walls Combination Count : "+ continousWallCount);
	}
	
	

	private static void getCombinations(int w, int[] blocks, String level, List<String> combinations) {
		
		if(w == 0)
		{
			combinations.add(level);
		}
		
		
		for(int blockWidth : blocks)
		{
			if(w >= blockWidth)
			{
			getCombinations(w-blockWidth, blocks, level+","+blockWidth, combinations);
			}
		}
		
	}
	
	
	
	


	private static void arrangeCombinations(int h, List<String> combinations, List<String> arrangement) {
		
		if(arrangement.size() == h)
		{
			
			System.out.println();
			if(isContinous(arrangement))
			{
			   printArrangement(arrangement);
			  //System.out.println("Continous"); 	
			  continousWallCount++;
			}
			
			//printArrangement(arrangement);
			
			count++;
			return;
		}
		
		
		
		for(int i=0; i< combinations.size(); i++)
		{
			arrangement.add(combinations.get(i));
			arrangeCombinations(h, combinations, arrangement);
			if(arrangement.size() > 0)
			{
			arrangement.remove(arrangement.size()-1);
			}
		}
		
	}
	
	


	
	/*  
	 *  width of the bit map = 2* input width - 1
	 *  number of set bits for each block = 2*block width - 1
	 *  1010101{1,1,1,1}
	 *  1110111{2,2}
	 *  1111101{3,1}
	 *  1111111{4}
	 *  I tried to visualize the arrangement and came up with an idea to represent a block with its width as 1 and a boundary as 0
	 *  using a bit map I was able to represent the arrangement of blocks
	 *  to check if there are breakages, I did an or of all the rows and if there is a 10 in the result that means there is a straight line
	 *  at the edges in the arrangement which doesn't cross a continuous block
	 */
	public static boolean isContinous(List<String> arrangement)
	{
		Long[] bitMap = new Long[h];
		
		for(int j =0; j < h; j++)
		{
			bitMap[j]=0l;
		}
				
		int i=0;
		
		for(String s : arrangement)
		{
			String[] row = s.split(",");
			
			int from =2*w-1;
			//int from =2*w-blocks[0];
			
			for(String r : row)
			{
				if(r.equals(""))
				{
					continue;
				}
				
				int count = Integer.parseInt(r);
				
				// optimization if the block width is equal to the input width, the arrangement will be continous
				if(count == w)
				{
					return true;
				}
				
				int setBitsCount = 2*count-1;
				//int setBitsCount = 2*count-blocks[0];
				
				// set bits of long[i], from to the next setBitsCount
				bitMap[i] = bitMap[i] | getMask(from,setBitsCount);
				
				
				from= from - setBitsCount;
				
				// for adding 0 to represent the boundary of a block, skipping one bit
				from--;
				
				if(from<0)
				{
				  break;
				}
				
				
			}
			
			
			i++;
			
		}
		
		for(int j =0; j < h; j++)
		{
			bitMap[j] = bitMap[j]>>1;
			//System.out.println(Long.toBinaryString(bitMap[j]));
		}
		
		
			Long b = 0l;
			for(int j =0; j < h; j++)
			{
			 b =  b | bitMap[j];
			}
			
			//System.out.println(Long.toBinaryString(b));
			if(Long.toBinaryString(b).contains("10"))
			{
				return false;
			}
				
		
		return true;
	}





	private static Long getMask(int from, int count) {
		Long mask = 0l;
		
		
			while(count > 0 )
			{
			mask+=1;
			mask=mask<<1;
			count--;
			from--;
			}
			if(from>0)
			{
				mask=mask<<from;
			}
			
		//System.out.println(Long.toBinaryString(mask));
		return mask;
	}
	
	
	
	
	private static void printArrangement(List<String> arrangement) {
		
		System.out.println();
		for(String level : arrangement)
		{
		  
		String[] values = level.split(",");
		
		System.out.print("|");
		for(String value : values)
		{
			if(value.equals(""))
			{
				continue;
			}
			
			System.out.print("["+value+"]");
		}
		System.out.print("|");
		System.out.println();
		}
		
		System.out.println("------------------------");
		System.out.println();
		
	}
	
	
	
}
