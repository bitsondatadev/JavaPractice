package Chapter1;

import java.util.*;

public class Question1{
	final int numCharCodes;
	
	Question1(){
		this.numCharCodes = 128;
	}

	Question1(int numCharCodes){
		this.numCharCodes = numCharCodes;
	}
	
	public boolean isUnique(String S){
		if(S == null  || S.length() > this.numCharCodes){
			return false;
		}
		int[] charCount = new int[this.numCharCodes];
		char[] chars = S.toCharArray();
		for(char c: chars){
			if(charCount[c] > 0){
				return false;
			}
			charCount[c]++;
		}
		return true;	
	}
}
