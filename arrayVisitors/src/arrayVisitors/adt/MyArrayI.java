package arrayVisitors.adt;

import arrayVisitors.visitors.Element;
import arrayVisitors.visitors.Visitor;

public interface MyArrayI extends Element {

     
   // void accept(Visitor v);

    void add(Integer num);

    Integer[] getArray();


}