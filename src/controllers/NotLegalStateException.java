package controllers;

public class NotLegalStateException extends Exception {

	private static final long serialVersionUID = -445536974775000275L;

	public NotLegalStateException() {
        super("Illegal values have inserted!");
    }
	
}
