public class Marathon {
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
        
        int firstIdx = firstRunnerIdx(times);
        int secondIdx = secondRunnerIdx(times);
        
        System.out.println("Boston Marathon");
        System.out.println("| Name \t| Time(min)\t| ");
        System.out.println("-".repeat(25));
        for (int i = 0; i < names.length; i++) {
            System.out.printf("| %s \t| %d \t| %n", names[i], times[i]);
        }
        System.out.println("-".repeat(40));
        System.out.printf("the first  fastest runner: %s (%d) %n", names[firstIdx], times[firstIdx]);
        System.out.printf("the second fastest runner: %s (%d) %n", names[secondIdx], times[secondIdx]);
        System.out.println("-".repeat(40));
    }

    /**
     * return the index of the fastest runner.
     *
     * @param times every runner's time
     * @return the index corresponding to the person with the lowest time
     */
    private static int firstRunnerIdx(int[] times) {
        int firstIdx = 0;
        for (int i = 0; i < times.length; i++) {
            if (times[i] < times[firstIdx]) {
                firstIdx = i;
            }
        }
        return firstIdx;
    }

    /**
     * return the index of the second-fastest runner.
     *
     * @param times every runner's time
     * @return the index corresponding to the person with the second-lowest time
     */
    private static int secondRunnerIdx(int[] times) {
        int firstIdx = 0;
        int secondIdx = 0;
        for (int i = 0; i < times.length; i++) {
            if (times[i] < times[firstIdx]) {
                secondIdx = firstIdx;
                firstIdx = i;
            } else if (times[i] < times[secondIdx]) {
                secondIdx = i;
            }
        }
        return secondIdx;
    }
}
