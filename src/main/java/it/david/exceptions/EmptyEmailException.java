package it.david.exceptions;

public class EmptyEmailException extends Exception {
	public EmptyEmailException(String message) {
		super(message);
	}

}
