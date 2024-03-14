package goosegame.cells;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import goosegame.*;

public class TrapCellTest {
    @Test
    public void testCanBeLeft() {
        Cell c = new TrapCell(12);
        Player p = new Player("tarik", null);
        c.welcomePlayer(p);
        assertFalse(c.canBeLeft());
        assertFalse(c.canBeLeft());
        assertFalse(c.canBeLeft());
    }

    // ---Pour permettre l'execution des tests ----------------------
    public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(goosegame.cells.TrapCellTest.class);
    }
}
