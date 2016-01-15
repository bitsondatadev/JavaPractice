package Algorithms;

import java.util.List;

public class Sorting<T extends Comparable<? super T>> {
	
	/**
	 * Insertion Sort
	 *  - Time Complexity: O(n^2)
	 *  - Space Complexity: O(1)
	 * @param array
	 */
	public static <T> void insertionSort(List<T> array){
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
	
	
}
