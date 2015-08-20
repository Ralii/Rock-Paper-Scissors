package logic;


import dataStructures.Responses;
import dataStructures.Type;
import dataStructures2.Result;
import java.util.Scanner;

/**
 * Created by Ralii on 19.8.15.
 */
public class App2 {
    Scanner in;
    Responses responses;
    Ai ai;

    public App2(){
        this.in = new Scanner(System.in);
        this.responses = new Responses();
        this.ai = new Ai();
    }

    public void startGame() throws InterruptedException {
        while(true) {
            System.out.println("Welcome to the game of life! Rock-Paper-Scissors");
            Thread.sleep(1000);

            System.out.println("Make your choice!");
            System.out.println("R = Rock P = Paper S = Scissors");

            String choice = in.nextLine().toUpperCase();

            switch (choice) {
                case "R":
                    System.out.println("You threw Rock!");
                    startRound(Type.ROCK);
                    quit();
                    break;
                case "P":
                    System.out.println("You threw Paper!");
                    startRound(Type.PAPER);
                    quit();
                    break;
                case "S":
                    System.out.println("You threw Scissors!");
                    startRound(Type.SCISSORS);
                    quit();
                    break;
                default:
                    System.out.println("Incorrect answer, please try again.");
                    Thread.sleep(500);
            }
        }
    }

    private Boolean quit() throws InterruptedException {
        while (true) {
        Thread.sleep(500);
        System.out.println("Would you like to play again? " + "Y = YES " + "N = NO");
        String choice = in.nextLine().toUpperCase();

        switch(choice) {
                case "Y":
                    return false;
                case "N":
                    System.out.println("I'm forever alone!");
                    System.exit(1);
                    return true;

                default:
                    System.out.println("Incorrect answer! Please try again.");
            }
        }
    }

    private void startRound(Type t) {
        Result result = ai.result(t);
        switch(result) {
            case PLAYERWINS: System.out.println("Player wins!");
                break;
            case AIWINS: System.out.println("AI wins!");
                break;
            case TIE: System.out.println("It's a tie!");
                break;
        }
    }
}
