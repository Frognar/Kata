package pl.frognar._02;

public class NegativeNumbersNotAllowedException extends RuntimeException {
    public NegativeNumbersNotAllowedException(String message) {
        super(message);
    }
}
