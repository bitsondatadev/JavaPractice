package Algorithms;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Sorting<T extends Comparable<? super T>> {
	
	/**
	 * Insertion Sort
	 *  - Time Complexity: O(n^2)
	 *  - Space Complexity: O(1)
	 * @param array
	 */
	public static <T> void insertionsort(List<T> array){
		for(int i = 1; i < array.size(); i++){
			T val = array.get(i);
         int j = i - 1;
         while(j >= 0 && ((Comparable<? super T>) array.get(j)).compareTo(val) > 0){
         	array.set(j + 1, array.get(j));
            j--;
         }
         array.set(j + 1, val);
		}
	}

	/**
	 * Mergesort
	 *  - Time Complexity: O(nlog(n))
	 *  - Space Complexity: O(n)
	 * @param array
	 */
	public static <T> void mergesort(List<T> array){
		if(array == null){
			return;
		}
		List<T> helper = new ArrayList<T>(Collections.nCopies(array.size(), null));
		mergesort(array, helper, 0, array.size() - 1); 
	}

	private static <T> void mergesort(List<T> array, List<T> helper, int low, int high){
		if(low < high){
			int middle = (low + high)/2;
			mergesort(array, helper, low, middle); 
			mergesort(array, helper, middle + 1, high);
			merge(array, helper, low, middle, high);
		}
	}

	private static <T> void merge(List<T> array, List<T> helper, int low, int middle, int high){
		for(int i = low; i <= high; i++){
			helper.set(i, array.get(i));
		}
		int helperLeft = low;
		int helperRight = middle + 1;
		int current = low;

		while(helperLeft <= middle && helperRight <= high){
			if(((Comparable<? super T>)helper.get(helperLeft)).compareTo(helper.get(helperRight)) <= 0){
				array.set(current++, helper.get(helperLeft++));
			}else{
				array.set(current++, helper.get(helperRight++));
			}
		}

		int remaining = middle - helperLeft;
		for(int i = 0; i <= remaining; i++){
			array.set(current + i, helper.get(helperLeft + i));
		}
	}

	/**
	 * Quicksort
	 *  - Time Complexity: O(n^2)
	 *  - Average Time Complexity: O(nlog(n))
	 *  - Space Complexity: O(1)
	 * @param array
	 */
	public static <T> void quicksort(List<T> array){
		quicksort(array, 0, array.size() - 1);
	}

	private static<T> void quicksort(List<T> array, int low, int high){
		if(low >= high){
	    return;
	 	}
		int pi = partition(array, low, high);
		quicksort(array, low, pi - 1);
		quicksort(array, pi + 1, high);
	}

	public static <T> int partition(List<T> array, int low, int high){
		T p = array.get(high);
		int i = low;
		for(int j = low; j < high; j++){
		    if(((Comparable<? super T>) array.get(j)).compareTo(p) <= 0){
 	      T temp = array.get(i);
		  		array.set(i,array.get(j));
				array.set(j,temp);
				i++;
	 	   }
	 	}
		array.set(high, array.get(i));
		array.set(i,p);
		return i;
	}
}
