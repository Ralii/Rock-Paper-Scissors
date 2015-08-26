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
        RaliTrie t = new RaliTrie(6);
        Type[] type = new Type[5];

        for(int i = 0 ; i < type.length ; i++) {
            type[i] = Type.PAPER;
        }
        Type n = t.getEstimate(type);
        System.out.println(n);
    }

    public void testAddAndGet() throws Exception {
        RaliTrie t = new RaliTrie(6);
        Type[] type = new Type[5];

        for(int i = 0 ; i < type.length ; i ++) {
            type[i] = Type.PAPER;
        }

        t.add(type);
        t.add(type);
        t.add(type);

        assertEquals(Type.SCISSORS, t.getEstimate(type));
    }

}