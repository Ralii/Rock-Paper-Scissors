package dataStructures;

import java.util.Random;

/**
 * Responses for winning and loosing the game.
 */
public class Responses {
    private final String[] winning;
    private final String[] losing;
    private final Random random;

    public Responses(){
        this.winning = new String[5];
        this.losing = new String[5];
        this.random = new Random();
        init();
    }

    /**
     * Getter for the random win quote.
     * @return Returns random win quote.
     */
    public String getRandomWin(){ return winning[getRandom(4)]; }

    /**
     * Getter for the random loose quote.
     * @return Returns random loose quote.
     */
    public String getRandomLoose(){ return losing[getRandom(4)]; }

    /**
     * Initializing the data structures inside of the Class.
     */
    private void init(){
        winning[0] = "Victory has a thousand fathers, but defeat is an orphan. MUAHAHAH";
        winning[1] = "Victory belongs to the most persevering.";
        winning[2] = "Hävisit pelin!";
        winning[3] = "FAIL!";
        winning[4] = "Finish him!";

        losing[0] = "We always learn more from the losing than the winning.";
        losing[1] = "The difference between winning and losing is always a mental one.";
        losing[2] = "You’re always going to survive the pain of loss. I can live with that confidence inside of me.";
        losing[3] = "The mark of a great player is in his ability to come back. The great champions have all come back from defeat.";
        losing[4] = "If you don’t invest very much, then defeat doesn’t hurt very much and winning is not very exciting.";
    }

    /**
     * Getting the random index for the quote.
     * @param cap Is the maximum limit of the index.
     * @return Returns the index for the quote.
     */
    private int getRandom(int cap){
        return random.nextInt(cap);
    }
}
