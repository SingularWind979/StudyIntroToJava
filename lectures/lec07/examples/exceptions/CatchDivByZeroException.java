package exceptions;

/**
 * Class to catch DivByZeroException.
 *
 * @author SingularWind
 */
public class CatchDivByZeroException {
    public static void div(int a, int b) throws DivByZeroException {
        if (b == 0) {
            throw new DivByZeroException("Divisor cannot be zero");
        }
        int c = a / b;
        System.out.println("Result: " + c);
    }

    public static void main(String[] args) {
        try {
            div(10, 0);
        } catch (ArithmeticException e) {
            System.out.println("DivByZeroException: " + e.getMessage() + "!!!");
        }
    }
}
