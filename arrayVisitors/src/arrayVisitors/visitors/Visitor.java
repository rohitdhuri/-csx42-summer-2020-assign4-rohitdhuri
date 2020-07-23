package arrayVisitors.visitors;

import arrayVisitors.adt.MyArrayI;
import arrayVisitors.adt.MyArrayListI;

/**
 * Defines all core visitor methods
 * 
 * @author Rohit Mahendra Dhuri
 */
public interface Visitor {

    /**
     * Operates on the element
     * 
     * @param array - Element to visit
     */
    void visit(MyArrayI array);

    /**
     * Operates on the element
     * 
     * @param arrayList - Element to visit
     */
    void visit(MyArrayListI arrayList);
}