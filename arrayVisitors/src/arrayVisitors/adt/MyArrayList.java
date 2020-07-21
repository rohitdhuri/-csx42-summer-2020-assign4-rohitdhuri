package arrayVisitors.adt;

import arrayVisitors.visitors.Visitor;

public class MyArrayList implements MyArrayListI {

    private MyArrayI[] arrLst;
    private int i;

    public MyArrayList(int length) {
        arrLst = new MyArrayI[length];
        i = 0;
    }

    public void add(MyArrayI arr) {
        arrLst[i++] = arr;
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }

    @Override
    public MyArrayI[] getList() {
        return arrLst;
    }


    

}