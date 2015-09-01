package dataStructures;

import exeption.ListFullExeption;
import junit.framework.TestCase;

public class FixedNodeListTest extends TestCase {

    public void testAddAndGetValue() throws Exception {
        FixedNodeList l = new FixedNodeList(5);
        l.add(new RaliTrieNode(Type.PAPER));
        l.add(new RaliTrieNode(Type.ROCK));
        l.add(new RaliTrieNode(Type.SCISSORS));

        assertEquals(Type.PAPER, l.get(0).getValue());
        assertEquals(Type.ROCK, l.get(1).getValue());
        assertEquals(Type.SCISSORS, l.get(2).getValue());
    }

    public void testLength() throws Exception {
        FixedNodeList l = new FixedNodeList(5);
        l.add(new RaliTrieNode(Type.PAPER));
        l.add(new RaliTrieNode(Type.PAPER));
        l.add(new RaliTrieNode(Type.PAPER));

        assertEquals(3, l.length());
    }

    public void testFull() throws Exception {
        try {
            FixedNodeList l = new FixedNodeList(2);
            l.add(new RaliTrieNode(Type.PAPER));
            l.add(new RaliTrieNode(Type.PAPER));
            l.add(new RaliTrieNode(Type.PAPER));
        } catch(ListFullExeption e) {

        }
    }
}