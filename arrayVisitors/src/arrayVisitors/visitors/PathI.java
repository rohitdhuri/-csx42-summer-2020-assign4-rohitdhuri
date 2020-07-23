package arrayVisitors.visitors;

import java.io.IOException;

import arrayVisitors.util.exception.EmptyFileException;

/**
 * Interface to be cast to when set method needs to be used in the
 * PopulateMyArrayVisitor class
 * 
 * @author Rohit Mahendra Dhuri
 * 
 */
public interface PathI {

    /**
     * Sets the filepath required to instatiate the FileProcessor object
     * 
     * @param filepath
     * @throws IOException
     * @throws NumberFormatException
     * @throws EmptyFileException
     */
    public void set(String filepath) throws IOException, NumberFormatException, EmptyFileException;
}