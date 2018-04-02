

public class TrieTest {
	
	
	public static void main(String[] args)
	{
		Trie trie = new TrieImpl();
		
		
		trie.add("abe");
		trie.add("abf");
		trie.add("abl");
		trie.add("btre");
		
		
		System.out.println(trie.isPrefix("ab"));
		System.out.println(trie.isPrefix("abz"));
		
		System.out.println(trie.contains("abe"));
		System.out.println(trie.contains("abz"));
	}

}
