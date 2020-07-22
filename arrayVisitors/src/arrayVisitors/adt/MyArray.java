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
        try {
            mArray[i] = num;
            i++;
        } catch (ArrayIndexOutOfBoundsException e) {
            extendArray();
            mArray[i++] = num;
        }

    }

    public void accept(Visitor v) {
        v.visit(this);
    }

    @Override
    public Integer[] getArray() {
        return mArray;
    }

    private void extendArray() {
        Integer[] temp = mArray;
        int newLength = mArray.length + (mArray.length / 2);
        mArray = new Integer[newLength];
        for (int i = 0; i < temp.length; i++)
            mArray[i] = temp[i];
    }
}