import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Demonstrate Reading/Writing data rererin files
 */
public class FileDemo {


    // update data

    /**
     * Read double values from the file specified. Ignore any lines that contain
     * non-double data.
     * 
     * @param filename The filename
     * @return The data read from the file, minus any lines that contain non-double
     *         data values
     * @throws FileNotFoundException
     */
    public static String[] readData(String filename) throws FileNotFoundException {
        ArrayList<String> data = new ArrayList<>();

        try (Scanner file = new Scanner(new FileReader(filename))) {
            while (file.hasNext()) {
                try {
                    String d = file.nextLine();
                    data.add(d);
                } catch (InputMismatchException exception) {
                    file.nextLine();
                }
            }
        }

        return data.toArray(new String[] {});
    }

    public static String[] readDataPlayer(String filename, String id) throws FileNotFoundException {
        ArrayList<String> data = new ArrayList<>();

        try (Scanner file = new Scanner(new FileReader(filename))) {
            while (file.hasNext()) {
                try {
                    String d = file.nextLine();
                    String idTo = "ID: 54";
                    if (id == idTo) {
                        data.add(d);
                    }

                } catch (InputMismatchException exception) {
                    file.nextLine();
                }
            }
        }

        return data.toArray(new String[] {});
    }

}