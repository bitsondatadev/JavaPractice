package Chapter1;

public class Question2{
	final int numCharCodes;
	
	Question2(){
		//Assumes Simple ASCII for supported character codes
		this.numCharCodes = 128;
	}

	Question2(int numCharCodes){
		this.numCharCodes = numCharCodes;
	}
	
	boolean isPermutation(String S1, String S2){
		if((S1 == null || S2 == null) || S1.length() != S2.length()){
			return false;
		}

		int[] charCount = new int[this.numCharCodes];
		
		for(int i=0; i < S1.length(); i++){
			charCount[S1.charAt(i)]++;
			charCount[S2.charAt(i)]--;
		}

		for(int i=0; i < this.numCharCodes; i++){
			if(charCount[i] != 0){
				return false;
			}
		}
		return true;
	}
}
