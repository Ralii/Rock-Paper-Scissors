package Test;

import dataStructures.Node;
import dataStructures.PrefixTree;
import dataStructures.RaliStack;
import dataStructures.Type;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import java.util.Stack;

import static org.junit.Assert.*;

public class PrefixTreeTest extends TestCase {
    PrefixTree tree;
    RaliStack stack;

    @Before
    public void setUp() throws Exception {
        super.setUp();
        this.tree = new PrefixTree(4);
        this.stack = new RaliStack();
        Node node = new Node(Type.PAPER);
        tree.init(4,node);
    }

    @Test
    public void testInit() throws Exception {
        Node node = new Node(Type.PAPER);
        tree.init(4, node);
    }

    @Test
    public void addPattern() throws Exception {
        tree.addPattern(stack);
    }

    @Test
    public void testGetPattern() throws Exception {
        RaliStack stak = new RaliStack();
        stak.insert(Type.PAPER);
        Thread.sleep(500);
        System.out.println(stak.peek());

    }

    @Test
    public void testIsEmpty() throws Exception {

    }
}