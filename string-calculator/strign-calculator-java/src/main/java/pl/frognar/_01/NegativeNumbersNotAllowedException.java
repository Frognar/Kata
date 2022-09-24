package pl.frognar._01;

public class NegativeNumbersNotAllowedException extends RuntimeException {
    public NegativeNumbersNotAllowedException(String message) {
        super(message);
    }
}
