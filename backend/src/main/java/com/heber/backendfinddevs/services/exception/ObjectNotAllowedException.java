package com.heber.backendfinddevs.services.exception;

public class ObjectNotAllowedException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ObjectNotAllowedException(String msg) {
		super(msg);
	}

}
