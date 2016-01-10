package Chapter3;

import java.lang.reflect.Array;

/**
 * This question was interesting and I wanted to take some time to write a little class that keeps track of three stacks using only one array.
 * @author Brian
 *
 * @param <T>
 */
public class Question1<T>{

	private Class<T> clazz;
	private T[] arr;
	private int s1, s2, s3, c1, c2, c3, n;
	private final int MIN_ARRAY_SIZE = 6;
	
	/**
	 * To avoid issues with small arrays and indices being too close we make the minimum size of the array 6.
	 * @param clazz
	 * @param n
	 */
	public Question1(Class<T> clazz){
		this.initVariables(clazz, this.MIN_ARRAY_SIZE);
	}
	
	public Question1(Class<T> clazz, int n){
		this.initVariables(clazz, n);
	}
	
	/**
	 * Initialize all indices and creates the initial array.
	 * @param clazz
	 * @param n
	 */
	public void initVariables(Class<T> clazz, int n){
		this.clazz = clazz;
		this.n = n < this.MIN_ARRAY_SIZE ? this.MIN_ARRAY_SIZE : n;

		this.arr = createArray(n);
		this.s1 = 0;
		this.s2 = (int) Math.floor(n * .3333);
		this.s3 = this.s2 * 2;
		this.s3 = this.s3 >= n ? n - 1 : this.s3;
		this.c1 = this.c2 = this.c3 = 0;
	}
	
	/**
	 * Creates array of type T size n.
	 * @param n
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private T[] createArray(int n){
		return (T[])Array.newInstance(this.clazz, n);
	}
	
	/**
	 * An integer is specified to identify the stack and will report if the size of that stack is zero.
	 * If the integer passed doesn't exist then report if all stack sizes are zero.
	 * @param stack
	 * @return
	 */
	public boolean empty(int stack){
		switch(stack){
		case 1: return this.c1 == 0;
		case 2: return this.c2 == 0;
		case 3: return this.c3 == 0;
		}
		return this.empty();
	}
	
	/**
	 * Reports if the sum of all stack sizes are zero.
	 * @return
	 */
	public boolean empty(){
		return this.size() == 0;
	}
	
	/**
	 * An integer is specified to identify the stack and will report the size of that stack.
	 * If the integer passed doesn't exist then report sum of all stack sizes.
	 * @param stack
	 * @return
	 */
	public int size(int stack){
		switch(stack){
		case 1: return this.c1;
		case 2: return this.c2;
		case 3: return this.c3;
		}
		return size();
	}
	
	/**
	 * Reports the sum of all stack sizes.
	 * @param stack
	 * @return
	 */
	public int size(){
		return this.c1 + this.c2 + this.c3;
	}
	
	/**
	 * Reports if the array is full.
	 * @return
	 */
	public boolean full(){
		return this.size() == this.n;
	}
	
	/**
	 * We default by pointing at the index of next insertion so when peeking or popping we must 
	 * return values one previous to the current stack index.
	 * @param stack
	 * @return
	 */
	public T peek(int stack){
		switch(stack){
		case 1: return this.empty(stack) ? null : this.arr[this.s1 - 1];
		case 2: return this.empty(stack) ? null : this.arr[this.s2 - 1];
		case 3: return this.empty(stack) ? null : this.arr[this.s3 - 1];
		}
		return null;
	}
	
	/**
 	 * We default by pointing at the index of next insertion so when peeking or popping we must 
	 * return values one previous to the current stack index. 
	 * We decrement the count after the operation.
	 * @param stack
	 * @return
	 */
	public T pop(int stack){
		switch(stack){
		case 1: if(this.empty(stack)) return null; this.c1--; return this.arr[--this.s1];
		case 2: if(this.empty(stack)) return null; this.c2--; return this.arr[--this.s2];
		case 3: if(this.empty(stack)) return null; this.c3--; return this.arr[--this.s3];
		}
		return null;
	}
	
	/**
	 * Push value on top of the stack whose id was given. 
	 * If that stack is about to overwrite the next stack then resize the array and reorder.
	 * @param item
	 * @param stack
	 * @return
	 */
	public T push(T item, int stack){
		if(item == null){
			return null;
		}else if(this.bordering(stack)){
			this.resizeAndReorderArray();
		}
		
		switch(stack){
		case 1: this.c1++; if(this.s1==this.n) this.s1 = 0; this.arr[this.s1++] =  item; break;
		case 2: this.c2++; if(this.s2==this.n) this.s2 = 0; this.arr[this.s2++] =  item; break;
		case 3: this.c3++; if(this.s3==this.n) this.s3 = 0; this.arr[this.s3++] =  item; break;
		}
		return item;
	}
	
	/**
	 * This method will double the size of the array and redistribute the 
	 * values for each stack with equal spacing.
	 */
	private void resizeAndReorderArray(){
		int newN = this.n * 2;
		int newS1, newS2;
		int index = 0;
		int freeSpace = newN - this.size();
		int padding = (int) Math.floor(freeSpace * .3333);
		int bottom = this.bottom(1);
		T[] newArray = createArray(newN);
		
		for(int i=0; i < this.c1; i++){
			newArray[index++] = this.arr[bottom + i];
		}
		
		newS1 = index;
		index += padding;
		bottom = this.bottom(2);
		
		for(int i=0; i < this.c2; i++){
			newArray[index++] = this.arr[bottom + i];
		}
		
		newS2 = index;
		index += padding;
		bottom = this.bottom(3);
		
		for(int i=0; i < this.c3; i++){
			newArray[index++] = this.arr[bottom + i];
		}
		
		this.arr = newArray;
		this.n = newN;
		this.s1 = newS1;
		this.s2 = newS2;
		this.s3 = index;
	}
	
	
	/**
	 *  If the next push for the stack whose id was given will overwrite the bottom of the next stack this will return true.
	 * @param stack
	 * @return
	 */
	private boolean bordering(int stack){
		int wrapIndex;
		switch(stack){
		case 1: wrapIndex = this.s1 % this.n; return wrapIndex >= this.bottom(2) && wrapIndex <= this.s2 || wrapIndex >= this.bottom(3) && wrapIndex <= this.s3;
		case 2: wrapIndex = this.s2 % this.n; return wrapIndex >= this.bottom(3) && wrapIndex <= this.s3 || wrapIndex >= this.bottom(1) && wrapIndex <= this.s1;
		case 3: wrapIndex = this.s3 % this.n; return wrapIndex >= this.bottom(1) && wrapIndex <= this.s1 || wrapIndex >= this.bottom(2) && wrapIndex <= this.s2;
		}
		return bordering();
	}
	
	/**
	 * If the next push for any of the stacks will overwrite the bottom of the next stack it will return true.
	 * @return
	 */
	private boolean bordering(){
		return this.s1 >= this.bottom(2) && this.s1 <= this.s2 || this.s1 >= this.bottom(3) && this.s1 <= this.s3 &&
			   this.s2 >= this.bottom(3) && this.s2 <= this.s3 || this.s2 >= this.bottom(1) && this.s2 <= this.s1 &&
			   this.s3 >= this.bottom(1) && this.s3 <= this.s1 || this.s3 >= this.bottom(2) && this.s3 <= this.s2;
	}
	
	/**
	 * Reports the index of the bottom of the stack with respect to the stack id that was passed.
	 * E.g. say this.s1 = 3 and this.c1 = 2 
	 *  
	 * |0|1|2|3|4|5|6|7|8|...
	 *        ^
	 *        s1
	 * Then 1 will be returned
	 * @param stack
	 * @return
	 */
	private int bottom(int stack){
		int val = -1;
		switch(stack){
		case 1: val = this.s1 - this.c1; return val < 0 ? val + this.n : val;
		case 2: val = this.s2 - this.c2; return val < 0 ? val + this.n : val;
		case 3: val = this.s3 - this.c3; return val < 0 ? val + this.n : val;
		}
		return val;
	}
}
