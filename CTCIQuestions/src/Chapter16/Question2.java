package Chapter16;

import java.util.HashMap;
import java.util.Map;

public class Question2{
	
	Question2(){
	}
	
	public Map<String, Integer> getWordFrequencies(String S1){
		if(S1 == null){
			return null;
		}
		String[] words = S1.split(" ");
		Map<String, Integer> freqs = new HashMap<String, Integer>();
		
		for(String word: words){
			String fixedWord = word.trim().toLowerCase();
			if(!freqs.containsKey(fixedWord)){
				freqs.put(fixedWord, 1);
			}else{
				freqs.put(fixedWord,freqs.get(fixedWord) + 1);
			}
		}
		
		return freqs;
	}
}
