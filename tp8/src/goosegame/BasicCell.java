package goosegame;

public class BasicCell {
  protected int index;
  protected boolean busy;

  public int Cell(int index) {
    this.index = index;
    this.busy = false;
  }

  public boolean canBeLeft() {
    return true;
  }

  public boolean isBusy() {
    return this.busy;
  }

  public void setBusy(boolean busy) {
    this.busy = busy;
  }

  public int getIndex() {
    return this.index;
  }

  public int bounce(int x) {
    return x;
  }
}
