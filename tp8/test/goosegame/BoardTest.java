package goosegame;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import goosegame.boards.ClassicalBoard;

public class BoardTest {
    @Before
    public void init() {
        this.b = new ClassicalBoard();
    }

    @Test
    public void testGetNbOfCells() {
        assertEquals(63, this.b.getNbOfCells());
    }

    @Test
    public void testGetCellWithValidIndex()
        throws UnknownCellException {
        assertSame(this.b.cells[0], this.b.getCell(0));
    }

    @Test(expected=UnknownCellException.class)
    public void testGetCellWithInvalidIndex()
        throws UnknownCellException {
        this.b.getCell(this.b.getNbOfCells() + 1);
    }

    private Board b;

    // ---Pour permettre l'execution des tests ----------------------
    public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(goosegame.BoardTest.class);
    }
}
