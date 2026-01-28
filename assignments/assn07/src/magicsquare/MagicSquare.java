package magicsquare;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * A class to represent a magic square.
 *
 * @author SingularWind
 */
public class MagicSquare {
    private List<List<Integer>> square; // The 2D array of the magic square
    private int n;                      // The size of the magic square
    private int sum;                    // The sum of each row, column, and diagonal
    private boolean isMagic;            // Whether the magic square is valid
    private boolean[] used;             // Whether each number has been used

    /**
     * Create a new MagicSquare object.
     */
    public MagicSquare() {
        square = new ArrayList<>();
        n = 0;
        sum = -1;
        isMagic = true;
    }

    /**
     * Convert the given file to a 2D array.
     *
     * @param file the path of the file
     * @throws IOException if an I/O error occurs
     */
    public void convert(String file) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Split the line into parts
                String[] rowParts = line.trim().split("\\s+");

                List<Integer> rowNums = new ArrayList<>();
                // convert each part to an integer
                for (String part : rowParts) {
                    int num = Integer.parseInt(part);
                    rowNums.add(num);
                }

                // add the row to the square
                square.add(rowNums);
            }

            // update the size of the magic square
            n =  square.size();
            sum = n * (n * n + 1) / 2;
            used = new boolean[n * n + 1];
        }
    }

    /**
     * Check if the magic square is valid(square shape and contain all numbers from 1 to n^2 once).
     *
     * @return true if the magic square is valid, false otherwise
     */
    public boolean validity() {
        for (int i = 0; i < n; i++) {
            // Check square shape
            if (n != square.get(i).size()) {
                isMagic = false;
                return false;
            }
            for (int j = 0; j < n; j++) {
                int num = square.get(i).get(j);
                // Check if the number is unique
                if (num < 1 || num > n * n || used[num]) {
                    isMagic = false;
                    return false;
                }
                used[num] = true;
            }
        }
        return true;
    }

    /**
     * Check if the magic square is valid(row sum, column sum, and diagonal sum are equal).
     */
    public void check() {
        if (!validity()) {
            return;
        }
        checkRowCol();
        checkDiagonal();
    }

    /**
     * Check if the magic square is valid(diagonal sum is equal).
     */
    private void checkDiagonal() {
        int diagSum1 = 0;
        int diagSum2 = 0;
        for (int i = 0; i < n; i++) {
            diagSum1 += square.get(i).get(i);
            diagSum2 += square.get(i).get(n - 1 - i);
        }
        if (sum != diagSum1 || sum != diagSum2) {
            isMagic = false;
        }
    }

    /**
     * Check if the magic square is valid(row sum, column sum, and diagonal sum are equal).
     */
    private void checkRowCol() {
        for (int i = 0; i < n; i++) {
            int rowSum = 0;
            int colSum = 0;
            for (int j = 0; j < n; j++) {
                rowSum += square.get(i).get(j);
                colSum += square.get(j).get(i);
            }
            if (sum != rowSum || sum != colSum) {
                isMagic = false;
                return;
            }
        }
    }

    /**
     * Test the MagicSquare class.
     */
    public static void main(String[] args) {
        // Store file name
        String path = "E:\\Dev\\WorkStudyPlace\\Courses\\IntroToJava\\StudyIntroToJava\\assignments\\assn07\\res\\";
        String[] files = {path + "Luna.txt", path + "Mercury.txt"};

        // Test each file
        for (String file : files) {
            try {
                MagicSquare ms = new MagicSquare();
                ms.convert(file);
                ms.check();
                System.out.println(file + " is " + (ms.isMagic ? "a Magic Square" : "Not a Magic Square"));
            } catch (IOException e) {
                System.out.println("Error processing file " + file);
            }
        }
    }
}
