Given a 2D board and a Set of words from the dictionary, find all valid words(words present in the dictionary) in the board.

Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically or diagonally neighboring. The same letter cell may not be used more than once in a word.


I have provided two implementations, one in which the dictionary is represented by a hashset
another in which the dictionary is represented by a trie.

The second approach is more efficient as it purges the recursion tree if the current recursion path is not a prefix in the trie.


