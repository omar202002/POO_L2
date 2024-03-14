package goosegame.cell;

public class TrapCell extends Cell {
  public TrapCell(int index) {
    super(index);
  }

  public boolean canBeLeft() {
    return this.isBusy;
  }
}
