package goosegame.cell;

public class WaitingCell extends Cell{
    protected int nbTurn;
    protected int count;

    public WaitingCell(int index, int nbTurn){
        super(index);
        this.nbTurn= nbTurn;
        this.count = 0;
    }

    public boolean canBeLeft(){
        this.count++;
        if (this.count == this.nbTurn){
            this.count = 0;
            return true;
        }
        return false;

    }
}
