package Chapter3;

import java.lang.reflect.Array;

public class Question1<T>{

	private Class<T> clazz;
	private T[] arr;
	private int s1, s2, s3, c1, c2, c3, n;

	public Question1(Class<T> clazz, int n){
		this.clazz = clazz;
		this.n = n < 3 ? 3 : n;

		this.arr = createArray(n);
		this.s1 = 0;
		this.s2 = (int) Math.ceil(n * .3333);
		this.s3 = this.s2 * 2;
		this.s3 = this.s3 >= n ? n - 1 : this.s3;
		this.c1 = this.c2 = this.c3 = 0;
		
	}
	
	@SuppressWarnings("unchecked")
	private T[] createArray(int n){
		return (T[])Array.newInstance(this.clazz, n);
	}
	
	public boolean empty(int stack){
		switch(stack){
		case 1: return c1==0;
		case 2: return c2==0;
		case 3: return c3==0;
		}
		return c1==0 && c2==0 && c3==0;
	}
	
	public T peek(int stack){
		switch(stack){
		case 1: return this.empty(stack) ? null : this.arr[this.s1];
		case 2: return this.empty(stack) ? null : this.arr[this.s2];
		case 3: return this.empty(stack) ? null : this.arr[this.s3];
		}
		return null;
	}
	
	public T pop(int stack){
		switch(stack){
		case 1: if(this.empty(stack)) return null; this.c1--; return this.arr[this.s1--];
		case 2: if(this.empty(stack)) return null; this.c2--; return this.arr[this.s2--];
		case 3: if(this.empty(stack)) return null; this.c3--; return this.arr[this.s3--];
		}
		return null;
	}
	
	public T push(T item, int stack){
		if(item == null){
			return null;
		}else if(this.c1 + this.c2 + this.c3 == this.n || bordering()){
			resizeArray();
		}
		
		switch(stack){
		case 1: this.c1++; this.arr[++this.s1] =  item; break;
		case 2: this.c2++; this.arr[++this.s2] =  item; break;
		case 3: this.c3++; this.arr[++this.s3] =  item; break;
		}
		return item;
	}
	
	private void resizeArray(){
		
	}
	
	private boolean bordering(){
		return (this.s1 + 1 >= bottom(2) || this.s1 + 1 >= bottom(3)) &&
			   (this.s2 + 1 >= bottom(3) || this.s2 + 1 >= bottom(1)) &&
			   (this.s3 + 1 >= bottom(1) || this.s3 + 1 >= bottom(2));
	}
	
	private int bottom(int stack){
		int val = -1;
		switch(stack){
		case 1: val = this.s1 - this.c1; return val < 0 ? val + n : val;
		case 2: val = this.s2 - this.c2; return val < 0 ? val + n : val;
		case 3: val = this.s3 - this.c3; return val < 0 ? val + n : val;
		}
		return val;
	}
	
	public int size(int stack){
		switch(stack){
		case 1: return this.c1;
		case 2: return this.c2;
		case 3: return this.c3;
		}
		return this.c1 + this.c2 + this.c3;
	}
}
