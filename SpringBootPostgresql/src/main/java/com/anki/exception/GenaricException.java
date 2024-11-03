package com.anki.exception;

import org.springframework.http.HttpStatus;

public class GenaricException extends RuntimeException{

	HttpStatus status=HttpStatus.OK;
	private String code;
	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public GenaricException() {
	}
	public GenaricException(HttpStatus status) {
		super();
		this.status = status;
	}
	
	public GenaricException(String message) {
		super();
		
	}
	public GenaricException(String messag,String code) {
		
		super(messag);
		this.code=code;
	}
	public GenaricException(HttpStatus status,String message) {
		super();
		this.status = status;
	}
}
