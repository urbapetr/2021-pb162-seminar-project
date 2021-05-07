package cz.muni.fi.pb162.project.exception;

/**
 * @author Petr Urbanek
 */
public class EmptyDrawableException extends RuntimeException{

    /**
     * Constructor with only message
     * @param message given to Exception
     */
    public EmptyDrawableException(String message) {
        super(message);
    }

    /**
     * Constructor with cause and message
     * @param message given to Exception
     * @param cause given to ex
     */
    public EmptyDrawableException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructor with only cause
     * @param cause given to Exception
     */
    public EmptyDrawableException(Throwable cause) {
        super(cause);
    }
}
