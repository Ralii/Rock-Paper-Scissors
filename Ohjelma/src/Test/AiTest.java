package Test;

import com.sun.tools.jdeps.Analyzer;
import dataStructures.Type;
import javafx.scene.image.PixelFormat;
import junit.framework.TestCase;
import logic.Ai;

public class AiTest extends TestCase {

    public void testResult() throws Exception {
        Ai ai = new Ai();
        ai.result(Type.PAPER);
        ai.result(Type.PAPER);
        ai.result(Type.PAPER);
        ai.result(Type.PAPER);
        ai.result(Type.PAPER);

        assertEquals(Type.SCISSORS, ai.result(Type.PAPER));
    }

}