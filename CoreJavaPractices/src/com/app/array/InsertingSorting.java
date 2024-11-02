package com.app.array;

public class InsertingSorting {
	 void sort(int arr[])
	    {
	        int n = arr.length;
	        for (int i = 1; i < n; ++i) {
	            int key = arr[i];
	            int j = i - 1;

	            /* Move elements of arr[0..i-1], that are
	               greater than key, to one position ahead
	               of their current position */
	            while (j >= 0 && arr[j] > key) {
	                arr[j + 1] = arr[j];
	                j = j - 1;
	            }
	            arr[j + 1] = key;
	        }
	    }

	    /* A utility function to print array of size n */
	    static void printArray(int arr[])
	    {
	        int n = arr.length;
	        for (int i = 0; i < n; ++i)
	            System.out.print(arr[i] + " ");

	        System.out.println();
	    }

	    // Driver method
	    public static void main(String args[])
	    {
	        int arr[] = { 12, 11, 13, 5, 6 };

	        InsertingSorting ob = new InsertingSorting();
	        ob.sort(arr);

	        printArray(arr);
	    }
	
}
//{23, 1, 10, 5, 2}
//
//Initial:
//
//Current element is 23
//The first element in the array is assumed to be sorted.
//The sorted part until 0th index is : [23]
//First Pass:
//
//Compare 1 with 23 (current element with the sorted part).
//Since 1 is smaller, insert 1 before 23 .
//The sorted part until 1st index is: [1, 23]
//Second Pass:
//
//Compare 10 with 1 and 23 (current element with the sorted part).
//Since 10 is greater than 1 and smaller than 23 , insert 10 between 1 and 23 .
//The sorted part until 2nd index is: [1, 10, 23]
//Third Pass:
//
//Compare 5 with 1 , 10 , and 23 (current element with the sorted part).
//Since 5 is greater than 1 and smaller than 10 , insert 5 between 1 and 10
//The sorted part until 3rd index is : [1, 5, 10, 23]
//Fourth Pass:
//
//Compare 2 with 1, 5, 10 , and 23 (current element with the sorted part).
//Since 2 is greater than 1 and smaller than 5 insert 2 between 1 and 5 .
//The sorted part until 4th index is: [1, 2, 5, 10, 23]
//Final Array:
//
//The sorted array is: [1, 2, 5, 10, 23]
