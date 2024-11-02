package com.app.array;

public class StringArrayDuplicate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  String str = "beautiful beach";
		  char[] dupArr= str.toCharArray();
		  for(int i=0;i<dupArr.length;i++) {
			  for(int j=i+1;j<dupArr.length;j++) {
				  if(dupArr[i]==dupArr[j]) {
					  System.out.println(dupArr[j]);
				  }
			  }
		  }
	}

}
