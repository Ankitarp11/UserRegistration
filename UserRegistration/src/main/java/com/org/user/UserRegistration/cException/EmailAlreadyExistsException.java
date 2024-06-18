package com.org.user.UserRegistration.cException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FOUND)
public class EmailAlreadyExistsException extends RuntimeException{
	
	public EmailAlreadyExistsException(String message) {
		
		super(message);
	}

}
