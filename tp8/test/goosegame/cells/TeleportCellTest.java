package goosegame.cells;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import goosegame.*;

public class TeleportCellTest {
    @Test
    public void testBounceWithForwardJump() {
        Cell c = new TeleportCell(12, 17);
        assertEquals(5, c.bounce(2));
    }

    @Test
    public void testBounceWithBackwardJump() {
        Cell c = new TeleportCell(12, 5);
        assertEquals(-7, c.bounce(2));
    }

    // ---Pour permettre l'execution des tests ----------------------
    public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(goosegame.cells.TeleportCellTest.class);
    }
}
