package square;

public class Square2 {
    public static void main(String[] args) {
        printSquare("hello");
        printSquare(5.5);
        printSquare(1);
    }

    private static void printSquare(String x) {
        for (int i = 0; i < x.length(); i++) {
            System.out.println(x);
        }
    }

    private static void printSquare(double x) {
        System.out.println(x * x);
    }

    private static void printSquare(int x) {
        System.out.println(x * x);
    }
}
