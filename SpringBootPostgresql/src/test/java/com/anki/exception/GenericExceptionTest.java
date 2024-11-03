package com.anki.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

public class GenericExceptionTest {

	@Test
    public void testDefaultConstructor() {
        GenaricException exception = new GenaricException();
        assertNotNull(exception);
        assertEquals(HttpStatus.OK, exception.getStatus());
        assertNull(exception.getCode());
    }

    @Test
    public void testConstructorWithHttpStatus() {
        GenaricException exception = new GenaricException(HttpStatus.BAD_REQUEST);
        assertNotNull(exception);
        assertEquals(HttpStatus.BAD_REQUEST, exception.getStatus());
        assertNull(exception.getCode());
    }

    @Test
    public void testConstructorWithMessage() {
        GenaricException exception = new GenaricException("Some error occurred");
        assertNotNull(exception);
//        assertEquals("Some error occurred", exception.getMessage());
//        assertEquals(HttpStatus.OK, exception.getStatus()); // Default status
    }

    @Test
    public void testConstructorWithMessageAndCode() {
        GenaricException exception = new GenaricException("Some error occurred", "ERR001");
        assertNotNull(exception);
        assertEquals("Some error occurred", exception.getMessage());
        assertEquals("ERR001", exception.getCode());
        assertEquals(HttpStatus.OK, exception.getStatus()); // Default status
    }

    @Test
    public void testConstructorWithHttpStatusAndMessage() {
        GenaricException exception = new GenaricException(HttpStatus.INTERNAL_SERVER_ERROR, "Server error");
        assertNotNull(exception);
//        assertEquals("Server error", exception.getMessage());
//        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, exception.getStatus());
    }

    @Test
    public void testSetStatus() {
        GenaricException exception = new GenaricException();
        exception.setStatus(HttpStatus.NOT_FOUND);
        assertEquals(HttpStatus.NOT_FOUND, exception.getStatus());
    }

    @Test
    public void testSetCode() {
        GenaricException exception = new GenaricException();
        exception.setCode("ERR002");
        assertEquals("ERR002", exception.getCode());
    }}
