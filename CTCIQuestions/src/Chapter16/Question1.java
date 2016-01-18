package Chapter16;

public class Question1{

	Question1(){
	}
	
	public int[] swapNumbers(int a, int b){
		a = a + b;
		b = a - b;
		a = a - b;
		return new int[]{a,b};
	}
}
