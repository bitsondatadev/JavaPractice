package Chapter8;

public class Question3{
	public Question3(){
	}
	/**
	 * TODO: still need to do the follow up and consider if all values are not distinct.
	 * 
	 * Current assumption: A is sorted and has distinct values.
	 */
	public int findMagicIndex(int[] A){
		if(A == null || A.length == 0){ return -1;}
		int low = 0;
		int high = A.length;
		int mid;
		while(high >= low){
			mid = (low + high)/2;
			if(A[mid] < mid){
				low = mid + 1;
			}else if(A[mid] > mid){
				high = mid - 1;
			}else{
				return mid;
			}
		}
		
		return -1;
	}
}


