package arrayVisitors.adt;

import arrayVisitors.util.MyLogger;
import arrayVisitors.util.MyLogger.DebugLevel;
import arrayVisitors.visitors.Visitor;

/**
 * For maintaining an array of MyArrayI objects as an element.
 * 
 * @author - Rohit Mahendra Dhuri
 * 
 */
public class MyArrayList implements MyArrayListI {

    private MyArrayI[] arrLst;
    private int i;
    private MyLogger ml;

    /**
     * Constructor initalizes the internal array
     * 
     * @param length - int value specifying the length of internal array
     */
    public MyArrayList(int length) {
        ml = MyLogger.getInstance();
        ml.writeMessage("MyArrayList constructor", DebugLevel.CONSTRUCTOR);
        arrLst = new MyArrayI[length];
        i = 0;
    }

    /**
     * Adds a MyArrayI object into the internal array
     * 
     * @param arr - object of type MyArrayI
     */
    @Override
    public void add(MyArrayI arr) {
        ml.writeMessage("Adding array", DebugLevel.MY_ARRAY_LIST);
        arrLst[i++] = arr;
    }

    /**
     * Accepts a visitor and by calling its visit method
     * 
     * @param v - object of Visitor interface
     */
    @Override
    public void accept(Visitor v) {
        ml.writeMessage("Calling accept", DebugLevel.MY_ARRAY_LIST);
        v.visit(this);
    }

    /**
     * Returns a the internal array of MyArrayI objects
     * 
     * @return - Array of MyArrayI objects
     */
    @Override
    public MyArrayI[] getList() {
        return arrLst;
    }

    @Override
    public String toString() {
        return "Class: MyArrayList, Data Members: [arrLst= " + arrLst + " ]";
    }
}