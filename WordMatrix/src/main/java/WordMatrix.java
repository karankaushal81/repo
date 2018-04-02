

import java.util.HashSet;
import java.util.Set;

public class WordMatrix {
	
	
	
	static Set<String> dict = new HashSet<String>();
	
	public static void main(String[] args)
	{
		
		
		String[][] input = {{"a", "b", "c"}, 
							{"d", "e", "f"}, 
							{"g", "h", "i"}};
		
		
		
		
		
		for(int i=0; i< input.length; i++)
		{
			System.out.println();
			for(int j=0; j< input[i].length; j++)
			{
				System.out.print(input[i][j]+", ");
			}
		}
		
		System.out.println();
		System.out.println();
		
		dict.add("ef");
		dict.add("ab");
		dict.add("ebfi");
		dict.add("edg");
		dict.add("ade");
		
		findWords(input);
	}

	private static void findWords(String[][] input) {
		
		for(int i=0; i< input.length; i++)
		{
			for(int j=0; j< input[i].length; j++)
			{
				boolean[][] visited = new boolean[input.length][input[i].length];
				dfs(i, j, "", input, visited);
			}
		}
		
	}

	private static void dfs(int i, int j, String word, String[][] input,
			boolean[][] visited) {
		
		
		if(i>=input.length || i < 0 || j >= input.length || j < 0)
		{
			return;
		}
		
		
		
		
		if(visited[i][j])
		{
			return;
		}
		
		
		
		word+=input[i][j];
		

		
		visited[i][j] = true;
		
		
		if(dict.contains(word))
		{
			System.out.println(word);
		}
		
		
		
		dfs(i, j-1, word, input, visited); 
		
		
		dfs(i-1, j-1, word, input, visited);
		
		dfs(i-1, j, word, input, visited);
		
		dfs(i-1, j+1, word, input, visited);
		
		dfs(i, j+1, word, input, visited);
		
		dfs(i+1, j+1, word, input, visited);
		
		dfs(i+1, j, word, input, visited);
		
		dfs(i+1, j-1, word, input, visited);
		
		if(word !=null && word !="")
		{
	//	word = word.substring(0, word.length()-1);
		}
		visited[i][j]=false;
		
		
	}

	
}
