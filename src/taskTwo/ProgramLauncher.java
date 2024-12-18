package taskTwo;

import taskTwo.model.ApplicationLogic;
import java.io.IOException;

public class ProgramLauncher {
    public static void main(String[] args) throws IOException {
        String inputFileName = "src/taskTwo/inputData/input.txt"; // Input file name
        String outputFileName = "src/taskTwo/outputData/output.txt"; // Output file name
        ApplicationLogic app = new ApplicationLogic(); // Create an instance of the application class
        app.runApp(inputFileName, outputFileName); // Run the application
    }
}