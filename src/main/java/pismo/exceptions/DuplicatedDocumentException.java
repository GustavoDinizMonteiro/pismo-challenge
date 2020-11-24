package pismo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class DuplicatedDocumentException extends RuntimeException {
	private static final String MESSAGE_WIRH_COMPLEMENT = "Duplicated document number: ";
	private static final String MESSAGE = "Duplicated document number.";
	private static final long serialVersionUID = 1L;

	public DuplicatedDocumentException(){
		super(MESSAGE);
	}
	
	public DuplicatedDocumentException(String message){
        super(MESSAGE_WIRH_COMPLEMENT.concat(message));
    }
}
