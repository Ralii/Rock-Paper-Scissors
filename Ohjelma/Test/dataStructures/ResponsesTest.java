package dataStructures;

import junit.framework.TestCase;

public class ResponsesTest extends TestCase {

    public void testGetRandomWin() throws Exception {
        Responses r = new Responses();
        r.getRandomWin();
    }

    public void testGetRandomLoose() throws Exception {
        Responses r = new Responses();
        r.getRandomLoose();
    }
}