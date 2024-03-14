package goosegame.cells;

import goosegame.Cell;
import goosegame.Player;

/**
 * A class to model a cell with a bounce effet sending the player to
 * a specific cell
 */
public class TeleportCell extends BasicCell {
    /**
     * Construct a cell defined by a board index, and the index of the
     * cell it sends the player to
     * @param index Index of the cell on the board
     * @param jumpIndex Index of the cell to send the player to
     */
    public TeleportCell(int index, int jumpIndex) {
        super(index);
        this.jumpIndex = jumpIndex;
    }

    /**
     * Return the size of the bounce to the cell where the player needs
     * to be sent
     * @param diceThrow The result of the diceThrow which sent the player
     * to this cell
     * @return The size of the bounce
     */
    public int bounce(int diceThrow) {
        return this.jumpIndex - this.index;
    }

    /**
     * @see java.lang.Object#toString()
     */
    public String toString() {
        return super.toString() + " (teleport to " + this.jumpIndex + ")";
    }

    /** Index of the cell the player is teleported to */
    protected int jumpIndex;
}
