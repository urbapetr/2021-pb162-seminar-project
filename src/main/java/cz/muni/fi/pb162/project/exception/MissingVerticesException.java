package cz.muni.fi.pb162.project.exception;

/**
 * @author Petr Urbanek
 */
public class MissingVerticesException extends Exception{

    public MissingVerticesException(String message) {
        super(message);
    }

    public MissingVerticesException(String message, Throwable cause) {
        super(message, cause);
    }

    public MissingVerticesException(Throwable cause) {
        super(cause);
    }
}
