package goosegame.cells;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import goosegame.*;

public class BasicCellTest {
    @Before
    public void init() {
        this.i1 = 5;
        this.i2 = 12;
        this.c1 = new BasicCell(this.i1);
        this.c2 = new BasicCell(this.i2);
        this.p = new Player("tarik", null);
    }

    @Test
    public void testGetIndex() {
        assertEquals(5, this.c1.getIndex());
        assertEquals(12, this.c2.getIndex());
    }

    @Test
    public void testGetPlayer() {
        assertFalse(this.c1.isBusy());
        assertSame(null, this.c1.getPlayer());
        this.c1.welcomePlayer(p);
        assertSame(p, this.c1.getPlayer());
        this.c1.welcomePlayer(null);
        assertSame(null, this.c1.getPlayer());
    }

    @Test
    public void testCanBeLeft() {
        assertTrue(this.c1.canBeLeft());
    }

    @Test
    public void testIsBusy() {
        assertFalse(this.c1.isBusy());
    }

    @Test
    public void testBounce() {
        int diceThrow = 2;
        assertEquals(0, this.c1.bounce(diceThrow));
    }

    private int i1;
    private int i2;
    private Cell c1;
    private Cell c2;
    private Player p;

    // ---Pour permettre l'execution des tests ----------------------
    public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(goosegame.cells.BasicCellTest.class);
    }
}
