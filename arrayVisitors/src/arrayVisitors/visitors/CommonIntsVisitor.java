package arrayVisitors.visitors;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import arrayVisitors.adt.MyArrayI;
import arrayVisitors.adt.MyArrayListI;
import arrayVisitors.util.MyLogger;
import arrayVisitors.util.Results;
import arrayVisitors.util.MyLogger.DebugLevel;

/**
 * Finds the common Integers in the visited elements
 * 
 * @author Rohit Mahendra Dhuri
 */
public class CommonIntsVisitor implements Visitor {

    public ArrayList<Integer[]> arrays;
    public Set<Integer> commonElements;
    private Results commonIntsResult;
    private MyLogger ml;

    /**
     * Initializes data members
     * 
     * @param commonIntsResult Object of Result class
     */
    public CommonIntsVisitor(Results commonIntsResult) {
        ml = MyLogger.getInstance();
        ml.writeMessage("CommonIntsVisitor constructor", DebugLevel.COMMON_INTS_VISITOR);
        this.commonIntsResult = commonIntsResult;
        arrays = new ArrayList<Integer[]>();
    }

    public void visit(MyArrayI array) {
        commonElements = new HashSet<Integer>();
        arrays.add(array.getArray());
        ml.writeMessage("Calculating commonInts", DebugLevel.COMMON_INTS_VISITOR);

        if (arrays.size() > 1) {
            for (int i = 0; i < arrays.get(arrays.size() - 2).length; i++) {
                for (int j = 0; j < arrays.get(arrays.size() - 1).length; j++) {
                    if (arrays.get(arrays.size() - 2)[i] == arrays.get(arrays.size() - 1)[j])
                        if (arrays.get(arrays.size() - 2)[i] != null)
                            commonElements.add(arrays.get(arrays.size() - 2)[i]);
                }
            }
        }

        ml.writeMessage("Calling storeOutput()", DebugLevel.COMMON_INTS_VISITOR);
        for (Integer n : commonElements)
            commonIntsResult.storeOutput(n + "\n");
    }

    /**
     * Visits all the objects in Element array
     * 
     * @param arr_lst An array of MyArrayI objects
     */
    public void visit(MyArrayListI arr_lst) {

        for (MyArrayI a : arr_lst.getList()) {
            a.accept(this);
        }
    }

    @Override
    public String toString() {
        return "Class: CommonIntsVisitor, Data Members: [ commonELements= " + commonElements + " ]";
    }
}