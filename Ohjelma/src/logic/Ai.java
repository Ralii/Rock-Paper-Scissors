package logic;


import dataStructures.Type;
import dataStructures2.RaliTrie;
import dataStructures2.Result;
import dataStructures2.ShiftingTypeList;
import exeption.ListFullExeption;

import java.util.Random;

/**
 * Created by Ralii on 20.8.15.
 */
public class Ai {
    private ShiftingTypeList list;
    private RaliTrie trie;
    Random r = new Random();


    public Ai(){
        this.list = new ShiftingTypeList(5);
        this.trie = new RaliTrie(6);
    }

    public Result result(Type t) {
        list.add(t);
        if(list.length() < 5) {
            return giveRandom();
        }
        trie.add(list.toTypeList());

        Type playerAnswer = t;
        Type aiAnswer;
        try {
            aiAnswer = trie.getEstimate(list.toTypeList());
        } catch (ListFullExeption listFullExeption) {
            System.out.println("Unexpected exeption.");
            System.exit(0);
            return null;
        }

        if(playerAnswer.losesTo.equals(aiAnswer)) { return Result.PLAYERWINS; }
        if(aiAnswer.losesTo.equals(playerAnswer)) { return Result.AIWINS; }
        else return Result.TIE;
    }

    private Result giveRandom(){
        int a = r.nextInt(2);
        if(a == 0) { return Result.PLAYERWINS; }
        if(a == 1) { return Result.TIE; }
        if(a == 2) { return Result.AIWINS; }
        return Result.TIE;
    }
}
