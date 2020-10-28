package pismo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EntityNotFoundException extends RuntimeException {
	private static final String MESSAGE_WIRH_COMPLEMENT = "Entity not found: ";
	private static final String MESSAGE = "Entity not found.";
	private static final long serialVersionUID = 1L;

	public EntityNotFoundException(){
		super(MESSAGE);
	}
	
	public EntityNotFoundException(String message){
        super(MESSAGE_WIRH_COMPLEMENT.concat(message));
    }

}
