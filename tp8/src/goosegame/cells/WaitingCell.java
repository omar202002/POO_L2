package goosegame.cells;

import goosegame.Cell;
import goosegame.Player;

/**
 * A class to model a cell which a player cannot leave for
 * a predetermined number of turns
 */
public class WaitingCell extends BasicCell {
    /**
     * Construct a cell defined by a board index and a wait duration. The
     * Cell initiatlly contains no player
     * @param index Board index of the cell
     * @param duration Number of turns to wait before being able to leave.
     * A negative number will be interpreted as 0
     */
    public WaitingCell(int index, int duration) {
        super(index);
        this.waitTime = duration;
        this.waitDuration = duration;
    }

    /**
     * Return <code>true</code> if and only if the wait time has expired.
     * If the player cannot leave yet, increment by one the number of turns
     * spent inside the cell
     * @return <code>true</code> if the player has waited for the specified
     * number of turns, else <code>false</code>
     */
    public boolean canBeLeft() {
        if (this.waitTime <= 0) {
            return true;
        }
        --this.waitTime;
        return false;
    }

    /**
     * Handle the arrival of a player in the cell. Initialize the
     * wait mechanism
     * @param player A player arriving in the cell
     */
    public void welcomePlayer(Player player) {
        super.welcomePlayer(player);
        if (player != null) {
            waitTime = waitDuration;
        }
    }

    /**
     * @see java.lang.Object#toString()
     */
    public String toString() {
        return super.toString() + " (waiting for " +
            this.waitTime + (waitTime > 1 ? " turns" : " turn") +")";
    }

    /** Number of turns left to wait */
    protected int waitTime;

    /** Number of turns a player must wait */
    protected int waitDuration;
}
