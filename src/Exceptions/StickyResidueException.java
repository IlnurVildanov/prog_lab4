package Exceptions;

public class StickyResidueException extends RuntimeException {
    public StickyResidueException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return "StickyResidueException: " + super.getMessage();
    }
}
