package logic;

import dataStructures.PrefixTree;
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

    public App(){
        this.tree = new PrefixTree(4);
        this.in = new Scanner(System.in);
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
    public void askChoice() throws InterruptedException {

        System.out.println("Make your choice!");
        System.out.println("R = Rock P = Paper S = Scissors");

        String choice = in.nextLine().toUpperCase();

        switch (choice) {
            case "R":
                System.out.println("You threw Rock!");
                break;
            case "P":
                System.out.println("You threw Paper!");
                break;
            case "S":
                System.out.println("You threw Scissors!");
                break;
            default:
                System.out.println("Incorrect answer, please try again.");
                Thread.sleep(500);
                askChoice();
        }
    }
}
