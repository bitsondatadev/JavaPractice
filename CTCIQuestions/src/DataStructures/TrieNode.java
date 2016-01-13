package DataStructures;

import java.util.HashMap;
import java.util.Map;

/**
 * Trie
 *  n - number of Strings in trie
 *  m - largest length of all strings
 *  k - length of a given string
 * 
 * Build Trie:
 *  - Time Complexity: O(mn)
 *  - Space Complexity: O(mn)
 * 
 * Search:
 *  - Time Complexity: O(k)
 *  - Space Complexity: O(1)
 * 
 * Insert:
 *  - Time Complexity: O(k)
 *  - Space Complexity: O(k)
 *  
 *  Remove:
 *  - Time Complexity: O(k)
 *  - Space Complexity: O(k)
 * 
 * Assumptions: Input array is a distinct sorted list.
 */
class TrieNode {

    private Map<Character, TrieNode> children;
    private boolean isLeaf;
 
    public TrieNode() {
    	children = new HashMap<Character, TrieNode>(53);
    }

    public TrieNode(int initialCapacity) {
    	children = new HashMap<Character, TrieNode>(initialCapacity);
    }

	public Map<Character, TrieNode> getChildren() {
		return children;
	}

	public boolean isLeaf() {
		return isLeaf;
	}

	public void setIsLeaf(boolean isLeaf) {
		this.isLeaf = isLeaf;
	}

    public static void insert(TrieNode root, String word) {
        Map<Character, TrieNode> children = root.getChildren();
 
        for(int i=0; i<word.length(); i++){
            char c = word.charAt(i);
 
            TrieNode t;
            if(children.containsKey(c)){
                    t = children.get(c);
            }else{
                t = new TrieNode(c);
                children.put(c, t);
            }
 
            children = t.getChildren();

            if(i==word.length()-1)
                t.setIsLeaf(true);    
        }
    }
 
    public static boolean search(TrieNode root, String word) {
        TrieNode t = searchNode(root, word);
        return t != null && t.isLeaf();
    }
 
    public static boolean startsWith(TrieNode root, String prefix) {
        return searchNode(root, prefix) != null;
    }
 
    public static TrieNode searchNode(TrieNode root, String str){
        Map<Character, TrieNode> children = root.getChildren(); 
        TrieNode t = null;
        for(int i=0; i<str.length(); i++){
            char c = str.charAt(i);
            if(children.containsKey(c)){
                t = children.get(c);
                children = t.getChildren();
            }else{
                return null;
            }
        }
 
        return t;
    }
}