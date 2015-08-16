package Test;

import dataStructures.RaliStack;
import dataStructures.Type;
import junit.framework.TestCase;

public class RaliStackTest extends TestCase {

    public void setUp() throws Exception {
        super.setUp();
    }

    public void testInsert() throws Exception {
        RaliStack stack = new RaliStack();
        stack.insert(Type.PAPER);
    }
    public void testPeek() throws Exception {
        RaliStack stack = new RaliStack();
        stack.insert(Type.PAPER);
        for(int x = 0 ; x < stack.arr.length -1 ; x++){
            System.out.println(stack.arr[x]);
        }
    }

}