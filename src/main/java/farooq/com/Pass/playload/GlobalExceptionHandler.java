package farooq.com.Pass.playload;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import farooq.com.Pass.exception.ResourceNotFoundException;
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{
	



	    @ExceptionHandler(ResourceNotFoundException.class)
	    public ResponseEntity<ErrorDetails> handleResourceNotFoundException(
	    		ResourceNotFoundException ex,
	    		WebRequest webRequest) {
	        ErrorDetails errorDetails = new ErrorDetails(
	        		new Date(), 
	        		ex.getMessage(), 
	        		ex.getdetail());
	        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	    }
	}



