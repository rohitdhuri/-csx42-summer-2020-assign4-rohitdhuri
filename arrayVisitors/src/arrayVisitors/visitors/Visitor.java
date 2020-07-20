package arrayVisitors.visitors;

import java.io.IOException;

import arrayVisitors.adt.MyArrayI;
import arrayVisitors.adt.MyArrayListI;

public interface Visitor {

    void visit(MyArrayI array);

    void visit(MyArrayListI arrayList);
}