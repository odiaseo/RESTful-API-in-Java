package com.peleodiase.bbc;
/**
 * Resource not found
 * 
 * @author Pele Odiase
 *
 */
public class ResourceNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(String msg) {
		super(msg);
	}
}
