package goosegame.cell;;

public class TeleportCell extends Cell {
  protected int jumpCell;

  public TeleportCell(int index, int jumpCell) {
    super(index);
    this.jumpCell = jumpCell;
  }

  public int bounce(int x) {
    return jumpCell;
  }
}
