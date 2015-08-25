package Test;

import dataStructures.ShiftingTypeList;
import dataStructures.Type;
import dataStructures.RaliTrie;
import junit.framework.TestCase;

public class RaliTrieTest extends TestCase {

    public void testCreate() throws Exception {
        RaliTrie t = new RaliTrie(5);
    }

    public void testAdd() throws Exception {
        RaliTrie t = new RaliTrie(5);
        Type[] type = new Type[4];
        for(int i = 0 ; i < type.length ; i++) {
            type[i] = Type.PAPER;
        }
        t.add(type);
    }

    public void testGet() throws Exception {
        RaliTrie t = new RaliTrie(5);
        Type[] type = new Type[4];

        for(int i = 0 ; i < type.length ; i++) {
            type[i] = Type.PAPER;
        }
        Type n = t.getEstimate(type);
    }

    public void testAddAndGet() throws Exception {
        RaliTrie t = new RaliTrie(5);
        Type[] type = new Type[4];

        for(int i = 0 ; i < type.length ; i ++) {
            type[i] = Type.PAPER;
        }

        t.add(type);

        Type n = t.getEstimate(type);

        System.out.println(n.toString());
    }

    public void testMultipleAddGet() throws Exception {
        RaliTrie trie = new RaliTrie(6);
        ShiftingTypeList list = new ShiftingTypeList(5);

        for(int i = 0 ; i < 5 ; i++) {
            list.add(Type.PAPER);
            list.add(Type.PAPER);
            list.add(Type.PAPER);
            list.add(Type.PAPER);

            trie.add(list.toTypeList());

            Type t = trie.getEstimate(list.toTypeList());
            System.out.println(t);
        }

    }
}