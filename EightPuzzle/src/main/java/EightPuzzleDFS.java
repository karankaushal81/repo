

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class EightPuzzleDFS {
	
	static class PuzzleState
	{
		int[][] state;

		public PuzzleState(int[][] state) {
			super();
			this.state = state;
		}

		

		@Override
		public int hashCode() {
			return toString().hashCode();
		}



		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			PuzzleState other = (PuzzleState) obj;
			if (!toString().equals(other.toString()))
				return false;
			return true;
		}



		@Override
		public String toString() {
			
			String[] arrayString = new String[state.length];
			
			for(int i = 0; i < state.length; i++)
			{
				arrayString[i] = Arrays.toString(state[i]);
			}
			return "PuzzleState [state=" + Arrays.toString(arrayString) + "]";
		}
		
		
		
		
	}
	
	
	static boolean found = false;
	
	public static void main(String[] args)
	{
		int[][] start = {{1,2,3},
						{4,5,6}, 
						{7,8,0}};
		
		int[][] dest = {{1,2,3},
						{5,0,6}, 
						{4,7,8}};
		
		
		Set<PuzzleState> visited = new HashSet<PuzzleState>();
		
		
		findSolution(new PuzzleState(start), new PuzzleState(dest), visited, "", 2, 2);
		
	}

	private static void findSolution(PuzzleState start, PuzzleState dest, Set<PuzzleState> visited, String path, int x, int y) {
		
		
		
		
		if(start.equals(dest))
		{
			System.out.println(path);
			found = true;
			return;
		}
		
		
		if(visited.contains(start))
		{
			return;
		}
		
		
		
		visited.add(start);
		
		if(y>0)
		{
		findSolution(getModified(start, x, y, x, y-1), dest, visited, path+"L", x, y-1);
		}
		
		if(x>0)
		{
		findSolution(getModified(start, x, y, x-1, y), dest, visited, path+"U", x-1, y);
		}
		
		if(y<2)
		{
		findSolution(getModified(start, x, y, x, y+1), dest, visited, path+"R", x, y+1);
		}
		
		
		
		if(x<2)
		{
		findSolution(getModified(start, x, y, x+1, y), dest, visited, path+"D", x+1, y);
		}
		
	}

	private static PuzzleState getModified(PuzzleState startState, int x, int y, int x2,
			int y2) {
		
		int[][] start = startState.state;
		
		int[][] modified = new int[start.length][start.length];
		
		
		for(int i = 0; i < start.length; i++)
		{
			for(int j=0; j < start.length; j++)
			{
				if(i==x && j == y)
				{
					modified[i][j]=start[x2][y2];
				}
				else if(i==x2 && j == y2)
				{
					modified[i][j]=start[x][y];
				}
				else
				{
					modified[i][j] = start[i][j];
				}
			}
		}
		
		
		return new PuzzleState(modified);
	}

	

	
}
