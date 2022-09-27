package pl.frognar._04;

public class NegativeNumbersNotAllowedException extends RuntimeException {
    public NegativeNumbersNotAllowedException(String message) {
        super(message);
    }
}
