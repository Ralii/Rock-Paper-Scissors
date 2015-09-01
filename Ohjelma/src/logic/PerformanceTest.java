package logic;

import dataStructures.RaliTrie;
import dataStructures.Type;
import exeption.ListFullExeption;

/**
 * Created by Ralii on 28.8.15.
 */
public class PerformanceTest {

    public void Add(int ammount) {
        long start = System.currentTimeMillis();

        RaliTrie trie = new RaliTrie(11);
        Type[] array = new Type[10];

        for(int i = 0 ; i < array.length ; i++) {
            array[i] = Type.PAPER;
        }

        for(int i = 0 ; i < ammount ; i++) {
            trie.add(array);
        }
        long end = System.currentTimeMillis();

        System.out.println("Testi Add vei tasolla " +ammount +" aikaa: " + (end - start));
    }

    public void AddAndGetParallel(int ammount) {
        long start = System.currentTimeMillis();

        RaliTrie trie = new RaliTrie(11);
        Type[] array = new Type[10];

        for(int i = 0 ; i < array.length ; i++) {
            array[i] = Type.PAPER;
        }

        for(int i = 0 ; i < ammount ; i++) {
            trie.add(array);
            try {
                trie.getEstimate(array);
            } catch (ListFullExeption listFullExeption) {
                listFullExeption.printStackTrace();
            }
        }
        long end = System.currentTimeMillis();

        System.out.println("Testi AddAndGetParallel vei tasolla " +ammount +" aikaa: " + (end - start));
    }

    public void AddAndGetSeparate(int ammount) {
        long start = System.currentTimeMillis();

        RaliTrie trie = new RaliTrie(11);
        Type[] array = new Type[10];

        for(int i = 0 ; i < array.length ; i++) {
            array[i] = Type.PAPER;
        }

        for(int i = 0 ; i < ammount ; i++) {
            trie.add(array);
        }

        for(int i = 0 ; i < ammount ; i++) {
            try {
                trie.getEstimate(array);
            } catch (ListFullExeption listFullExeption) {
                listFullExeption.printStackTrace();
            }
        }

        long end = System.currentTimeMillis();

        System.out.println("Testi AddAndGetSeparate vei tasolla " +ammount +" aikaa: " + (end - start));
    }
}
