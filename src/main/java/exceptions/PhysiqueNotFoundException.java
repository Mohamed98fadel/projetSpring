package exceptions;

public class PhysiqueNotFoundException extends RuntimeException{
    public PhysiqueNotFoundException(String message) {
        super(message);
    }
}
