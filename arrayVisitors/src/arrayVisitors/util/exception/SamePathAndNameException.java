package arrayVisitors.util.exception;

public class SamePathAndNameException extends Exception{
    
    /**
     * SamePathAndNameException class
     * 
     * @author Rohit Mahendra Dhuri
     * 
     */    

        /**
         * SamePathAndNameException constructor calling the parent class
         * object
         * 
         * @param s - The error message
         */

        public SamePathAndNameException(String s){
            super(s);
        }


        @Override
        public String toString() {
            return "Class: SamePathAndNameException, Data Members: [ ]";
        }


}