

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;


public class EightPuzzleBFS {
	
	
	
	static class PuzzleState
	{
		int[][] state;
		String path = "";
		int x, y;

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
		
		int[][] dest =  {{0,4,3},
						 {2,1,6}, 
						 {7,5,8}};
		
		
		Set<PuzzleState> visited = new HashSet<PuzzleState>();
		Queue<PuzzleState> queue = new LinkedList<PuzzleState>();
		
		
		PuzzleState startState = new PuzzleState(start);
		startState.x = start.length-1;
		startState.y = start.length-1;
		queue.add(startState);
		
		findSolution(new PuzzleState(dest), visited, queue);
		
	}

	private static void findSolution(PuzzleState dest, Set<PuzzleState> visited, Queue<PuzzleState> queue) {
		
		
		while(!queue.isEmpty())
		{
			PuzzleState current = queue.remove();
			
			
			if(current.equals(dest))
			{
				System.out.println(current.path);
				break;
			}
			
			if(visited.contains(current))
			{
				continue;
			}
			
			visited.add(current);
			
			if(current.y>0)
			{
				PuzzleState newState = getModified(current, current.x, current.y, current.x, current.y-1);
				
				if(!visited.contains(newState))
				{
				newState.path=current.path+"L";
				queue.add(newState);
				}
			}
			
			if(current.x>0)
			{
				PuzzleState newState = getModified(current, current.x, current.y, current.x-1, current.y);
				if(!visited.contains(newState))
				{
				newState.path=current.path+"U";
				queue.add(newState);
				}
			}
			
			if(current.y<2)
			{
				PuzzleState newState = getModified(current, current.x, current.y, current.x, current.y+1);
				if(!visited.contains(newState))
				{
				newState.path=current.path+"R";
				queue.add(newState);
				}
			}
			
			if(current.x<2)
			{
				PuzzleState newState = getModified(current, current.x, current.y, current.x+1, current.y);
				if(!visited.contains(newState))
				{
				newState.path=current.path+"D";
				queue.add(newState);
				}
			}
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
		
		PuzzleState modifiedState = new PuzzleState(modified);
		modifiedState.x=x2;
		modifiedState.y=y2;
		
		return modifiedState;
	}


}
