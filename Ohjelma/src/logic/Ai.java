package logic;

import dataStructures.Type;
import dataStructures.RaliTrie;
import dataStructures.Result;
import dataStructures.ShiftingTypeList;
import exeption.ListFullExeption;

import java.io.*;
import java.util.Random;

/**
 * Ai component of the program that handles the mechanics of the game.
 */
public class Ai {
    private ShiftingTypeList list;
    private RaliTrie trie;
    Random r = new Random();

    public Ai(){
        this.list = readSerializedTypeList();
        this.trie = readSerializedTrie();
    }

    /**
     * For getting the game result for player chosen type and choosing the ai type.
     * @param t Type player has chosen for this round.
     * @return returns the RESULT of the game.
     */
    public Result result(Type t) {

        if(list.length() < 10) {
            return giveRandom();
        }


        Type playerAnswer = t;
        Type aiAnswer;
        try {
            aiAnswer = trie.getEstimate(list.toTypeList());
            list.add(t);
            list.add(aiAnswer);
            trie.add(list.toTypeList());

        } catch (ListFullExeption listFullExeption) {
            System.out.println("Unexpected exeption.");
            System.exit(0);
            return null;
        }

        if(playerAnswer.losesTo.equals(aiAnswer)) { return Result.AIWINS; }
        if(aiAnswer.losesTo.equals(playerAnswer)) { return Result.PLAYERWINS; }
        else return Result.TIE;
    }

    /**
     * Deciding a random result for the game.
     * @return returns a RESULT. The outcome of the game.
     */
    private Result giveRandom(){
        int a = r.nextInt(3);
        if(a == 0) { return Result.PLAYERWINS; }
        if(a == 1) { return Result.TIE; }
        if(a == 2) { return Result.AIWINS; }
        return Result.TIE;
    }

    public void quitGame(){
        try
        {
            FileOutputStream fileOut =
                new FileOutputStream("trie.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(trie);
            out.close();
            fileOut.close();
        }catch(IOException i) {
        i.printStackTrace();
        }
        try {
            FileOutputStream fileOut =
                    new FileOutputStream("typelist.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(list);
            out.close();
            fileOut.close();
        }catch(IOException i) {
            i.printStackTrace();
        }
    }

    private RaliTrie readSerializedTrie(){
        RaliTrie t = null;
        try
        {
            FileInputStream fileIn = new FileInputStream("trie.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
             t = (RaliTrie) in.readObject();
            in.close();
            fileIn.close();
        }catch(IOException i)
        {
            i.printStackTrace();

        }catch(ClassNotFoundException c)
        {
            System.out.println("Trie class not found");
            c.printStackTrace();

        }
        return t;
    }
    private ShiftingTypeList readSerializedTypeList(){
        ShiftingTypeList t = null;
        try
        {
            FileInputStream fileIn = new FileInputStream("typelist.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            t = (ShiftingTypeList) in.readObject();
            in.close();
            fileIn.close();
        }catch(IOException i)
        {
            i.printStackTrace();

        }catch(ClassNotFoundException c)
        {
            System.out.println("ShiftingTypeList class not found");
            c.printStackTrace();

        }
        return t;
    }
}
