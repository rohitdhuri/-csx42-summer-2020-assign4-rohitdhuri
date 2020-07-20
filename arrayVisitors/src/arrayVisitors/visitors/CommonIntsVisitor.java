package arrayVisitors.visitors;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import arrayVisitors.adt.MyArrayI;
import arrayVisitors.adt.MyArrayListI;

public class CommonIntsVisitor implements Visitor {

    public ArrayList<Integer[]> arrays;
    public Set<Integer> commonElements;

    public CommonIntsVisitor() {
        arrays = new ArrayList<Integer[]>();
        commonElements = new HashSet<Integer>();
    }

    public void visit(MyArrayI array) {

        arrays.add(array.getArray());


        if (arrays.size() > 1) {
            for (int i = 0; i < arrays.get(arrays.size()-2).length; i++) {
                for (int j = 0; j < arrays.get(arrays.size()-1).length; j++) {
                    if (arrays.get(arrays.size()-2)[i] == arrays.get(arrays.size()-1)[j])
                        if (arrays.get(arrays.size()-2)[i] != null)
                            commonElements.add(arrays.get(arrays.size()-2)[i]);
                }
            }
        }

        //System.out.println(commonElements);
    }

    public void visit(MyArrayListI arr_lst) {

        for (MyArrayI a : arr_lst.getList()) {
            a.accept(this);
        }

    }
}