package Chapter8;

import java.util.Arrays;

public class Question1{
	private int memo[];
	private int n;
	private final static int MAX_NUMBER_HOPS = 3;
	public final static int INIT_N = 10;
	
	public Question1(){
		initMemo(Question1.INIT_N);
	}
	
	public void setN(int n){
		initMemo(n < 1 ? 1 : n);
	}
	
	private void initMemo(int n){
		this.n = n;
		this.memo = new int[n + 1];
		Arrays.fill(this.memo, -1);
		this.memo[n] = 1;
	}
	
	public int computeCount(){
		return computeCount(0);
	}
	
	private int computeCount(int sum){
		if(this.memo[sum] != -1){
			return this.memo[sum];
		}
		
		for(int i=1; i <= Question1.MAX_NUMBER_HOPS; i++){
			if(sum + i <= this.n){
				if(this.memo[sum] == -1){
					this.memo[sum] = computeCount(sum + i);
				}else{
					this.memo[sum] += computeCount(sum + i);
				}
			}
		}
		
		return this.memo[sum];
	}
	
	/**
	 * I had a different looking solution than Gayle's and I wanted to verify my solution with hers.
	 * This is coded directly from the CTCI solution so spoiler alert!
	 * I admit her solution would have been simpler to think up in an interview.
	 * Mine is the bottom up solution.
	 * @param n
	 * @return
	 */
	public int countWays(int n){
		int[] memo = new int[n + 1];
		Arrays.fill(memo, -1);
		return countWays(n, memo);
	}
	public int countWays(int n, int[] memo){
		if(n < 0){
			return 0;
		}else if (n==0){
			return 1;
		}else if(memo[n] > -1){
			return memo[n];
		}else{
			memo[n] = countWays(n - 1, memo) + countWays(n - 2, memo) + countWays(n - 3, memo);
			return memo[n];
		}
		
	}
}
