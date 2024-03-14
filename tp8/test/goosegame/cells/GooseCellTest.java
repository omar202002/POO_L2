package goosegame.cells;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import goosegame.*;

public class GooseCellTest {
    @Test
    public void testBounce() {
        Cell c = new GooseCell(12);
        Player p = new Player("tarik", null);
        c.welcomePlayer(p);
        assertEquals(5, c.bounce(5));
    }

    // ---Pour permettre l'execution des tests ----------------------
    public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(goosegame.cells.GooseCellTest.class);
    }
}
