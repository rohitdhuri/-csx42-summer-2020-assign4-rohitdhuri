package arrayVisitors.visitors;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import arrayVisitors.adt.MyArrayI;
import arrayVisitors.adt.MyArrayListI;
import arrayVisitors.util.Results;

public class MissingIntsVisitor implements Visitor {
    private Boolean present;
    private Set<Integer> missingInts;
    private Results missingIntsResult;
    private int i;

    public MissingIntsVisitor(Results missingIntsResults) {
        this.missingIntsResult = missingIntsResults;
        present = false;
        missingInts = new HashSet<Integer>();
        i=1;

    }

    public void visit(MyArrayI array) {


      //  if (arrays.size() > 0) {
            missingInts = new HashSet<Integer>();
/*
            for (Integer[] a : arrays)
                for (Integer n : a)
                    if (n != null)
                        union.add(n);*/

            for (Integer i = 0; i < 100; i++) {
                present = false;
                for (Integer n : array.getArray()) {
                    if (i == n)
                        present = true;
                }
                if (present == false) {
                    missingInts.add(i);
                }
            
        }

        missingIntsResult.storeOutput("Array "+(i++) + "\n");
        for(Integer n: missingInts)
        missingIntsResult.storeOutput(new DecimalFormat("00").format(n)+"\n");
        missingIntsResult.storeOutput("\n");
        /*
         * if (arrays.size() > 1) { System.out.println(missingInts);
         * System.out.println(union); }
         */

    }

    public void visit(MyArrayListI arrayList) {
    }

}