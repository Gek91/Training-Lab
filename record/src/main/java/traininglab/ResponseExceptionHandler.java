package traininglab;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import traininglab.core.exception.PermissionException;

import javax.persistence.EntityNotFoundException;

@ControllerAdvice
public class ResponseExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = {IllegalArgumentException.class})
	public ResponseEntity illegalArgumentExceptionHandler(IllegalArgumentException exception) {
		return new ResponseEntity(exception.getMessage(), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = {EntityNotFoundException.class})
	public ResponseEntity entityNotFoundExceptionHandler(EntityNotFoundException exception) {
		return new ResponseEntity(exception.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = {PermissionException.class})
	public ResponseEntity permissionExceptionHandler(PermissionException exception) {
		return new ResponseEntity(exception.getMessage(), HttpStatus.FORBIDDEN);
	}
}
