package pismo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class TransactionBlockedException extends RuntimeException {
	private static final String MESSAGE_WIRH_COMPLEMENT = "Transaction blocked: ";
	private static final String MESSAGE = "Transaction blocked.";
	private static final long serialVersionUID = 1L;

	public TransactionBlockedException(){
		super(MESSAGE);
	}
	
	public TransactionBlockedException(String message){
        super(MESSAGE_WIRH_COMPLEMENT.concat(message));
	}
}
