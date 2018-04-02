

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
	
	
	char ch;
	Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
	
	boolean isLeaf;
	
	int index = -1;
	
	public TrieNode(char ch) {
		super();
		this.ch = ch;
		
	}
	
	


	public Map<Character, TrieNode> getChildren() {
		return children;
	}


	public void setChildren(Map<Character, TrieNode> children) {
		this.children = children;
	}


   


	public boolean isLeaf() {
		return isLeaf;
	}




	public void setLeaf(boolean isLeaf) {
		this.isLeaf = isLeaf;
	}

	



	public int getIndex() {
		return index;
	}




	public void setIndex(int index) {
		this.index = index;
	}




	@Override
	public String toString() {
		return "TrieNode [ch=" + ch + ", children=" + children.keySet() + ", isLeaf="
				+ isLeaf + "]";
	}



	
	
	

}
