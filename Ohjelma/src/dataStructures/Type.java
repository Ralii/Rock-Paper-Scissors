package dataStructures;

/**
 * Enumeration of Types used in the program.
 */
public enum Type {
    ROCK, PAPER, SCISSORS;

    public Type losesTo;

    /**
     * Values for which the current Type looses the game.
     */
    static {
        ROCK.losesTo = PAPER;
        PAPER.losesTo = SCISSORS;
        SCISSORS.losesTo = ROCK;
    }
}
