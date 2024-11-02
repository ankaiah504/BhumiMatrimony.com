package com.app.array;

import java.util.Arrays;

public class Duplicates {

	public static void main(String[] args) {
		int arr[]= {4,5,4,7,9,6,3};
		for(int i=0; i < arr.length; i++){
	        for(int j=i+1; j < arr.length; j++) {
	            
	            if(arr[i]==arr[j]) {
	            	   System.out.println(arr[j]);  
	            }
	        }


		
		}
		}

}
