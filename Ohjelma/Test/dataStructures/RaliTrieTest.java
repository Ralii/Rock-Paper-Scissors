package dataStructures;

import dataStructures.ShiftingTypeList;
import dataStructures.Type;
import dataStructures.RaliTrie;
import junit.framework.TestCase;

public class RaliTrieTest extends TestCase {

    public void testCreate() throws Exception {
        RaliTrie t = new RaliTrie(5);
    }

    public void testAddPaper() throws Exception {
        RaliTrie t = new RaliTrie(6);
        Type[] type = new Type[5];
        for(int i = 0 ; i < type.length ; i++) {
            type[i] = Type.PAPER;
        }
        t.add(type);
    }

    public void testAddPRock() throws Exception {
        RaliTrie t = new RaliTrie(6);
        Type[] type = new Type[5];
        for(int i = 0 ; i < type.length ; i++) {
            type[i] = Type.ROCK;
        }
        t.add(type);
    }

    public void testAddScissors() throws Exception {
        RaliTrie t = new RaliTrie(6);
        Type[] type = new Type[5];
        for(int i = 0 ; i < type.length ; i++) {
            type[i] = Type.SCISSORS;
        }
        t.add(type);
    }

    public void testGetPaper() throws Exception {
        RaliTrie t = new RaliTrie(6);
        Type[] type = new Type[5];

        for(int i = 0 ; i < type.length ; i++) {
            type[i] = Type.PAPER;
        }
        Type n = t.getEstimate(type);
        System.out.println(n);
    }
    public void testGetRock() throws Exception {
        RaliTrie t = new RaliTrie(6);
        Type[] type = new Type[5];

        for(int i = 0 ; i < type.length ; i++) {
            type[i] = Type.ROCK;
        }
        Type n = t.getEstimate(type);
        System.out.println(n);
    }
    public void testGetScissors() throws Exception {
        RaliTrie t = new RaliTrie(6);
        Type[] type = new Type[5];

        for(int i = 0 ; i < type.length ; i++) {
            type[i] = Type.SCISSORS;
        }
        Type n = t.getEstimate(type);
        System.out.println(n);
    }

    public void testAddAndGetScissors() throws Exception {
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

    public void testAddAndGetRock() throws Exception {
        RaliTrie t = new RaliTrie(6);
        Type[] type = new Type[5];

        for(int i = 0 ; i < type.length ; i ++) {
            type[i] = Type.SCISSORS;
        }

        t.add(type);
        t.add(type);
        t.add(type);

        assertEquals(Type.ROCK, t.getEstimate(type));
    }

    public void testAddAndGetPaper() throws Exception {
        RaliTrie t = new RaliTrie(6);
        Type[] type = new Type[5];

        for(int i = 0 ; i < type.length ; i ++) {
            type[i] = Type.ROCK;
        }

        t.add(type);
        t.add(type);
        t.add(type);

        assertEquals(Type.PAPER, t.getEstimate(type));
    }

}