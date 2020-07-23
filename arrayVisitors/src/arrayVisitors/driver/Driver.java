package arrayVisitors.driver;

import java.util.ArrayList;

import arrayVisitors.adt.MyArray;
import arrayVisitors.adt.MyArrayI;
import arrayVisitors.adt.MyArrayList;
import arrayVisitors.adt.MyArrayListI;
import arrayVisitors.util.FileDisplayInterface;
import arrayVisitors.util.MyLogger;
import arrayVisitors.util.Results;
import arrayVisitors.util.exception.EmptyFileException;
import arrayVisitors.util.exception.SamePathAndNameException;
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
        MyLogger ml = MyLogger.getInstance();
        ml.setDebugValue(Integer.parseInt(args[4]));
        ml.writeMessage("Setting debug level " + args[4], MyLogger.DebugLevel.DRIVER);

        try {
            if (args[0].equals(args[1]))
                throw new SamePathAndNameException("Same path or name for input file");

            if (args[2].equals(args[3]))
                throw new SamePathAndNameException("Same path or name for output file");

            ml.writeMessage("Adding filepaths to arraylist", MyLogger.DebugLevel.DRIVER);
            ArrayList<String> filePaths = new ArrayList<String>();
            filePaths.add(args[0]);
            filePaths.add(args[1]);

            ArrayList<MyArrayI> myArrayObjs = new ArrayList<MyArrayI>();
            Visitor populateMyArrayVisiitorObj = new PopulateMyArrayVisitor();

            for (String path : filePaths) {
                ml.writeMessage("Calling set() for populateMyArrayVisitor", MyLogger.DebugLevel.DRIVER);
                ((PathI) populateMyArrayVisiitorObj).set(path);
                ml.writeMessage("Adding new MyArray object to arraylist", MyLogger.DebugLevel.DRIVER);
                myArrayObjs.add(new MyArray(length));
                ml.writeMessage("Calling accept", MyLogger.DebugLevel.DRIVER);
                myArrayObjs.get(myArrayObjs.size() - 1).accept(populateMyArrayVisiitorObj);
            }

            MyArrayListI arr_lst = new MyArrayList(myArrayObjs.size());

            for (MyArrayI mArray : myArrayObjs) {
                ml.writeMessage("Calling add() in MyArrayListI", MyLogger.DebugLevel.DRIVER);
                arr_lst.add(mArray);
            }

            Results commonIntsResult = new Results(args[2]);
            CommonIntsVisitor commonIntsVisitorO = new CommonIntsVisitor(commonIntsResult);
            ml.writeMessage("Calling accept() in MyArrayListI", MyLogger.DebugLevel.DRIVER);
            arr_lst.accept(commonIntsVisitorO);
            FileDisplayInterface commonInts_fdi = commonIntsResult;
            ml.writeMessage("Calling WriteToFile()", MyLogger.DebugLevel.DRIVER);
            commonInts_fdi.writeToFile();

            Results missingIntsResult = new Results(args[3]);
            MissingIntsVisitor missingIntsVisitorO = new MissingIntsVisitor(missingIntsResult);

            for (MyArrayI mArray : myArrayObjs) {
                ml.writeMessage("Calling accept() for MyArrayI", MyLogger.DebugLevel.DRIVER);
                mArray.accept(missingIntsVisitorO);
            }

            FileDisplayInterface missingInts_fdi = missingIntsResult;
            ml.writeMessage("Calling writeToFile()", MyLogger.DebugLevel.DRIVER);
            missingInts_fdi.writeToFile();

        } catch (EmptyFileException | SamePathAndNameException e) {
            System.err.println(e.getMessage());
        }
    }
}