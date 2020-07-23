package arrayVisitors.util;

public class MyLogger {
    /** Enums for specifying debugLevel */
    public enum DebugLevel {
        CONSTRUCTOR, FILE_PROCESSOR, DRIVER, MY_ARRAY, MY_ARRAY_LIST, COMMON_INTS_VISITOR, MISSING_INTS_VISITOR,
        POPULATE_MY_ARRAY_VISITOR, NONE
    };

    private DebugLevel debugLevel;
    private static MyLogger uniqueInstance = null;

    public static MyLogger getInstance() {

        if (uniqueInstance == null)
            uniqueInstance = new MyLogger();

        return uniqueInstance;
    }

    private MyLogger() {
    }

    public void setDebugValue(int levelIn) {
        switch (levelIn) {

            case 8:
                debugLevel = DebugLevel.POPULATE_MY_ARRAY_VISITOR;
                break;
            case 7:
                debugLevel = DebugLevel.MISSING_INTS_VISITOR;
                break;
            case 6:
                debugLevel = DebugLevel.COMMON_INTS_VISITOR;
                break;
            case 5:
                debugLevel = DebugLevel.MY_ARRAY_LIST;
                break;
            case 4:
                debugLevel = DebugLevel.MY_ARRAY;
                break;
            case 3:
                debugLevel = DebugLevel.DRIVER;
                break;
            case 2:
                debugLevel = DebugLevel.CONSTRUCTOR;
                break;
            case 1:
                debugLevel = DebugLevel.FILE_PROCESSOR;
                break;
            default:
                debugLevel = DebugLevel.NONE;
                break;
        }
    }

    public void setDebugValue(DebugLevel levelIn) {
        debugLevel = levelIn;
    }

    public void writeMessage(String message, DebugLevel levelIn) {
        if (levelIn == debugLevel)
            System.out.println(message);
    }

    public String toString() {
        return "The debug level has been set to the following " + debugLevel;
    }
}