package goosegame;

import java.util.*;

/**
 * A class to model a game of goose game
 */
public class Game {
    /**
     * Construct a game object defined by its board
     * @param board The board to use in this game
     */
    public Game(Board board) {
        this.players = new ArrayList<Player>();
        this.currentPlayerIndex = 0;
        this.board = board;
    }

    /**
     * Add a new player to the game. If a player arrives mid-game, he will
     * be able to play as the last player on the next round
     * @param player New player to add
     * @throws UnknownCellException If the board used has no cell
     */
    public void addPlayer(Player player)
        throws UnknownCellException {
        this.players.add(player);
        this.board.getCell(0).welcomePlayer(player);
        player.setCell(this.board.getCell(0));
    }

    /**
     * Play a full game of goose game and display the name of the winner
     * @throws NoPlayerException If there is no player to play
     * @throws UnknownCellException If a player reaches a non-existing
     * cell during a turn
     */
    public void play()
        throws NoPlayerException, UnknownCellException {
        Player player;

        do {
            player = this.nextPlayer();
            this.displayPreTurn(player);
        } while (!this.manageTurn(player));

        this.displayWinner(player);
    }

    /**
     * Handle a single turn of a player. Return <code>true</code> if and
     * only if he won
     * @param player The player whose turn it is
     * @return <code>true</code> if the player won, else <code>false</code>
     * @throws UnknownCellException If the player reaches a non-existing
     * cell during his turn
     */
    protected boolean manageTurn(Player player)
        throws UnknownCellException {
        boolean won = false;

        if (this.canPlay(player)) {
            Cell reachedCell = this.play(player);
            this.movePlayer(player, reachedCell);
            won = (reachedCell.getIndex() == this.board.getNbOfCells());
        }
        else {
            this.displayPlayerCannotPlay(player);
        }
        System.out.println();

        return won;
    }

    /**
     * Handle the dice throw and return the cell the player should reach
     * @param player The player whose turn is is
     * @return The cell the player should reach after his dice throw,
     * including the potential bounce effect
     * @throws UnknownCellException If the player reached a non-existing cell
     */
    protected Cell play(Player player)
        throws UnknownCellException {
        int diceThrow = player.twoDiceThrow();
        this.displayDiceThrow(player, diceThrow);
        Cell start = player.getCell();

        Cell inter = this.board.getCell(this.findIndex(start.getIndex(), diceThrow));
        this.displayReached(inter);
        int bounceAmount = inter.bounce(diceThrow);
        Cell end = this.board.getCell(this.findIndex(inter.getIndex(), bounceAmount));
        this.displayBounce(bounceAmount, end);

        return end;
    }

    /**
     * Handle the player movement to a new cell, including the movement of
     * a potential player already in the cell
     * @param player The player whose turn it is
     * @param reachedCell The cell the player should reach
     */
    protected void movePlayer(Player player, Cell reachedCell) {
        // initial cell receives the player from the cell reached
        player.getCell().welcomePlayer(reachedCell.getPlayer());

        // display send back mechanism (with welcomePlayer already done, so
        // that the waiting time has reinitialized in case of a waiting cell)
        this.displaySendBack(reachedCell, player);

        // if the cell reached contained a player, assign the initial cell
        // to this player
        if (reachedCell.getPlayer() != null) {
            reachedCell.getPlayer().setCell(player.getCell());
        }

        // assign the moving player to the reached cell
        reachedCell.welcomePlayer(player);

        // assign the reached cell to the moving player
        player.setCell(reachedCell);
    }

    /**
     * Return a reference to the next player in the list of players
     * @return The next player
     * @throws NoPlayerException If there is no next player
     */
    protected Player nextPlayer() throws NoPlayerException {
        // Didn't use an iterator, to avoid having to deal with the
        // case where a new player enters mid-game (structural modification
        // of the list of players)
        Player next;
        try {
            next = this.players.get(this.currentPlayerIndex);
        }
        catch (IndexOutOfBoundsException e) {
            throw new NoPlayerException();
        }

        ++this.currentPlayerIndex;
        if (this.currentPlayerIndex == this.players.size()) {
            this.currentPlayerIndex = 0;
        }

        return next;
    }

    /**
     * Return <code>true</code> if and only if the specified player can play
     * @param player A player to check for the right to play
     * @return <code>true</code> if the player can play, else <code>false</code>
     */
    protected boolean canPlay(Player player) {
        return player.getCell().canBeLeft();
    }

    /**
     * Display the name of the player, followed by the cell occupied
     * @param player The player whose turn it is
     */
    protected void displayPreTurn(Player player) {
        System.out.print(player + " is in " + player.getCell() + ", ");
    }

    /**
     * Display the result of the dice throw
     * @param player The player throwing the dice
     * @param diceThrow The result of the dice throw
     */
    protected void displayDiceThrow(Player player, int diceThrow) {
        System.out.print(player + " throws " + diceThrow + " ");
    }

    /**
     * Display the cell reached (before bounce)
     * @param cell Cell reached
     */
    protected void displayReached(Cell cell) {
        System.out.print("and reaches " + cell + " ");
    }

    /**
     * Display the cell reached after bounce (only if a non null bounce occured)
     * @param bounceAmount The size of the bounce performed
     * @param cell Cell reached
     */
    protected void displayBounce(int bounceAmount, Cell cell) {
        if (bounceAmount != 0) {
            System.out.print("and jumps to " + cell + " ");
        }
    }

    /**
     * Display the exchange of places between players when one reaches
     * an already occupied cell (only if such an exchange occured)
     * @param reachedCell The occupied cell on which a new player is arriving
     * @param arriving The arriving player
     */
    protected void displaySendBack(Cell reachedCell, Player arriving) {
        // Display only if the arriving cell is busy, and is occupied
        // by a different player than the one arriving
        if (reachedCell.isBusy() && reachedCell.getPlayer() != arriving) {
            System.out.print("cell is busy, " + reachedCell.getPlayer() +
                             " is sent to " + arriving.getCell());
        }
    }

    /**
     * Display when a player cannot play
     * @param player A player who cannot play
     */
    protected void displayPlayerCannotPlay(Player player) {
        System.out.print(player + " cannot play");
    }

    /**
     * Display when a player has won
     * @param winner The winning player
     */
    protected void displayWinner(Player winner) {
        System.out.println(winner + " has won");
    }

    /**
     * Return the index of the reached cell after a dice throw, taking into
     * account the "bounce back" effect of reaching the end of the board
     * without landing exactly in the last cell
     * @param currentIndex Index of the cell the player currently is in
     * @param diceThrow Result of the dice throw
     * @return Index of the cell of arrival
     */
    protected int findIndex(int currentIndex, int diceThrow) {
        if (currentIndex + diceThrow > this.board.getNbOfCells()) {
            return 2 * this.board.getNbOfCells() - currentIndex - diceThrow;
        } else {
            return currentIndex + diceThrow;
        }
    }

    /**
     * List of players currently in the game
     */
    protected List<Player> players;

    /**
     * Index of the player whose turn it is next
     */
    protected int currentPlayerIndex;

    /**
     * Board of the game
     */
    protected Board board;
}
