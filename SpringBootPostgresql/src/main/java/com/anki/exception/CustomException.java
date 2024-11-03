package com.anki.exception;

public class CustomException extends RuntimeException{
	   private String message;

	    public CustomException() {}

	    public CustomException(String msg) {
	        super(msg);
	        this.message = msg;
	    }

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}
	    

}
