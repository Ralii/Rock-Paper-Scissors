package Test;

import dataStructures.RaliStack;
import dataStructures.Type;
import junit.framework.TestCase;

public class RaliStackTest extends TestCase {
    RaliStack stack;

    public void setUp() throws Exception {
        super.setUp();
        this.stack = new RaliStack();
    }

    public void testInsert() throws Exception {
        stack.insert(Type.PAPER);
    }
    public void testPeek() throws Exception {
        stack.insert(Type.PAPER);
        System.out.println(stack.peek());
        assertEquals(Type.PAPER, stack.peek());
        stack.insert(Type.ROCK);
        assertEquals(Type.ROCK, stack.peek());
    }
    public void testPop() throws Exception {
        stack.insert(Type.PAPER);
        assertEquals(Type.PAPER, stack.pop());
    }
}