package Test;

import dataStructures.Node;
import dataStructures.Type;
import junit.framework.TestCase;
import org.junit.Test;

public class NodeTest extends TestCase {
    Node node;
    public void setUp() throws Exception {
        super.setUp();
        node = new Node(Type.PAPER);
    }

    @Test
    public void testonkoNolla(){
        assertEquals(0, node.ammount);
    }

    @Test
    public void testonkoHaaratNolla(){
        assertEquals(null, node.left);
        assertEquals(null, node.center);
        assertEquals(null, node.right);
    }
}