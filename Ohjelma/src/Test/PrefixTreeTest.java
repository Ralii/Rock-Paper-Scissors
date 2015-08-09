package Test;

import dataStructures.Node;
import dataStructures.PrefixTree;
import dataStructures.Type;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PrefixTreeTest {
    PrefixTree tree;

    @Before
    public void setUp() throws Exception {
        this.tree = new PrefixTree(4);
    }

    @Test
    public void testInit() throws Exception {
        Node node = new Node(Type.PAPER);
        tree.init(4, node);
    }

    @Test
    public void testGetPattern() throws Exception {

    }

    @Test
    public void testIsEmpty() throws Exception {

    }
}