package arrayVisitors.visitors;

/**
 * Defines core element methods
 * 
 * @author - Rohit Mahendra Dhuri
 */
public interface Element {

    /**
     * Accepts a visitor and by calling its visit method
     * 
     * @param v - object of Visitor interface
     */
    void accept(Visitor v);

}