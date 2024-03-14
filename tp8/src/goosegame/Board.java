package goosegame;

/**
 * An abstract class to model boards made of cells. Inheriting board
 * classes must implement the initBoard method
 */
public abstract class Board {
    /**
     * Construct a board defined by a number of cells
     * @param nbOfCells The number of cells in the board. Must be equal
     * or superior to 12
     * @throws IllegalStateException If the number of cells is inferior to 12
     */
    public Board(int nbOfCells) throws IllegalStateException {
        if (nbOfCells < 12) {
            throw new IllegalStateException();
        }
        this.nbOfCells = nbOfCells;
        this.cells = new Cell[nbOfCells + 1];
        this.initBoard();
    }

    /**
     * Return the number of cells in the board
     * @return Number of cells in the board
     */
    public int getNbOfCells() {
        return this.nbOfCells;
    }

    /**
     * Return the cell with the specified index in the board.
     * @param index Index of the cell to get. Must be a number between
     * 0 and the number of cells included
     * @return The cell with the specified index
     * @throws UnknownCellException If the specified cell does not exist
     */
    public Cell getCell(int index) throws UnknownCellException {
        try {
            return this.cells[index];
        }
        catch (ArrayIndexOutOfBoundsException e) {
            throw new UnknownCellException();
        }
    }

    /**
     * Initialize the board with the actual cells
     */
    protected abstract void initBoard();

    /** Number of cells on the board, not including the start cell */
    protected int nbOfCells;

    /** Array of nbOfCells + 1 cells */
    protected Cell[] cells;
}
