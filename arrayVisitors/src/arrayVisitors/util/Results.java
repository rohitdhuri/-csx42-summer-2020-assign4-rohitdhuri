package arrayVisitors.util;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * Results class - Implements the methods in StdoutDisplayInterface and
 * FileDsiplayInterface to print the output on console and in the file
 * respectively.
 * 
 * @author - Rohit Mahendra Dhuri
 * 
 */

public class Results implements FileDisplayInterface, StdoutDisplayInterface {
    private Set<Integer> output;
    private String filePath;

    /**
     * constructor has the file path as its parameter, which it stores into a local
     * variable
     */

    public Results(String path) {
      //  MyLogger.writeMessage("Results parameterized constructor", MyLogger.DebugLevel.CONSTRUCTOR);
        filePath = path;
        output = new HashSet<Integer>();
    }

    /**
     * storeOutput method stores the output buffer into the local variable
     */

    public void storeOutput(Set<Integer> output) {
        System.out.println(output);
        this.output = output;
    }

    /**
     * Implemented writeToStdout method writes to the console
     */

    public void writeToStdout() {
        System.out.println(output);

    }

    /**
     * Implemented writeToFile method writes to the file
     */

    public void writeToFile() {
        try {
            FileWriter outputFile = new FileWriter(filePath);
            for(Integer i : output)
            outputFile.write(i+"\n");
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