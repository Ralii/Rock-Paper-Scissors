package logic;

import dataStructures.Result;
import dataStructures.Type;
import junit.framework.TestCase;
import logic.Ai;

public class AiTest extends TestCase {

    public void testSimplePattern1() throws Exception {
        Ai ai = new Ai();
        ai.result(Type.PAPER);
        ai.result(Type.PAPER);
        ai.result(Type.PAPER);
        ai.result(Type.PAPER);
        ai.result(Type.PAPER);

    }

    public void testSimplePattern2() throws Exception {
        Ai ai = new Ai();
        ai.result(Type.PAPER);
        ai.result(Type.ROCK);
        ai.result(Type.SCISSORS);
        ai.result(Type.ROCK);
        ai.result(Type.SCISSORS);
        ai.result(Type.ROCK);
        ai.result(Type.SCISSORS);
        ai.result(Type.ROCK);
        ai.result(Type.SCISSORS);
        ai.result(Type.ROCK);
        ai.result(Type.SCISSORS);
        ai.result(Type.ROCK);
        ai.result(Type.SCISSORS);
    }

    public void testQuitGame() throws Exception {
        Ai ai = new Ai();
        ai.quitGame();
    }

}