package goosegame.cells;

import goosegame.Cell;
import goosegame.Player;

/**
 * A class to model a cell with a bounce effect which makes the player
 * move by the same amount that led him to the cell
 */
public class GooseCell extends BasicCell {
    /**
     * Construct a cell defined by a board index
     * @param index Index of the cell on the board
     */
    public GooseCell(int index) {
        super(index);
    }

    /**
     * Return the same number as the dice throw result
     * @param diceThrow The result of the diceThrow which sent the player
     * to this cell
     * @return diceThrow
     */
    public int bounce(int diceThrow) {
        return diceThrow;
    }

    /**
     * @see java.lang.Object#toString()
     */
    public String toString() {
        return super.toString() + " (goose)";
    }
}
