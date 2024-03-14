package goosegame.cells;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import goosegame.*;

public class StartCellTest {
    @Before
    public void init() {
        this.c = new StartCell();
    }

    @Test
    public void testGetIndex() {
        assertEquals(0, this.c.getIndex());
    }

    @Test
    public void testGetPlayer() {
        assertEquals(null, this.c.getPlayer());
    }

    @Test
    public void testCanBeLeft() {
        assertTrue(this.c.canBeLeft());
    }

    @Test
    public void testIsBusy() {
        assertFalse(this.c.isBusy());
    }

    @Test
    public void testBounce() {
        int diceThrow = 2;
        assertEquals(0, this.c.bounce(diceThrow));
    }

    private Cell c;

    // ---Pour permettre l'execution des tests ----------------------
    public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(goosegame.cells.StartCellTest.class);
    }
}
