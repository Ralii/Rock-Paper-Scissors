package dataStructures;

import java.util.Random;

/**
 * Created by Ralii on 1.8.15.
 */

/*
Luokka sisältää tietokonepelaajan vastaukset voittoon ja häviöön. Lisäksi kaksi apumetodia vastauksen satunnaistamiseen.
 */
public class Responses {
    private final String[] winning;
    private final String[] losing;
    private final Random random;

    public Responses(){
        this.winning = new String[4];
        this.losing = new String[4];
        this.random = new Random();
        init();
    }
    // Satunnaisen voittovastauksen valitseminen.
    public String getRandomWin(){ return winning[getRandom(4)]; }
    // Satunnaisen häviövastauksen valitseminen.
    public String getRandomLoose(){ return losing[getRandom(4)]; }

    // vastausten sisällyttäminen käytettäviin tietorakenteisiin.
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
    // Satunnaisluvun arpominen.
    private int getRandom(int cap){
        return random.nextInt(cap);
    }
}
