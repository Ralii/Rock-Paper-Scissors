package logic;

import dataStructures.PrefixTree;
import dataStructures.RaliStack;
import dataStructures.Responses;
import dataStructures.Type;

import java.util.Collections;
import java.util.Scanner;

/**
 * Created by Ralii on 1.8.15.
 */

/*
Pelin päärunko, joka ohjaa pelin kulkua.
 */
public class App {
    PrefixTree tree;
    Scanner in;
    RaliStack stack;
    Responses responses;
    Type lastAnswer;

    public App(){
        this.tree = new PrefixTree(4);
        this.in = new Scanner(System.in);
        this.stack = new RaliStack();
        this.responses = new Responses();
    }
    /*
    Pelin aloittaminen. Aloitusviesti, odotus ja pelaajan valinnan kysyminen.
     */
    public void startGame() throws InterruptedException{
        System.out.println("Welcome to the game of life! Rock-Paper-Scissors");
        Thread.sleep(1000);
        askChoice();
    }
    /*
    Kysytään pelaajalta sen valintaa ja hoidetaan valinnan jatkokäsittelyt; Valinnan tallentaminen puuhun ja arvion pelaajan seuraavasta valinnasta
    hakemisen.
     */
    private void askChoice() throws InterruptedException {

        System.out.println("Make your choice!");
        System.out.println("R = Rock P = Paper S = Scissors");

        String choice = in.nextLine().toUpperCase();

        switch (choice) {
            case "R":
                System.out.println("You threw Rock!");
                stack.insert(Type.ROCK);
                lastAnswer = Type.ROCK;
                response();
                break;
            case "P":
                System.out.println("You threw Paper!");
                stack.insert(Type.PAPER);
                lastAnswer = Type.PAPER;
                response();
                break;
            case "S":
                System.out.println("You threw Scissors!");
                stack.insert(Type.SCISSORS);
                lastAnswer = Type.SCISSORS;
                response();
                break;
            default:
                System.out.println("Incorrect answer, please try again.");
                Thread.sleep(500);
                askChoice();
        }
    }
    private void response() throws InterruptedException {
        // add tyhjentää stackin. Keksi vaihtoehto.
        RaliStack s = new RaliStack(stack);
        RaliStack st = new RaliStack(stack);
        tree.addPattern(st);
        Type t = tree.getPattern(s);

        Thread.sleep(500);
        System.out.println("My answer is " + t.toString() +"!");

        if(doesWin(t)) {
             System.out.println("AI wins!\n" + responses.getRandomWin());}
        else { System.out.println("AI looses! \n" + responses.getRandomLoose()); }

        playAgain();
    }

    private boolean doesWin(Type aiAnswer){return !aiAnswer.losesTo.equals(lastAnswer);}

    private void playAgain() throws InterruptedException {
        Thread.sleep(500);
        System.out.println("Would you like to play again? " + "Y = YES " + "N = NO");
        String choice = in.nextLine().toUpperCase();

        switch(choice) {
            case "Y":
                askChoice();
            case "N":
                System.out.println("I'm forever alone!");
                System.exit(1);
        }

    }
}
