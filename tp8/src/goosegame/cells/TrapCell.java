package goosegame.cells;

import goosegame.Cell;
import goosegame.Player;

/**
 * A class to model a cell which a player cannot leave, except if
 * replaced by another player
 */
public class TrapCell extends BasicCell {
    /**
     * Construct a cell defined by a board index. This cell cannot be
     * left, except if a new player gets trapped instead
     * @index Index of the cell on the board
     */
    public TrapCell(int index) {
        super(index);
    }

    /**
     * Return <code>false</code>, to indicate that the cell cannot
     * be left
     * @return <code>false</code> unconditionnally
     */
    public boolean canBeLeft() {
        return false;
    }

    /**
     * @see java.lang.Object#toString()
     */
    public String toString() {
        return super.toString() + " (trap)";
    }
}
