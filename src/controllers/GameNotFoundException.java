package controllers;


public class GameNotFoundException extends Exception {
	
	private static final long serialVersionUID = -4285169469813582L;

    public GameNotFoundException(String gameCode) {
        super("Game not found with code: " + gameCode);
    }

}
