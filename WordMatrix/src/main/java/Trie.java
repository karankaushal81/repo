

import java.util.Map;

public interface Trie {
	
	void add(String word);
    boolean isPrefix(String prefix);
    boolean contains(String word);
	void add(String word, int index);
	Map<Integer, String> getRemainingSuffixes(String word);

	

}
