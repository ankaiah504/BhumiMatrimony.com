package com.anki.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import com.anki.controller.GlobalExceptionController;
import com.anki.exception.CustomException;
import com.anki.exception.GenaricException;
import com.anki.models.ErrorResponse;

@WebMvcTest(GlobalExceptionController.class)
public class GlobalExceptionControllerTest {

    @Autowired
	    private GlobalExceptionController globalExceptionController;
	 @BeforeEach
	    public void setUp() {
	        MockitoAnnotations.openMocks(this);
	    }
	    @Test
	    public void testHandleCustomException() throws Exception {
	    	CustomException exception = new CustomException("Resource not found");
	        ResponseEntity<ErrorResponse> response = globalExceptionController.handleResourceNotFoundException(exception);
	        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), exception.getMessage());
	        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
	        assertThat(errorResponse.getMessage()).isEqualTo(exception.getMessage());

	    }

	    @Test
	    public void testHandleGenericException() throws Exception {
	        GenaricException genericException = new GenaricException("Generic error occurred");
	        ResponseEntity<ErrorResponse> response = globalExceptionController.handleResourceNotFoundException(genericException);
	        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), genericException.getMessage());
	        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
	        assertThat(errorResponse.getMessage()).isEqualTo(genericException.getMessage());
	      
}
	    @Test
	    public void handleValidationExceptions_ShouldReturnBadRequestWithErrors() {
	        // Arrange
	        BindingResult bindingResult = mock(BindingResult.class);
	        FieldError fieldError = new FieldError("objectName", "fieldName", "Invalid value");
	        
	        // Simulate the errors in the BindingResult
	        List<ObjectError> errors = Collections.singletonList(fieldError);
	        when(bindingResult.getAllErrors()).thenReturn(errors);
	        
	        MethodArgumentNotValidException exception = new MethodArgumentNotValidException(null, bindingResult);

	        // Act
	        ResponseEntity<Map<String, String>> response = globalExceptionController.handleValidationExceptions(exception);

	        // Assert
	        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
	        Map<String, String> expectedErrors = new HashMap<>();
	        expectedErrors.put("fieldName", "Invalid value");
	        assertThat(response.getBody()).isEqualTo(expectedErrors);
	    }

}
