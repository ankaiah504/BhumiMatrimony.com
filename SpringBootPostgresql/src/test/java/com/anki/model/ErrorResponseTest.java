package com.anki.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.anki.models.ErrorResponse;

public class ErrorResponseTest {


    private ErrorResponse errorResponse;

    @BeforeEach
    public void setUp() {
        errorResponse = new ErrorResponse();
    }

    @Test
    public void testDefaultConstructor() {
        assertNotNull(errorResponse);
        assertEquals(0, errorResponse.getStatus());
        assertNull(errorResponse.getMessage());
        assertTrue(errorResponse.getTimestamp() > 0);
    }

    @Test
    public void testParameterizedConstructor() {
        int status = 404;
        String message = "Not Found";
        
        errorResponse = new ErrorResponse(status, message);

        assertEquals(status, errorResponse.getStatus());
        assertEquals(message, errorResponse.getMessage());
        assertTrue(errorResponse.getTimestamp() > 0);
    }

    @Test
    public void testSetStatus() {
        errorResponse.setStatus(500);
        assertEquals(500, errorResponse.getStatus());
    }

    @Test
    public void testSetMessage() {
        errorResponse.setMessage("Internal Server Error");
        assertEquals("Internal Server Error", errorResponse.getMessage());
    }

    @Test
    public void testSetTimestamp() {
        long timestamp = System.currentTimeMillis();
        errorResponse.setTimestamp(timestamp);
        assertEquals(timestamp, errorResponse.getTimestamp());
    }

    @Test
    public void testToString() {
        errorResponse.setStatus(400);
        errorResponse.setMessage("Bad Request");
        String expectedString = "ErrorResponse [status=400, message=Bad Request, timestamp=" + errorResponse.getTimestamp() + "]";
        assertEquals(expectedString, errorResponse.toString());
    }}
