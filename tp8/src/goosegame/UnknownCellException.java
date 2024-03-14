package goosegame;

/**
 * An exception class to indicate that a specified cell does not exist
 */
public class UnknownCellException extends Exception {
    public UnknownCellException() {
        super();
    }

    public UnknownCellException(String arg) {
        super(arg);
    }
}
