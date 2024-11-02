package com.app.array;

/*Compare the first two adjacent elements.
If the first element is greater than the second, swap them.
Move to the next pair of adjacent elements and repeat step 3.
Continue this process for the entire list.
Repeat the entire process until no swaps are needed, indicating that the list is sorted.*/
public class BubbleSort {
	public static void bubbleSort(int[] arr) {
        int n = arr.length;
        
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                 
                }
            }
            
        }
    }

    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        bubbleSort(arr);
        
        System.out.println("Sorted array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

}
