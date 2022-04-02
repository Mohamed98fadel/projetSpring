package exceptions;

public class ObjetNotFoundException extends RuntimeException{
    public ObjetNotFoundException(String message) {
        super(message);
    }
}
