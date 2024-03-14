package goosegame;

/**
 * An exception class to indicate that there are no available players
 */
public class NoPlayerException extends Exception {
    public NoPlayerException() {
        super();
    }

    public NoPlayerException(String arg) {
        super(arg);
    }
}
