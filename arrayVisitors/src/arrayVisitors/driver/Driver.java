package arrayVisitors.driver;

import arrayVisitors.adt.MyArray;
import arrayVisitors.adt.MyArrayI;
import arrayVisitors.adt.MyArrayList;
import arrayVisitors.adt.MyArrayListI;
import arrayVisitors.visitors.CommonIntsVisitor;
import arrayVisitors.visitors.MissingIntsVisitor;
import arrayVisitors.visitors.PathI;
import arrayVisitors.visitors.PopulateMyArrayVisitor;
import arrayVisitors.visitors.Visitor;

public class Driver {
    private static final int REQUIRED_NUMBER_OF_CMDLINE_ARGS = 5;

    public static void main(String[] args) throws Exception {

        /*
         * As the build.xml specifies the arguments as input,output or metrics, in case
         * the argument value is not given java takes the default value specified in
         * build.xml.
         */
        if ((args.length != 5) || (args[0].equals("${input1}")) || (args[1].equals("${input2}"))
                || (args[2].equals("${commonintsout}")) || (args[3].equals("${missingintsout}"))
                || (args[4].equals("${debug}"))) {
            System.err.printf("Error: Incorrect number of arguments. Program accepts %d arguments.",
                    REQUIRED_NUMBER_OF_CMDLINE_ARGS);
            System.exit(0);
        }

        int length = 10;

        MyArrayI arr_1 = new MyArray(length);
        MyArrayI arr_2 = new MyArray(length);

        Visitor populateMyArrayVisiitorO = new PopulateMyArrayVisitor();
        ((PathI) populateMyArrayVisiitorO).set(args[0]);
        arr_1.accept(populateMyArrayVisiitorO);

        ((PathI) populateMyArrayVisiitorO).set(args[1]);
        arr_2.accept(populateMyArrayVisiitorO);

        MyArrayListI arr_lst = new MyArrayList(2);
        arr_lst.add(arr_1);
        arr_lst.add(arr_2);
        
        CommonIntsVisitor commonIntsVisitorO = new CommonIntsVisitor();

        arr_lst.accept(commonIntsVisitorO);

        MissingIntsVisitor missingIntsVisitorO = new MissingIntsVisitor();

        arr_1.accept(missingIntsVisitorO);
        arr_2.accept(missingIntsVisitorO);
        //arr_lst.print();

        

    }
}