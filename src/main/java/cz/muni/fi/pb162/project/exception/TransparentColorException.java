package cz.muni.fi.pb162.project.exception;

/**
 * @author Petr Urbanek
 */
public class TransparentColorException extends RuntimeException{

    public TransparentColorException(String message) {
        super(message);
    }

    public TransparentColorException(String message, Throwable cause) {
        super(message, cause);
    }

    public TransparentColorException(Throwable cause) {
        super(cause);
    }
}
