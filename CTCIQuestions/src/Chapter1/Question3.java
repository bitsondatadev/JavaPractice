package Chapter1;

public class Question3{
	final int numCharCodes;
	
	Question3(){
		//Assumes Simple ASCII for supported character codes
		this.numCharCodes = 128;
	}

	Question3(int numCharCodes){
		this.numCharCodes = numCharCodes;
	}
	
	public String URLify(String S, int size){
		if(S == null || size < 1){
			return null;
		}
		char[] chars = S.toCharArray();
		int rindex = chars.length - 1;

		for(int i=size-1; i >= 0; i--){
			if(chars[i] != ' '){
				chars[rindex--] = chars[i];
			}else{
				chars[rindex--] = '0';
				chars[rindex--] = '2';
				chars[rindex--] = '%';
			}
		}
		return new String(chars);
	}
}
