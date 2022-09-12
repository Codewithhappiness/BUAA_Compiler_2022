import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class IO {
    public static InputHandler input() throws IOException {
        InputHandler inputHandler = new InputHandler();
        File file = new File(Config.inputFile);
        if (!file.exists()) {
            System.out.println("input file not exists");
            return inputHandler;
        }
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        while ((line = reader.readLine()) != null)
            inputHandler.add(line);
        return inputHandler;
    }

    public static void output(String string) throws IOException {
        if (Config.outputFile.equals("")) {
            System.out.println("output file not exists");
            System.out.println();
        }
        File file = new File(Config.outputFile);
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        writer.write(string);
        writer.close();
    }
}
