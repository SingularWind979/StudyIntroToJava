public class Square1 {
    public static void main(String[] args) {
        int value = 2;
        printSquare(value);
        printSquare(3);
        printSquare(value * 2);
    }

    private static void printSquare(int x) {
        System.out.println(x * x);
    }
}
