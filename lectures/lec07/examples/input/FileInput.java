package input;

import java.io.*;

/**
 * Class to read input from a file.
 *
 * @author SingularWind
 */
public class FileInput {
    public static void streamInput() {
        try (FileInputStream fis = new FileInputStream("lectures/lec07/examples/input/input.txt");
            Reader r = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(r)) {
            String line;
            line = br.readLine();
            while (line != null) {
                System.out.println(line);
                line = br.readLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void readerInput() {
        try (
             FileReader fr = new FileReader("lectures/lec07/examples/input/input.txt");
             BufferedReader br = new BufferedReader(fr)) {
            String line;
            line = br.readLine();
            while (line != null) {
                System.out.println(line);
                line = br.readLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        streamInput();
        readerInput();
    }
}
