package exceptions;

public class MoraleNotFoundException extends RuntimeException{
    public MoraleNotFoundException(String message) {
        super(message);
    }
}
