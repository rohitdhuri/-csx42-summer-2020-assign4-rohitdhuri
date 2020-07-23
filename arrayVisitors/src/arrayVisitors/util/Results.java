package arrayVisitors.util;

import java.io.FileWriter;
import java.io.IOException;

import arrayVisitors.util.MyLogger.DebugLevel;

/**
 * Results class - Implements the methods in StdoutDisplayInterface and
 * FileDsiplayInterface to print the output on console and in the file
 * respectively.
 * 
 * @author - Rohit Mahendra Dhuri
 * 
 */

public class Results implements FileDisplayInterface, StdoutDisplayInterface {
    private String output;
    private String filePath;
    private MyLogger ml;

    /**
     * constructor has the file path as its parameter, which it stores into a local
     * variable
     */

    public Results(String path) {
        ml = MyLogger.getInstance();
        ml.writeMessage("Results parameterized constructor", DebugLevel.CONSTRUCTOR);
        filePath = path;
        output = "";
    }

    /**
     * storeOutput method stores the output buffer into the local variable
     */
    
    public void storeOutput(String output) {
        this.output += output;
    }

    /**
     * Implemented writeToStdout method writes to the console
     */
    @Override
    public void writeToStdout() {
        System.out.println(output);

    }

    /**
     * Implemented writeToFile method writes to the file
     */
    @Override
    public void writeToFile() {
        try {
            FileWriter outputFile = new FileWriter(filePath);
            outputFile.write(output);
            outputFile.close();
            System.out.println("Successfully wrote to file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
        }
    }

    @Override
    public String toString() {
        return "output= " + output + " filePath= " + filePath;
    }

}