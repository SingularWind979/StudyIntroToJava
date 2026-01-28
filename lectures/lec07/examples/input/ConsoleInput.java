package input;

import java.io.*;
import java.util.Scanner;

/**
 * Class to read input from console.
 *
 * @author SingularWind
 */
public class ConsoleInput {
    public static void streamInput() {
        try (InputStream is = System.in;
             Reader r = new InputStreamReader(is);
             BufferedReader br = new BufferedReader(r)) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void scannerInput() {
        try (InputStream is = System.in;
             Scanner sc = new Scanner(is)) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) throws IOException {
        streamInput();
        scannerInput();
    }
}
