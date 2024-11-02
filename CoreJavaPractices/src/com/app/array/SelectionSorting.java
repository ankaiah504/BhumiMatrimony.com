package com.app.array;

public class SelectionSorting {

	  public static void selectionSort(int[] arr) {
	        int n = arr.length;

	        for (int i = 0; i < n - 1; i++) {
	            // Assume the minimum is the first element in the unsorted part
	            int minIndex = i;
	            for (int j = i + 1; j < n; j++) {
	                // Find the index of the minimum element
	                if (arr[j] < arr[minIndex]) {
	                    minIndex = j;
	                }
	            }
	            ////// Swap the found minimum element with the first unsorted element
	            if (minIndex != i) {
	                int temp = arr[minIndex];
	                arr[minIndex] = arr[i];
	                arr[i] = temp;
	            }
	        }
	    }

	    public static void main(String[] args) {
	        int[] arr = {64, 25, 12, 22, 11};
	        selectionSort(arr);
	        
	        System.out.println("Sorted array:");
	        for (int num : arr) {
	            System.out.print(num + " ");
	        }
	    }
}
