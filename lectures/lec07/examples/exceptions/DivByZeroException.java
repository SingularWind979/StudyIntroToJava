package exceptions;

/**
 * Exception thrown when a divisor is zero.
 *
 * @author SingularWind
 */
public class DivByZeroException extends ArithmeticException {
    public DivByZeroException(String message) {
        super(message);
    }
}
