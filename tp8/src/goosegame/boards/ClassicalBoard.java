package goosegame.boards;

import goosegame.Board;
import goosegame.Cell;
import goosegame.cells.*;

/**
 * A class to model the board of the original version of the goose game
 */
public class ClassicalBoard extends Board {
    /**
     * Construct the board of the original goose game
     */
    public ClassicalBoard() {
        super(NUM_CELLS);
    }

    /**
     * Fill the board with the cells of the original goose game board
     */
    protected void initBoard() {
        this.cells[0] = new StartCell();

        for (int i = 0; i < GEESE_INDEX.length; ++i) {
            this.cells[GEESE_INDEX[i]] = new GooseCell(GEESE_INDEX[i]);
        }
        for (int i = 0; i < TRAPS_INDEX.length; ++i) {
            this.cells[TRAPS_INDEX[i]] = new TrapCell(TRAPS_INDEX[i]);
        }
        for (int i = 0; i < WAITING_INDEX.length; ++i) {
            this.cells[WAITING_INDEX[i][0]] =
                new WaitingCell(WAITING_INDEX[i][0], WAITING_INDEX[i][1]);
        }
        for (int i = 0; i < TELEPORTATION_INDEX.length; ++i) {
            this.cells[TELEPORTATION_INDEX[i][0]] =
                new TeleportCell(TELEPORTATION_INDEX[i][0], TELEPORTATION_INDEX[i][1]);
        }

        for (int i = 1; i <= this.nbOfCells; ++i) {
            if (this.cells[i] == null) {
                this.cells[i] = new BasicCell(i);
            }
        }
    }

    /** Number of cells, not including the start cell */
    private static final int NUM_CELLS = 63;

    /** Indexes of the goose cells */
    private static final int[] GEESE_INDEX = {9, 18, 27, 36, 45, 54};

    /** Indexes of the trap cells */
    private static final int[] TRAPS_INDEX = {31, 52};

    /** Each array in WAITING_INDEX has a board index as a first element
        and a number of turns to wait as a second element */
    private static final int[][] WAITING_INDEX = {{19, 2}};

    /** Each array in TELEPORTATION_INDEX has a board index representing the
        position of the cell on the board as a first element, and a board
        index representing the cell it teleports the player to as a second
        element */
    private static final int[][] TELEPORTATION_INDEX = {{6, 12}, {42, 30}, {58, 1}};
}
