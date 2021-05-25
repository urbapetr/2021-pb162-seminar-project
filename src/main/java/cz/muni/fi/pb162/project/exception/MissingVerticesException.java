package cz.muni.fi.pb162.project.exception;

/**
 * @author Petr Urbanek
 */
public class MissingVerticesException extends RuntimeException{

    /**
     * Constructor with only message
     * @param message given to Exception
     */
    public MissingVerticesException(String message) {
        super(message);
    }

    /**
     * Constructor with cause and message
     * @param message given to Exception
     * @param cause given to ex
     */
    public MissingVerticesException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructor with only cause
     * @param cause given to ex
     */
    public MissingVerticesException(Throwable cause) {
        super(cause);
    }
}
