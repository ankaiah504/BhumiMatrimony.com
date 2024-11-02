package com.app.core;

public class PassByReferencePassByValue {


	public static void main(String[] args) {
		//pass by value for primitives
		int a=25;
		passByValue(a);
		System.out.println("after method called"+a);
		//pass by reference for non primitives
		int[] arr= {123,134};
		passByReference(arr);
		System.out.println("after method reference called"+arr[0]);
	}
	public static void passByValue(int num) {
		System.out.println("befor"+num);
		num=35;
		System.out.println("befor"+num);	  
	}
	public static void passByReference(int[] num) {
		System.out.println("befor"+num);
		num[0]=35;
		System.out.println("befor"+num);	  
	}
}
