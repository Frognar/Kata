package pl.frognar._05;

public class NegativeNumbersNotAllowedException extends RuntimeException {
    public NegativeNumbersNotAllowedException(String message) {
        super(message);
    }
}
