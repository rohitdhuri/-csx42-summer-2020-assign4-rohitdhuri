package arrayVisitors.visitors;

import arrayVisitors.util.FileProcessor;

import java.io.IOException;

import arrayVisitors.adt.MyArrayI;
import arrayVisitors.adt.MyArrayListI;

public class PopulateMyArrayVisitor implements Visitor, PathI {
    private FileProcessor fp;
    String num;

    public void set(String filepath) throws IOException, NumberFormatException {
        fp = new FileProcessor(filepath);
        num = fp.poll();
    }

    public void visit(MyArrayI array) {
        
        try{
        while (num != null) {
            
            array.add(Integer.parseInt(num));
            num = fp.poll();
        }}catch(NumberFormatException | IOException e){
            e.printStackTrace();
        }
    }

    public void visit(MyArrayListI arrayList) {
    }
}