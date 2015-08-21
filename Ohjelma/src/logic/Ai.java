package logic;


import dataStructures.Type;
import dataStructures.RaliTrie;
import dataStructures.Result;
import dataStructures.ShiftingTypeList;
import exeption.ListFullExeption;

import java.util.Random;

/**
 * Ai component of the program that handles the mechanics of the game.
 */
public class Ai {
    private ShiftingTypeList list;
    private RaliTrie trie;
    Random r = new Random();


    public Ai(){
        this.list = new ShiftingTypeList(5);
        this.trie = new RaliTrie(6);
    }

    /**
     * For getting the game result for player chosen type and choosing the ai type.
     * @param t Type player has chosen for this round.
     * @return returns the RESULT of the game.
     */
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

    /**
     * Deciding a random result for the game.
     * @return returns a RESULT. The outcome of the game.
     */
    private Result giveRandom(){
        int a = r.nextInt(2);
        if(a == 0) { return Result.PLAYERWINS; }
        if(a == 1) { return Result.TIE; }
        if(a == 2) { return Result.AIWINS; }
        return Result.TIE;
    }
}
