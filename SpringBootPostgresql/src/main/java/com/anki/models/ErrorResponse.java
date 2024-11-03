package com.anki.models;

public class ErrorResponse {
	    private int status;
	    private String message;
	    private long timestamp;

	    public int getStatus() {
			return status;
		}

		public void setStatus(int status) {
			this.status = status;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

		public long getTimestamp() {
			return timestamp;
		}

		public void setTimestamp(long timestamp) {
			this.timestamp = timestamp;
		}

		public ErrorResponse() {
	        this.timestamp = System.currentTimeMillis();
	    }

	    public ErrorResponse(int status, String message) {
	        this.status = status;
	        this.message = message;
	        this.timestamp = System.currentTimeMillis();
	    }

		@Override
		public String toString() {
			return "ErrorResponse [status=" + status + ", message=" + message + ", timestamp=" + timestamp + "]";
		}
	
}
