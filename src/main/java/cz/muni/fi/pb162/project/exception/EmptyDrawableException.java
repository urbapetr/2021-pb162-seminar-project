package cz.muni.fi.pb162.project.exception;

/**
 * @author Petr Urbanek
 */
public class EmptyDrawableException extends RuntimeException{

    public EmptyDrawableException(String message) {
        super(message);
    }

    public EmptyDrawableException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmptyDrawableException(Throwable cause) {
        super(cause);
    }
}
