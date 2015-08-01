package dataStructures;

/**
 * Created by Ralii on 31.7.15.
 */
public enum Type {
    ROCK, PAPER, SCISSORS;

    public Type losesTo;

    static {
        ROCK.losesTo = PAPER;
        PAPER.losesTo = SCISSORS;
        SCISSORS.losesTo = ROCK;
    }
}
