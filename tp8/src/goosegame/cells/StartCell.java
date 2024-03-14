package goosegame.cells;

import goosegame.Cell;
import goosegame.Player;

/**
 * A class to model the start cell of a goose game
 */
public class StartCell implements Cell {
    /**
     * Return the index of the cell. The index is 0
     * @return <code>0</code>
     */
    public int getIndex() {
        return 0;
    }

    /**
     * Return <code>null</code>
     * @return <code>null</code>
     */
    public Player getPlayer() {
        return null;
    }

    /**
     * Return <code>true</code> to indicate that the start cell can
     * always be left
     * @return <code>true</code>
     */
    public boolean canBeLeft() {
        return true;
    }

    /**
     * Return <code>false</code> to indicate that the start cell is
     * never busy
     * @return <code>false</code>
     */
    public boolean isBusy() {
        return false;
    }

    /**
     * Do nothing
     * @param player Unused argument
     */
    public void welcomePlayer(Player player) {
        // do nothing
    }

    /**
     * Return <code>0</code> to indicate that the start cell
     * never bounces
     * @return <code>0</code>*/
    public int bounce(int diceThrow) {
        return 0;
    }

    /**
     * @see java.lang.Object#toString()
     */
    public String toString() {
        return "start cell";
    }
}
