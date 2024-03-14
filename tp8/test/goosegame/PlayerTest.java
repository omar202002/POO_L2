package goosegame;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import goosegame.cells.*;

public class PlayerTest {
    @Test
    public void canCreatePlayer() {
        Cell c = new BasicCell(12);
        Player p = new Player("tarik", c);
        assertSame(c, p.getCell());
    }

    @Test
    public void canGetAndSetCell() {
        Cell c1 = new BasicCell(12);
        Player p = new Player("tarik", c1);
        assertSame(c1, p.getCell());
        Cell c2 = new WaitingCell(24, 2);
        p.setCell(c2);
        assertSame(c2, p.getCell());
    }

    @Test
    public void canThrowDice() {
        Player p = new Player("tarik", null);
        int diceThrow = p.twoDiceThrow();
        assertTrue(diceThrow >= 2);
        assertTrue(diceThrow <= 12);
    }

    // ---Pour permettre l'execution des tests ----------------------
    public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(goosegame.PlayerTest.class);
    }
}
