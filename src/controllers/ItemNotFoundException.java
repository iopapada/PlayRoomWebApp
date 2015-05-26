package controllers;

public class ItemNotFoundException extends Exception {

	private static final long serialVersionUID = 470763783492723435L;

	public ItemNotFoundException(String itemCode) {
        super("Item not found with code: " + itemCode);
    }

}
