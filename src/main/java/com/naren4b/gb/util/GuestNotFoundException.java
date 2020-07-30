package com.naren4b.gb.util;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class GuestNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public GuestNotFoundException(Long id) {
		super("Guest Not found " + id);
	}

	public GuestNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public GuestNotFoundException(String message) {
		super(message);
	}

	public GuestNotFoundException(Throwable cause) {
		super(cause);
	}

}
