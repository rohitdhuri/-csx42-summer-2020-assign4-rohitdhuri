package arrayVisitors.driver;

import java.util.ArrayList;

import arrayVisitors.adt.MyArray;
import arrayVisitors.adt.MyArrayI;
import arrayVisitors.adt.MyArrayList;
import arrayVisitors.adt.MyArrayListI;
import arrayVisitors.util.FileDisplayInterface;
import arrayVisitors.util.Results;
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
        
            ArrayList<String> filePaths = new ArrayList<String>();
            filePaths.add(args[0]);
            filePaths.add(args[1]);

            ArrayList<MyArrayI> myArrayObjs = new ArrayList<MyArrayI>();
            Visitor populateMyArrayVisiitorObj = new PopulateMyArrayVisitor();

            for(String path : filePaths){
                ((PathI) populateMyArrayVisiitorObj).set(path);
                myArrayObjs.add(new MyArray(length));
                myArrayObjs.get(myArrayObjs.size()-1).accept(populateMyArrayVisiitorObj);
            }

        

        /*MyArrayI arr_1 = new MyArray(length);
        MyArrayI arr_2 = new MyArray(length);

        Visitor populateMyArrayVisiitorObj = new PopulateMyArrayVisitor();
        ((PathI) populateMyArrayVisiitorObj).set(args[0]);
        arr_1.accept(populateMyArrayVisiitorObj);

        ((PathI) populateMyArrayVisiitorObj).set(args[1]);
        arr_2.accept(populateMyArrayVisiitorObj);*/

        MyArrayListI arr_lst = new MyArrayList(2);

        for(MyArrayI mArray : myArrayObjs)
            arr_lst.add(mArray);
        

        /*arr_lst.add(arr_1);
        arr_lst.add(arr_2);*/

        Results commonIntsResult = new Results(args[2]);
        CommonIntsVisitor commonIntsVisitorO = new CommonIntsVisitor(commonIntsResult);
        arr_lst.accept(commonIntsVisitorO);
        FileDisplayInterface commonInts_fdi = commonIntsResult;
        commonInts_fdi.writeToFile();

        Results missingIntsResult = new Results(args[3]);
        MissingIntsVisitor missingIntsVisitorO = new MissingIntsVisitor(missingIntsResult);

        for(MyArrayI mArray : myArrayObjs)
            mArray.accept(missingIntsVisitorO);

        /*arr_1.accept(missingIntsVisitorO);
        arr_2.accept(missingIntsVisitorO);*/
        // arr_lst.print();
        FileDisplayInterface missingInts_fdi = missingIntsResult;
        missingInts_fdi.writeToFile();

        for(Integer k : myArrayObjs.get(0).getArray())
        System.out.println(k);

    }
}