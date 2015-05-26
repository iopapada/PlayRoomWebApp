package controllers;

public class ItemDuplicateException extends Exception {

	private static final long serialVersionUID = -1554668844543625771L;

	public ItemDuplicateException(String itemCode) {
        super("Item with code: " + itemCode + " already exists!");
    }
}
