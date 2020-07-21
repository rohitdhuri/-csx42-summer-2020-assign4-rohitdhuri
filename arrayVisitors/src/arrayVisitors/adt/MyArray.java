package arrayVisitors.adt;

import arrayVisitors.visitors.Visitor;

public class MyArray implements MyArrayI {
    private Integer i;
    private Integer[] mArray;

    public MyArray(int length) {
        mArray = new Integer[length];
        i = 0;
    }

    public void add(Integer num) {
        mArray[i++] = num;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }


    @Override
    public Integer[] getArray() {
        return mArray;
    }
}