package pl.frognar._03;

public class NegativeNumbersNotAllowedException extends RuntimeException {
    public NegativeNumbersNotAllowedException(String message) {
        super(message);
    }
}
