package goosegame;

import java.util.Random;

/**
 * A class to represent a player in a goose game
 */
public class Player {
    /**
     * Construct a player defined by a name and a cell
     * @param name Name of the player
     * @param cell Current cell of the player
     */
    public Player(String name, Cell cell) {
        this.name = name;
        this.cell = cell;
    }

    /**
     * Return the current cell of the player
     * @return Current cell of the player
     */
    public Cell getCell() {
        return this.cell;
    }

    /**
     * Set the cell of the player
     * @param newCell New current cell of the player
     */
    public void setCell(Cell newCell) {
        this.cell = newCell;
    }

    /**
     * Return the result of a 2d6 throws
     * @return Random number between 2 and 12
     */
    public int twoDiceThrow() {
        return this.oneDieThrow() + this.oneDieThrow();
    }

    /**
     * @see java.lang.Object#toString()
     */
    public String toString() {
        return this.name;
    }

    /* Private and protected fields and methods */

    /**
     * Return the result of a d6 throw
     * @return Random number between 1 and 6
     */
    private int oneDieThrow() {
        return Player.random.nextInt(6) + 1;
    }

    /** Random source */
    private static final Random random = new Random();

    /** Name of the player */
    protected String name;

    /** Cell the player occupies */
    protected Cell cell;
}
