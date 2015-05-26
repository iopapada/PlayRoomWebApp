package controllers;

public class OutOfStockException extends Exception {
	private static final long serialVersionUID = -445536974775000275L;

	public OutOfStockException() {
        super("Not availiable items!");
    }
}
