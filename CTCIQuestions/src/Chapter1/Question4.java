package Chapter1;

import java.util.*;
import DataStructures.HashTable;

public class Question4{
	final int numCharCodes;
	HashTable<Character, Integer> charCount;
	
	Question4(){
		//Assumes Simple ASCII for supported character codes
		this.numCharCodes = 128;
	}

	Question4(int numCharCodes){
		this.numCharCodes = numCharCodes;
	}
	
	public boolean isPalindromePermutation(String S){
		if(S == null || S.length() == 0){
			return false;
		}

 		this.charCount = new HashTable<Character, Integer>(this.numCharCodes);
		for(int i=0; i < S.length(); i++){
			char c = S.charAt(i);
			if(charCount.contains(c)){
				charCount.put(c, charCount.get(c) + 1);
			}else{
				charCount.put(c,1);
			}
		}
		
		boolean hasOdd = false;
		for(AbstractMap.SimpleEntry<Character,Integer> ent:charCount.entrySet()){
			if(ent.getValue() % 2 != 0){
				if(hasOdd){
					return false;
				}
				hasOdd = true;
			}
		}
		return true;
	}
}
