package com.anki.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

public class CustomExceptionTest {

	 @Test
	    public void testDefaultConstructor() {
	        CustomException exception = new CustomException();
	        assertNotNull(exception);
	        assertNull(exception.getMessage());
	    }

	    @Test
	    public void testConstructorWithMessage() {
	        String errorMessage = "An error occurred";
	        CustomException exception = new CustomException(errorMessage);
	        assertNotNull(exception);
	        assertEquals(errorMessage, exception.getMessage());
	    }

	    @Test
	    public void testSetMessage() {
	        CustomException exception = new CustomException();
	        String newMessage = "Another error occurred";
	        exception.setMessage(newMessage);
	        assertEquals(newMessage, exception.getMessage());
	    }
}
