package arrayVisitors.adt;

import arrayVisitors.visitors.Element;

/**
 * Interface to MyArray objects
 * 
 * @author - Rohit Mahendra Dhuri
 */
public interface MyArrayI extends Element {

    /**
     * Adds an Intger into the array
     * 
     * @param num - Integer to be added
     */
    void add(Integer num);

    /**
     * Returns the internal array of Integers
     * 
     * @return - array of Integers
     */
    Integer[] getArray();

}