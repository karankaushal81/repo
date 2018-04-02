

import java.util.HashMap;
import java.util.Map;

public class TrieImpl implements Trie{

	
	char ch = ' ';
	TrieNode root = new TrieNode(ch);
	
	@Override
	public void add(String word) {
		
		TrieNode current = root;
		
		for(char ch : word.toCharArray())
		{
			if(current.children.containsKey(ch))
			{
				current = current.children.get(ch);
			}
			
			else
			{
				current.getChildren().put(ch, new TrieNode(ch));
				current = current.children.get(ch);
			}
			
		}
		
		current.setLeaf(true);
		
	}
	
	
	
	

	@Override
	public boolean isPrefix(String word) {
		
		TrieNode current = root;
		
		for(char ch : word.toCharArray())
		{
			if(current.children.containsKey(ch))
			{
				current = current.children.get(ch);
			}
			
			else
			{
				return false;
			}
		}
		
		return true;
	}

	@Override
	public boolean contains(String word) {
		
		TrieNode current = root;
		
		for(char ch : word.toCharArray())
		{
			
			if(current.children.containsKey(ch))
			{
				current = current.children.get(ch);
			}
			
			else
			{
				return false;
			}
		}
		
		
		if(current.isLeaf())
		{
		return true;
		}
		else
		{
			return false;
		}
	}

	
	
	
	
	// methods for palindrome pairs check
	
	@Override
	public void add(String word, int index) {
		
		TrieNode current = root;
		
		for(char ch : word.toCharArray())
		{
			if(current.children.containsKey(ch))
			{
				current = current.children.get(ch);
			}
			
			else
			{
				current.getChildren().put(ch, new TrieNode(ch));
				current = current.children.get(ch);
			}
			
		}
		
		current.setLeaf(true);
		current.setIndex(index);
		
	}
	
	

	
	
	@Override
	public Map<Integer, String> getRemainingSuffixes(String word) {
		
		TrieNode current = root;
		Map<Integer, String> suffixMap = new HashMap<Integer, String>();
		
		int count = 0;
		for(char ch : word.toCharArray())
		{
			
			if(current.index != -1)
			{
			suffixMap.put(current.index, word.substring(count));
			}
			
			if(current.children.containsKey(ch))
			{
				current = current.children.get(ch);
				count++;
			}
			
			else
			{
				break;
			}
		}
		
		
		
		TrieNode lastNode = current;
		
		if(count == word.length())
		{
			if(lastNode.index != -1)
			{
				suffixMap.put(lastNode.index, "");
			}
			
			for(TrieNode trieNode : current.children.values())
				{
					preOrderTraversal(trieNode, suffixMap, "");
				}
			
		}
		
		return suffixMap;
		
	}





	private void preOrderTraversal(TrieNode trieNode,
			Map<Integer, String> suffixMap, String suffix) {
		
		suffix+=trieNode.ch;
		
		if(trieNode.index != -1)
		{
			suffixMap.put(trieNode.index, suffix);
			return;
		}
		
		for(TrieNode childNode : trieNode.children.values())
		{
			preOrderTraversal(childNode, suffixMap, suffix);
		}
		
	}
	
	
}
