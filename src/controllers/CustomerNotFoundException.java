package controllers;

public class CustomerNotFoundException extends Exception {
	
    private static final long serialVersionUID = -4285169469813582L;

    public CustomerNotFoundException(String customerCode) {
        super("Customer not found with code: " + customerCode);
    }


}
