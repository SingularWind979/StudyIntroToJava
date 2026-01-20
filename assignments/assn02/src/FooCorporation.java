public class FooCorporation {
    public static final double MIN_PAY = 8.0;
    public static final int MIN_HOURS = 0;
    public static final int MID_HOURS = 40;
    public static final int MAX_HOURS = 60;

    public static void main(String[] args) {
        printTotalPay("Employee 1", 7.5, 35);
        printTotalPay("Employee 2", 8.2, 47);
        printTotalPay("Employee 3", 10.0, 73);
    }

    private static void printTotalPay(String name, double basePay, int hoursWorked) {
        System.out.println("name = " + name +  ", basePay = " + basePay + ", hoursWorked = " + hoursWorked);
        if (basePay < MIN_PAY) {
            System.out.println("ERROR, the base pay must not be less than the minimum wage ($" + MIN_PAY + " an hour).");
            return;
        }
        if (hoursWorked < MIN_HOURS || hoursWorked > MAX_HOURS) {
            System.out.println("ERROR, the number of hours must between " + MIN_HOURS + " and " + MAX_HOURS + ".");
            return;
        }

        double totalPay;
        if(hoursWorked <= MID_HOURS) {
            totalPay = basePay * hoursWorked;
        } else {
            totalPay = basePay * MID_HOURS
                     + basePay * 1.5 * (hoursWorked - MID_HOURS);
        }
        System.out.println("totalPay = " + totalPay);
    }
}
