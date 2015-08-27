package logic;


import dataStructures.Responses;
import dataStructures.Type;
import dataStructures.Result;
import java.util.Scanner;

/**
 * Main class of the game. Handles the text user-interface and delegates methods to ai component.
 */
public class App {
    Scanner in;
    Responses responses;
    Ai ai;
    int[] scoreBoard;

    public App(){
        this.in = new Scanner(System.in);
        this.responses = new Responses();
        this.ai = new Ai();
        this.scoreBoard = new int[2];
        scoreBoard[0] = 0;
        scoreBoard[1] = 0;
    }

    /**
     * Method for starting the game. Includes the event loop.
     * @throws InterruptedException Throws exeption if thread.sleep is interrupted
     */
    public void startGame(){
        while(true) {
            System.out.println("Welcome to the game of life! Rock-Paper-Scissors");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Something went wrong");
                System.exit(0);
            }

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
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        System.out.println("Something went wrong");
                        System.exit(0);
                     }
            }
        }
    }

    /**
     * Quitting the game and exiting the program if the user chooses so.
     * @return Wether the user chose to quit the program.
     * @throws InterruptedException If thread.sleep is interrupted.
     */
    private Boolean quit() {
        while (true) {
        try {
            Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Something went wrong");
                System.exit(0);
            }
        System.out.println("Would you like to play again? " + "Y = YES " + "N = NO");
        String choice = in.nextLine().toUpperCase();

        switch(choice) {
                case "Y":
                    return false;
                case "N":
                    System.out.println("I'm forever alone!");
                    ai.quitGame();
                    System.exit(1);
                    return true;

                default:
                    System.out.println("Incorrect answer! Please try again.");
            }
        }
    }

    /**
     * Getting the result of the game and notifying the user about the end result.
     * @param t Type user has chosen for this round.
     */
    private void startRound(Type t) {
        Result result = ai.result(t);
        switch(result) {
            case PLAYERWINS: System.out.println("Player wins!");
                System.out.println(responses.getRandomLoose());
                scoreBoard[0]++;
                System.out.println("Score: Player " + scoreBoard[0] + " Ai: " + scoreBoard[1]);

                break;
            case AIWINS: System.out.println("AI wins!");
                System.out.println(responses.getRandomWin());
                scoreBoard[1]++;
                System.out.println("Score: Player " + scoreBoard[0] + " Ai: " + scoreBoard[1]);

                break;
            case TIE: System.out.println("It's a tie!");
                System.out.println("Score: Player " + scoreBoard[0] + " Ai: " + scoreBoard[1]);
                break;
        }
    }
}
