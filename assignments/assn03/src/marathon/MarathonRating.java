package marathon;

public class MarathonRating {
    public static void main(String[] arguments) {
        String[] names = {
            "Elena", "Thomas", "Hamilton", "Suzie",
            "Phil", "Matt", "Alex", "Emma",
            "John", "James", "Jane", "Emily",
            "Daniel", "Neda", "Aaron", "Kate"
        };
        int[] times = {
            341, 273, 278, 329,
            445, 402, 388, 275,
            243, 334, 412, 393,
            299, 343, 317, 265
        };

        int firstRunnerIdx = getMinIdx(times);
        int secondRunnerIdx = getSecondMinIdx(times);

        System.out.println("Boston Marathon");
        System.out.println("| Name \t| Time(min)\t| ");
        System.out.println("-".repeat(25));
        for (int i = 0; i < names.length; i++) {
            System.out.printf("| %s \t| %d \t| %n", names[i], times[i]);
        }
        System.out.println("-".repeat(40));
        System.out.printf("the first  fastest runner: %s (%d) %n", names[firstRunnerIdx], times[firstRunnerIdx]);
        System.out.printf("the second fastest runner: %s (%d) %n", names[secondRunnerIdx], times[secondRunnerIdx]);
        System.out.println("-".repeat(40));
    }

    /**
     * return the index of the smallest value.
     *
     * @param values an array of values
     * @return the index of the smallest value
     * @throws IllegalArgumentException if The length of array is less than 1
     */
    public static int getMinIdx(int[] values) {
        if (values.length < 1) {
            throw new IllegalArgumentException("The length of array is less than 1.");
        }
        int minIdx = 0;
        for (int i = 0; i < values.length; i++) {
            if (values[i] < values[minIdx]) {
                minIdx = i;
            }
        }
        return minIdx;
    }

    /**
     * return the index of the second-smallest value.
     *
     * @param values an array of values
     * @return the index of the second-smallest value
     * @throws IllegalArgumentException if the length of array is less than 2
     */
    public static int getSecondMinIdx(int[] values) {
        if (values.length < 2) {
            throw new IllegalArgumentException("The length of array is less than 2.");
        }
        int minIdx = getMinIdx(values);
        int secondMinIdx = 0;
        for (int i = 0; i < values.length; i++) {
            if (i == minIdx) {
                continue;
            }
            if (values[i] < values[secondMinIdx]) {
                secondMinIdx = i;
            }
        }
        return secondMinIdx;
    }
}
