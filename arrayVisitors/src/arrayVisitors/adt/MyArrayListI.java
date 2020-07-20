package arrayVisitors.adt;

import arrayVisitors.visitors.Element;
import arrayVisitors.visitors.Visitor;

public interface MyArrayListI extends Element {

    void add(MyArrayI arr);

    MyArrayI[] getList();

    void print();

    void accept(Visitor v);

}