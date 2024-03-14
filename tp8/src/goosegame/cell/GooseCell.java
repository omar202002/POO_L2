package goosegame.cell;

public class GooseCell extends Cell{



    public GooseCell(int index){
        super(index);
    }

    public int bounce(int x){
        return super.bounce(int x) + super.getIndex();
    }



}
