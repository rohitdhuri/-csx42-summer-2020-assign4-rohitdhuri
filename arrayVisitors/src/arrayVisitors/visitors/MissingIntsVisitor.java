package arrayVisitors.visitors;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import arrayVisitors.adt.MyArrayI;
import arrayVisitors.adt.MyArrayListI;

public class MissingIntsVisitor implements Visitor {
    private Boolean present;
    private ArrayList<Integer[]> arrays;
    private Set<Integer> missingInts;
    private Set<Integer> union;

    public MissingIntsVisitor() {
        present = false;
        missingInts = new HashSet<Integer>();
        union = new HashSet<Integer>();
        arrays = new ArrayList<Integer[]>();

    }

    public void visit(MyArrayI array) {

        arrays.add(array.getArray());

        if (arrays.size() > 0) {
            missingInts = new HashSet<Integer>();

            for (Integer[] a : arrays)
                for (Integer n : a)
                    if (n != null)
                        union.add(n);

            for (Integer i = 0; i <= 100; i++) {
                present = false;
                for (Integer n : union) {
                    if (i == n)
                        present = true;
                }
                if (present == false) {
                    missingInts.add(i);
                }
            }
        }
        /*
         * if (arrays.size() > 1) { System.out.println(missingInts);
         * System.out.println(union); }
         */

    }

    public void visit(MyArrayListI arrayList) {
    }

}