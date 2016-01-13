package DataStructures; 

import org.junit.*;

import static org.junit.Assert.*;

public class TrieNodeTest{

	TrieNode root;
	String[] wordList; 

	@BeforeClass
	public static void initialSetUp(){
	}

	@AfterClass
	public static void finalTearDown(){
	}
	
	@Before
	public void setUp(){
		root = AssortedMethods.getTrieDictionary();
		wordList = AssortedMethods.getListOfWords(); 
	}

	@After
	public void tearDown(){

	}

	@Test
	public void testTrieNodeInsertAndSearch(){
		for(int i = 0; i < wordList.length; i++){
			assertTrue(TrieNode.search(root, wordList[i]));
		}
		
		//The word "EFFECTS" is in the Trie and wanted to make sure these were different
		assertFalse(TrieNode.search(root, "effects"));
		assertFalse(TrieNode.search(root, "peanutbutterjellytime"));
		assertFalse(TrieNode.search(root, "8675309"));
		//notice this works for startsWith
		assertFalse(TrieNode.search(root, "responsibilit"));
		
		assertTrue(TrieNode.startsWith(root, "tha"));
		assertTrue(TrieNode.startsWith(root, "bett"));
		assertTrue(TrieNode.startsWith(root, "univers"));
		assertTrue(TrieNode.startsWith(root, "universe"));
		assertTrue(TrieNode.startsWith(root, "university"));
		assertTrue(TrieNode.startsWith(root, "responsibility"));
		assertTrue(TrieNode.startsWith(root, "responsibilit"));
		
		assertFalse(TrieNode.startsWith(root, ""));
		assertFalse(TrieNode.startsWith(root, "peanutbutterjellytime"));
	}


}
