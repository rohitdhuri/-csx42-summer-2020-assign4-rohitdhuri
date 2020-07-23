package arrayVisitors.adt;

import arrayVisitors.util.MyLogger;
import arrayVisitors.util.MyLogger.DebugLevel;
import arrayVisitors.visitors.Visitor;

/**
 * For maintaining an array of integers as an element
 * 
 * @author- Rohit Mahendra Dhuri
 */
public class MyArray implements MyArrayI {
    private Integer i;
    private Integer[] mArray;
    private MyLogger ml;

    /**
     * Constructor Initializes internal array
     * 
     * @param length - int value spexifying length, used to initalize the internal
     *               array of integers
     */
    public MyArray(int length) {
        ml = MyLogger.getInstance();
        ml.writeMessage("MyArray constructor", DebugLevel.CONSTRUCTOR);
        mArray = new Integer[length];
        i = 0;
    }

    /**
     * Adds an Intger into the array
     * 
     * @param num - Integer to be added
     */
    public void add(Integer num) {
        ml.writeMessage("Adding integer", DebugLevel.MY_ARRAY);

        try {
            mArray[i] = num;
            i++;
        } catch (ArrayIndexOutOfBoundsException e) {
            extendArray();
            mArray[i++] = num;
        }

    }

    /**
     * Accepts a visitor and by calling its visit method
     * 
     * @param v - object of Visitor interface
     */
    @Override
    public void accept(Visitor v) {
        ml.writeMessage("Calling accept", DebugLevel.MY_ARRAY);
        v.visit(this);
    }

    /**
     * Returns the internal array of Integers
     * 
     * @return - array of Integers
     */
    @Override
    public Integer[] getArray() {
        return mArray;
    }

    /**
     * Increases the internal array's capacity by 50%
     */
    private void extendArray() {
        ml.writeMessage("Increasing array capacity", DebugLevel.MY_ARRAY);
        Integer[] temp = mArray;
        int newLength = mArray.length + (mArray.length / 2);
        mArray = new Integer[newLength];
        for (int i = 0; i < temp.length; i++)
            mArray[i] = temp[i];
    }

    @Override
    public String toString() {
        return "Class: MyArray, Data Members: [mArray= " + mArray + " ]";
    }
}