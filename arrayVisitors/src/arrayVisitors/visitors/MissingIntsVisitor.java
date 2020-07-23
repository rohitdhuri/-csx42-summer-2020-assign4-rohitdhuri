package arrayVisitors.visitors;

import java.text.DecimalFormat;
import java.util.HashSet;
import java.util.Set;

import arrayVisitors.adt.MyArrayI;
import arrayVisitors.adt.MyArrayListI;
import arrayVisitors.util.MyLogger;
import arrayVisitors.util.Results;
import arrayVisitors.util.MyLogger.DebugLevel;

/**
 * Finds the missing integers and stores in Results
 * 
 * @author Rohit Mahendra Dhuri
 */
public class MissingIntsVisitor implements Visitor {
    private Boolean present;
    private Set<Integer> missingInts;
    private Results missingIntsResult;
    private int i;
    private MyLogger ml;

    /**
     * Constructor iniializes the data members
     * 
     * @param missingIntsResults
     */
    public MissingIntsVisitor(Results missingIntsResults) {
        ml = MyLogger.getInstance();
        ml.writeMessage("MissingIntsVisitor constructor", DebugLevel.CONSTRUCTOR);

        this.missingIntsResult = missingIntsResults;
        present = false;
        missingInts = new HashSet<Integer>();
        i = 1;

    }

    public void visit(MyArrayI array) {

        missingInts = new HashSet<Integer>();
        ml.writeMessage("Calculating MissingInts", DebugLevel.MISSING_INTS_VISITOR);

        for (Integer i = 0; i < 100; i++) {
            present = false;
            for (Integer n : array.getArray()) {
                if (i == n)
                    present = true;
            }
            if (!present) {
                missingInts.add(i);
            }

        }

        ml.writeMessage("Calling storeOutput()", DebugLevel.MISSING_INTS_VISITOR);
        missingIntsResult.storeOutput("Array " + (i++) + "\n");
        for (Integer n : missingInts)
            missingIntsResult.storeOutput(new DecimalFormat("00").format(n) + "\n");
        missingIntsResult.storeOutput("\n");

    }

    public void visit(MyArrayListI arrayList) {
    }

    @Override
    public String toString() {
        return "Class: MissingIntsVisitor, Data Members: [ missingInts= " + missingInts + " ]";
    }

}