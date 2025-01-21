package Exceptions;

public class NoMorePorridgeException extends Exception {
    public NoMorePorridgeException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return "NoMorePorridgeException: " + super.getMessage();
    }
}
