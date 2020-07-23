package arrayVisitors.visitors;

import arrayVisitors.util.FileProcessor;
import arrayVisitors.util.MyLogger;
import arrayVisitors.util.MyLogger.DebugLevel;
import arrayVisitors.util.exception.EmptyFileException;
import arrayVisitors.util.exception.InvalidInputFormat;

import java.io.IOException;

import arrayVisitors.adt.MyArrayI;
import arrayVisitors.adt.MyArrayListI;

/**
 * Populates the MyArray element with integers from input
 * 
 * @author Rohit Mahendra Dhuri
 */
public class PopulateMyArrayVisitor implements Visitor, PathI {
    private FileProcessor fp;
    String num;
    private MyLogger ml = MyLogger.getInstance();

    public void set(String filepath) throws IOException, NumberFormatException, EmptyFileException {

        ml.writeMessage("PopulateMyArray constructor", DebugLevel.CONSTRUCTOR);
        fp = new FileProcessor(filepath);
        num = fp.poll();
        if (num == null)
            throw new EmptyFileException("Empty input file " + filepath);
    }

    public void visit(MyArrayI array) {

        while (num != null) {
            try {
                if (num.length() > 2)
                    throw new InvalidInputFormat("Invalid Input format");
                array.add(Integer.parseInt(num));
            } catch (InvalidInputFormat e) {
                System.out.println(e.getMessage());
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
            ml.writeMessage("Calling poll()", DebugLevel.POPULATE_MY_ARRAY_VISITOR);
            try {
                num = fp.poll();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public void visit(MyArrayListI arrayList) {
    }

    @Override
    public String toString() {
        return "Class: PopulateMyArrayVisitor, Data Members: [ num= " + num + " ]";
    }
}