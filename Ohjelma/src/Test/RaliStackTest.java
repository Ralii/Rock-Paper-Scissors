package Test;

import dataStructures.RaliStack;
import dataStructures.Type;
import junit.framework.TestCase;

// Fiksaile testiä
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
        assertEquals(Type.PAPER, stack.peek());
    }

    public void testPop() throws Exception {
        stack.pop();
    }
}