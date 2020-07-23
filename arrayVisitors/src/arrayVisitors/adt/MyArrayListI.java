package arrayVisitors.adt;

import arrayVisitors.visitors.Element;

/**
 * Interface to MyArrayList class
 * 
 * @author - Rohit Mahendra Dhuri
 */
public interface MyArrayListI extends Element {

    /**
     * Adds a MyArrayI object into the internal array
     * 
     * @param arr - object of type MyArrayI
     */
    void add(MyArrayI arr);

    /**
     * Returns a the internal array of MyArrayI objects
     * 
     * @return - Array of MyArrayI objects
     */
    MyArrayI[] getList();

}