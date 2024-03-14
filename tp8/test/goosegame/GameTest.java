package goosegame;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import goosegame.boards.ClassicalBoard;

public class GameTest {
    @Before
    public void init() {
        this.board = new ClassicalBoard();
        this.board.initBoard();
        this.game = new Game(this.board);
        this.p1 = new Player("Tarik", null);
        this.p2 = new Player("Yassine", null);
        this.p3 = new Player("Zakari", null);
    }

    @Test
    public void canAddPlayers()
        throws UnknownCellException {
        this.game.addPlayer(this.p1);
        this.game.addPlayer(this.p2);
        this.game.addPlayer(this.p3);
    }

    @Test
    public void canGetPlayers()
        throws UnknownCellException, NoPlayerException {
        this.game.addPlayer(this.p1);
        this.game.addPlayer(this.p2);
        this.game.addPlayer(this.p3);
        assertSame(this.p1, this.game.nextPlayer());
        assertSame(this.p2, this.game.nextPlayer());
        assertSame(this.p3, this.game.nextPlayer());
    }

    @Test
    public void canGetPlayersWithWrap()
        throws UnknownCellException, NoPlayerException {
        this.game.addPlayer(this.p1);
        this.game.addPlayer(this.p2);
        this.game.addPlayer(this.p3);
        assertSame(this.p1, this.game.nextPlayer());
        assertSame(this.p2, this.game.nextPlayer());
        assertSame(this.p3, this.game.nextPlayer());
        assertSame(this.p1, this.game.nextPlayer());
        assertSame(this.p2, this.game.nextPlayer());
        assertSame(this.p3, this.game.nextPlayer());
    }

    @Test
    public void canGetPlayersWhenPlayerArrivesMidGame()
        throws UnknownCellException, NoPlayerException {
        this.game.addPlayer(this.p1);
        this.game.addPlayer(this.p2);
        assertSame(this.p1, this.game.nextPlayer());
        assertSame(this.p2, this.game.nextPlayer());
        this.game.addPlayer(this.p3);
        assertSame(this.p1, this.game.nextPlayer());
        assertSame(this.p2, this.game.nextPlayer());
        assertSame(this.p3, this.game.nextPlayer());
    }

    @Test(expected=NoPlayerException.class)
    public void cannotGetPlayersWhenNoPlayers()
        throws NoPlayerException {
        this.game.nextPlayer();
    }

    @Test(expected=NoPlayerException.class)
    public void cannotPlayWithoutPlayers()
        throws UnknownCellException, NoPlayerException {
        this.game.play();
    }

    @Test
    public void testCanPlayWhenPlayerOnStartCell() {
        this.board.cells[0].welcomePlayer(this.p1);
        this.p1.setCell(this.board.cells[0]);
        assertTrue(this.game.canPlay(this.p1));
    }

    @Test
    public void testCanPlayWhenPlayerOnBasicCell() {
        this.board.cells[1].welcomePlayer(this.p1);
        this.p1.setCell(this.board.cells[1]);
        assertTrue(this.game.canPlay(this.p1));
    }

    @Test
    public void testCanPlayWhenPlayerOnWaitingCell() {
        this.board.cells[19].welcomePlayer(this.p1);
        this.p1.setCell(this.board.cells[19]);
        assertFalse(this.game.canPlay(this.p1));
        assertFalse(this.game.canPlay(this.p1));
        assertTrue(this.game.canPlay(this.p1));
    }

    @Test
    public void testCanPlayWhenPlayerOnTrapCell() {
        this.board.cells[31].welcomePlayer(this.p1);
        this.p1.setCell(this.board.cells[31]);
        assertFalse(this.game.canPlay(this.p1));
    }

    @Test
    public void testCanPlayWhenPlayerOnGooseCell() {
        this.board.cells[9].welcomePlayer(this.p1);
        this.p1.setCell(this.board.cells[9]);
        assertTrue(this.game.canPlay(this.p1));
    }

    @Test
    public void testMovePlayerNoExchange()
        throws UnknownCellException {
        // init
        this.board.cells[5].welcomePlayer(this.p1);
        this.p1.setCell(this.board.cells[5]);
        // pre
        assertTrue(this.board.getCell(5).isBusy());
        assertSame(this.p1, this.board.getCell(5).getPlayer());
        assertSame(this.board.getCell(5), this.p1.getCell());
        // exec
        this.game.movePlayer(this.p1, this.board.cells[7]);
        // post
        assertFalse(this.board.getCell(5).isBusy());
        assertTrue(this.board.getCell(7).isBusy());
        assertSame(this.p1, this.board.getCell(7).getPlayer());
        assertSame(this.board.getCell(7), this.p1.getCell());
    }

    @Test
    public void testMovePlayerWithExchange()
        throws UnknownCellException {
        // init
        this.board.cells[5].welcomePlayer(this.p1);
        this.p1.setCell(this.board.cells[5]);
        this.board.cells[7].welcomePlayer(this.p2);
        this.p2.setCell(this.board.cells[7]);
        // pre
        assertTrue(this.board.getCell(5).isBusy());
        assertSame(this.p1, this.board.getCell(5).getPlayer());
        assertSame(this.board.getCell(5), this.p1.getCell());

        assertTrue(this.board.getCell(7).isBusy());
        assertSame(this.p2, this.board.getCell(7).getPlayer());
        assertSame(this.board.getCell(7), this.p2.getCell());
        // exec
        this.game.movePlayer(this.p1, this.board.cells[7]);
        // post
        assertTrue(this.board.getCell(5).isBusy());
        assertTrue(this.board.getCell(7).isBusy());
        assertSame(this.p1, this.board.getCell(7).getPlayer());
        assertSame(this.board.getCell(7), this.p1.getCell());
        assertSame(this.p2, this.board.getCell(5).getPlayer());
        assertSame(this.board.getCell(5), this.p2.getCell());
    }

    private Game game;

    private Board board;

    private Player p1;
    private Player p2;
    private Player p3;

    // ---Pour permettre l'execution des tests ----------------------
    public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(goosegame.GameTest.class);
    }
}
