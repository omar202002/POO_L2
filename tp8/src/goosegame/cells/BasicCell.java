package goosegame.cells;

import goosegame.Cell;
import goosegame.Player;

/**
 * A class to model a basic cell in a goose game. This cell
 * can be left immediately and has no special effect
 */
public class BasicCell implements Cell {
    /**
     * Construct a cell defined by its board index. The cell initially
     * contains no player
     * @param index Board index of the cell
     */
    public BasicCell(int index) {
        this.index = index;
        this.player = null;
    }

    /**
     * @see goosegame.Cell#getIndex()
     */
    public int getIndex() {
        return this.index;
    }

    /**
     * @see goosegame.Cell#getPlayer()
     */
    public Player getPlayer() {
        return this.player;
    }

    /**
     * Return <code>true</code>, to indicate that the cell can always be left
     * @return <code>true</code>
     */
    public boolean canBeLeft() {
        return true;
    }

    /**
     * @see goosegame.Cell#isBusy()
     */
    public boolean isBusy() {
        return this.player != null;
    }

    /**
     * @see goosegame.Cell#welcomePlayer(Player)
     */
    public void welcomePlayer(Player player) {
        this.player = player;
        if (player != null) {
            player.setCell(this);
        }
    }

    /**
     * Return 0, to indicate that this cell has no bounce
     * @param diceThrow The result of the diceThrow which sent the player
     * to this cell
     * @return <code>0</code>
     */
    public int bounce(int diceThrow) {
        return 0;
    }

    /**
     * @see java.lang.Object#toString()
     */
    public String toString() {
        return "cell " + this.index;
    }

    /** Board index of the cell */
    protected int index;

    /** Player in the cell, null if the cell is empty */
    protected Player player;
}
