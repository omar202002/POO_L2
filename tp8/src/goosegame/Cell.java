package goosegame;

/**
 * An interface to model cells in a goose game.
 * Note that there can only be one player by cell
 */
public interface Cell {
    /**
     * Return the index of this cell
     * @return Index of this cell
     */
    public int getIndex();

    /**
     * Return the player located in the cell, or null if no player
     * is present
     * @return Player in the cell
     */
    public Player getPlayer();

    /**
     * Return <code>true</code> if and only if the cell can be left freely
     * by a player, without waiting for a number of turns, or for another
     * player
     * @return <code>true</code> if the cell can be left freely
     */
    public boolean canBeLeft();

    /**
     * Return <code>true</code> if and only if a player is in this cell
     * @return <code>true</code> if a player is in the cell
     */
    public boolean isBusy();

    /**
     * Handle the arrival of a player in the cell
     * @param player A player arriving in the cell
     */
    public void welcomePlayer(Player player);

    /**
     * Return the size of the bounce when arriving in this cell. A value
     * of 0 indicates that there is no bounce
     * @param diceThrow The result of the dice throw which led the player
     * to this cell
     * @return The size of the bounce
     */
    public int bounce(int diceThrow);
}
