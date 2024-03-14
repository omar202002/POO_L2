package goosegame.cells;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import goosegame.*;

public class WaitingCellTest {
    @Test
    public void testWaitWhenPositiveTime() {
        Cell c = new WaitingCell(12, 3);
        Player p = new Player("tarik", null);
        c.welcomePlayer(p);
        assertFalse(c.canBeLeft());
        assertFalse(c.canBeLeft());
        assertFalse(c.canBeLeft());
        assertTrue(c.canBeLeft());
    }

    @Test
    public void testWaitWhenNegativeTime() {
        Cell c = new WaitingCell(12, -2);
        Player p = new Player("tarik", null);
        c.welcomePlayer(p);
        assertTrue(c.canBeLeft());
    }

    @Test
    public void testWaitConsecutivePlayers() {
        Cell c = new WaitingCell(12, 3);
        Player p1 = new Player("berhil", null);
        Player p2 = new Player("zakari", null);
        c.welcomePlayer(p1);
        assertFalse(c.canBeLeft());
        assertFalse(c.canBeLeft());
        assertFalse(c.canBeLeft());
        assertTrue(c.canBeLeft());
        c.welcomePlayer(p2);
        assertFalse(c.canBeLeft());
        assertFalse(c.canBeLeft());
        assertFalse(c.canBeLeft());
        assertTrue(c.canBeLeft());
    }

    // ---Pour permettre l'execution des tests ----------------------
    public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(goosegame.cells.WaitingCellTest.class);
    }
}
