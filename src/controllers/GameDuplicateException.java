package controllers;

public class GameDuplicateException extends Exception {
	private static final long serialVersionUID = -4285169069469813582L;

    public GameDuplicateException(String gameCode) {
        super("Game with code: " + gameCode + " already exists!");
    }
}
