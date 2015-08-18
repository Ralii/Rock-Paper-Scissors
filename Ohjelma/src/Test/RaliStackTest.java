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
        assertEquals(Type.PAPER, stack.peek());
    }

    public void testPeekEmpty() throws Exception {
        RaliStack stack = new RaliStack();
        assertEquals(null, stack.peek());
    }

    public void testPop() throws Exception {
        RaliStack stack = new RaliStack();
        stack.insert(Type.PAPER);
        stack.insert(Type.PAPER);
        stack.insert(Type.PAPER);
        assertEquals(3, stack.size());

        stack.pop();
        assertEquals(2, stack.size());
    }

    public void testSize() throws Exception {
        RaliStack stack = new RaliStack();
        stack.insert(Type.PAPER);
        stack.insert(Type.PAPER);
        stack.insert(Type.PAPER);
        stack.insert(Type.PAPER);

        assertEquals(4, stack.size());
    }

    public void testOverSize() throws Exception {
        RaliStack stack = new RaliStack();
        stack.insert(Type.PAPER);
        stack.insert(Type.PAPER);
        stack.insert(Type.PAPER);
        stack.insert(Type.PAPER);
        assertEquals(4,stack.size());

        stack.insert(Type.PAPER);
        assertEquals(1,stack.size());
    }

}