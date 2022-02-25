package exceptions;

public class ReferenceNotFoundException extends RuntimeException{
    public ReferenceNotFoundException(String message) {
        super(message);
    }
}
