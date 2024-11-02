package com.app.core;

public final class immutabilityclass {

	 private String data;
	 public immutabilityclass(String data) {
		   this.data=data;
		}
	
	public String getData() {
	   return data;
	}
	
	public static void main(String[] args) {
	   
		immutabilityclass im=new immutabilityclass("Ankaiah");
         System.out.println(im.getData()); 
          
	}

}
