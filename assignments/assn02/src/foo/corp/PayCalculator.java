package foo.corp;

/**
 * Utility class to calculate total pay.
 */
public final class PayCalculator {
    public static final double MIN_PAY = 8.0;
    public static final int MIN_HOURS = 0;
    public static final int MID_HOURS = 40;
    public static final int MAX_HOURS = 60;

    /**
     * Privates constructor to be a Utility class.
     */
    private PayCalculator() {}

    /**
     * Prints the total pay of the employee.
     *
     * @param name the name of the employee
     * @param basePay the base pay per hour of the employee
     * @param hoursWorked the hours worked per week of the employee
     */
    public static void printTotalPay(String name, double basePay, int hoursWorked) {
        System.out.printf("name = %s, basePay = %s, hoursWorked = %d.%n", name, basePay, hoursWorked);

        if (basePay < MIN_PAY) {
            System.out.printf("ERROR, the base pay must not be less than the minimum wage ($%s per hour).%n", MIN_PAY);
            return;
        }
        if (hoursWorked < MIN_HOURS || hoursWorked > MAX_HOURS) {
            System.out.printf("ERROR, the number of hours must between %d and %d hours per week.%n", MIN_HOURS, MAX_HOURS);
            return;
        }
        double totalPay = calculateTotalPay(basePay, hoursWorked);
        System.out.printf("totalPay of = %s.%n", totalPay);
    }

    /**
     * Calculates the total pay according to given base pay and hours worked.
     *
     * @param basePay the base pay per hour of the employee
     * @param hoursWorked the hours worked per week of the employee
     * @return the total pay of the employee
     */
    public static double calculateTotalPay(double basePay, int hoursWorked) {
        double totalPay;
        if(hoursWorked <= MID_HOURS) {
            totalPay = basePay * hoursWorked;
        } else {
            totalPay = basePay * MID_HOURS
                    + basePay * 1.5 * (hoursWorked - MID_HOURS);
        }
        return totalPay;
    }

    public static void main(String[] args) {
        printTotalPay("Employee 1", 7.5, 35);
        printTotalPay("Employee 2", 8.2, 47);
        printTotalPay("Employee 3", 10.0, 73);
    }
}
