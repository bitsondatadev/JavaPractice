package Algorithms;

import java.util.Arrays;

public class MedianOfMedians {
    public static void findMedian(int arr[]){
        //int median = deterministicSelect(arr,(arr.length)/2 + 1,0,arr.length-1);
        int median = DSelect(arr,(arr.length)/2 + 1,0,arr.length-1);
        System.out.println("Median = " + median);
    }
    
    public static void findPthOrderStatistic(int arr[], int p){
    	if(p >= 0 && p <= 100){
	    	int stat = deterministicSelect(arr,(int) Math.round(p * .01 * arr.length) ,0,arr.length-1);
	        System.out.println("Pth order statistic = " + stat);
    	}else{
    		System.out.println("Invalid P");
    	}
    }
    
    private static int DSelect(int A[],int i,int low,int high){
        // Uncomment this if you want to print the current subArray being processed/searched
        //printArray(arr, low, high);
    	//*******************CHOOSE PIVOT SEGMENT******************************
        if(low == high){
            return A[low];
        }else if(high-low+1 <= 9){
        	// If number of elements in the array are small, return the actual median
            Arrays.sort(A);
            return A[A.length/2];
        }
        
        //Otherwise divide the array into subarray of 5 elements each, and recursively find the median
        
        // Array to hold '5 element' subArray, last subArray may have less than 5 elements
        int temp[] = null;
        // iterator to move from low to high value
        int iter = low;
        
        // Array to hold the medians of all '5-element SubArrays'
        int C[] = new int[(int)Math.ceil((double)(high-low+1)/5)];
        int medianIndex = 0;
        
        
        while(iter <= high){
            // get size of the next element, it can be less than 5
            temp = new int[Math.min(5,high-iter+1)];
            
            // copy next 5 (or less) elements, in the subarray
            for(int j=0;j<temp.length && iter <= high;j++){
                temp[j] = A[iter];
                iter++;
            }
            
            // sort subArray
            Arrays.sort(temp);
            
            // find mean and store it in median Array
            C[medianIndex] = temp[temp.length/2];
            medianIndex++;
        }
        //*******************END CHOOSE PIVOT SEGMENT******************************
        
        // Call recursively to get pivotvalue
        int p = DSelect(C,C.length/5,0,C.length - 1);
        
        // sort the mth largest element in the given array
        int j = partition(A,low,high, p);
        
        // Adjust position relative to the current subarray being processed
        // This is not in the initial algorithm because it doesn't have arrays
        // that start at 0 so we must offset the index by 1 and 
        int jPos = j - low + 1;
        
        // If mth element is the median, return it
        if(jPos == i){
            return A[j];
        }
        
        // If mth element is greater than median, search in the left subarray
        if(jPos > i){
            return DSelect(A,i,low,j-1);
        }else{
        	// otherwise search in the right subArray
            return DSelect(A,i-jPos,j+1,high);
        }
        
    }
    
    private static int deterministicSelect(int arr[],int i,int low,int high){
        // Uncomment this if you want to print the current subArray being processed/searched
        //printArray(arr, low, high);
        if(low == high){
            return arr[low];
        }
        
        // Get pivotvalue by finding median of medians
        int p = choosePivot(arr, low, high);   
        
        // sort the mth largest element in the given array
        int j = partition(arr,low,high, p);
        
        // Adjust position relative to the current subarray being processed
        int length = j - low + 1;
        
        // If mth element is the median, return it
        if(length == i){
            return arr[j];
        }
        
        // If mth element is greater than median, search in the left subarray
        if(length > i){
            return deterministicSelect(arr,i,low,j-1);
        }else{
        	// otherwise search in the right subArray
            return deterministicSelect(arr,i-length,j+1,high);
        }
        
    }
    
    // Find pivot value, such the it is always 'closer' to the actual median
    private static int choosePivot(int arr[],int low,int high){
        // If number of elements in the array are small, return the actual median
        if(high-low+1 <= 9){
            Arrays.sort(arr);
            return arr[arr.length/2];
        }
        
        //Otherwise divide the array into subarray of 5 elements each, and recursively find the median
        
        // Array to hold '5 element' subArray, last subArray may have less than 5 elements
        int temp[] = null;
        
        // Array to hold the medians of all '5-element SubArrays'
        int medians[] = new int[(int)Math.ceil((double)(high-low+1)/5)];
        int medianIndex = 0;
        
        while(low <= high){
            // get size of the next element, it can be less than 5
            temp = new int[Math.min(5,high-low+1)];
            
            // copy next 5 (or less) elements, in the subarray
            for(int j=0;j<temp.length && low <= high;j++){
                temp[j] = arr[low];
                low++;
            }
            
            // sort subArray
            Arrays.sort(temp);
            
            // find mean and store it in median Array
            medians[medianIndex] = temp[temp.length/2];
            medianIndex++;
        }
        
        // Call recursively to find median of medians
        return choosePivot(medians,0,medians.length-1);
    }
    
    
    private static int partition(int arr[],int low, int high, int p){
        // Find the sorted position for pivotVale and return it's index
        while(low < high){
            while(arr[low] < p){
                low ++;
            }
            
            while(arr[high] > p){
                high--;
            }
            
            if(arr[low] == arr[high]){
                low ++;
            }else if(low < high){
                int temp = arr[low];
                arr[low] = arr[high];
                arr[high] = temp;
            }
                
        }
        return high;
    }
    
   
    
    public static void main(String args[]){
        int nElements = 11;
        int arr[] = new int[nElements];
        
        for(int i=0;i<nElements;i++){
            arr[i] = (int)(2000*Math.random());
        }
        
        arr = new int[]{1,2,3,4,5,6,7,8,9,10,11};
        
        System.out.print("Array");
        printArray(arr, 0, nElements);
        
        MedianOfMedians.findMedian(arr);
        
        java.util.Arrays.sort(arr);
        System.out.print(" Sorted Array - ");
        printArray(arr, 0, nElements);
        System.out.println("Median using sorting - " + arr[(arr.length)/2]);
    }
    
    private static void printArray(int arr[],int low, int high){
        System.out.print("[  ");
        for(int i=low;i<high;i++){
            System.out.print(arr[i] + "  ");
        }
        System.out.println("]");
    }
}