package battleship;

import battleship.util.Position;

/**
*class for the sea of the game
*/
public class Sea {
  /** The cells that form thesea */
  private Cell[][] theCells;
  /** The remainings life points of all the ships in the sea*/
  public int remainingLP;
  /**
  *Builds a Sea object with a given number of rows and columns
  *
  *@param nbRows the number of rows of the sea
  *@param nbColumns the number of columns of the sea
  */
  public Sea(int nbRows, int nbColumns) {
    this.theCells = new Cell[nbRows][nbColumns];

    for (int rows = 0 ;rows<this.theCells.length ;rows++ ) {
      for (int columns = 0 ;columns<this.theCells[rows].length ;columns++ ) {
        this.theCells[rows][columns] = new Cell();
      }
    }
     this.remainingLP = 0;
  }

  /**
  * add a ship in the sea
  *
  *@param s the ship we want to add
  *@param p the position at wich we want to add the ship
  */
  public void addShip(Ship s, Position p) {
  /**  Cell c = this.theCells[p.getY()][p.getX()];*/
    if (this.getCell(p).isEmpty()) {
      this.getCell(p).setShip(s);
      this.remainingLP = this.remainingLP + 1;
    }
  }

  /**
  *give the cell of a given position
  *
  *@return the cell of a given position
  */
  public Cell getCell(Position p){
    return this.theCells[p.getY()][p.getX()];
  }

  /**
  * it allows to shoot at a given position
  *
  *@param p the position at wich we want to shoot
  *@return an Answer at the position p that tells us if we hit the ship, sunk it or if we missed.
  *@exception ArrayIndexOutOfBoundsException if the parameter p is not valid
  */
  public Answer shoot(Position p) throws ArrayIndexOutOfBoundsException{

   Cell c = this.getCell(p);
   if ( c.isEmpty()) {
     return c.shot();
   }
   else if (!(c.hasBeenShot())) {
     this.remainingLP = this.remainingLP -1;
     return c.shot();
   }
   else {
     return Answer.MISSED;
   }
  }

  /**
  * give the total of the remainings life points of all remaining ships
  *
  *@return the total of the remainings life points of all remaining ships
  */
  public int getRemainingLifePoints() {
    return this.remainingLP;
  }

  /** display the game board line by line and cell by cell, on standard output,
  * the display is different for the defender or the attacker, according to parameter
  *
  *@param defender true iff display is for defender, false if for opponent
  */
  public void display(boolean defender) {


    System.out.print("   ");
    char letter = 'A';
    System.out.print(letter);
    System.out.print("  ");
    for (int j = 0 ;j<this.theCells[0].length-1 ;j++ ) {
      System.out.print(letter +=1);
      System.out.print("  ");
    }


    System.out.println("");


    for (int i = 0 ;i<this.theCells.length ;i++ ) {

      System.out.print(" ");
      System.out.print(i);
      System.out.print(" ");


      for (int j = 0 ;j<this.theCells[i].length ;j++ ) {

        Cell c = this.theCells[i][j];

        if (j == (this.theCells[i].length - 1)) {
        System.out.println(c.toCharacter(defender));
        }

        else {
          System.out.print(c.toCharacter(defender));
          System.out.print("  ");
        }
      }

    }

  }

  private void testIfShipCanBePlacedVertically(Ship shipToPlace, Position position) throws IllegalStateException{
    int rows = 0;
    Position p;
    if (shipToPlace.getLifePoints() <= (this.theCells.length - position.getY()) || (this.getCell(position).isEmpty())) {
      if (rows<shipToPlace.getLifePoints()) {
        p = new Position(position.getX(),position.getY() + rows);
        rows+=1;
      }
    }
    else {
      throw new IllegalStateException();
    }
  }

  private void testIfShipCanBePlacedHorizontally(Ship shipToPlace, Position position) throws IllegalStateException{
    int columns = 0;
    Position p = position;
    if (shipToPlace.getLifePoints() <= (this.theCells[0].length - position.getX()) || (this.getCell(p).isEmpty())) {
      if (columns<shipToPlace.getLifePoints()) {
        p = new Position(position.getX() + columns,position.getY());
        columns+=1;
      }
    }
    else {
      throw new IllegalStateException();
    }
  }


  /**
  * add the ship b to this game’s sea. Ship is added vertically down from position p.
  * The number of cells is determined by the ship life points.
  *
  *@param shipToPlace the ship to add
  *@param position the position of the first (top) cell occupied by the ship
  *@throws IllegalStateException if the ship b can not be placed on the sea
  * (ship goes outside of the sea or some cell is not empty)
  */
  public void addShipVertically(Ship shipToPlace, Position position) throws IllegalStateException{
    this.testIfShipCanBePlacedVertically(shipToPlace, position);
    Position p;
    for (int rows = 0 ;rows<shipToPlace.getLifePoints() ;rows++ ) {
      this.addShip(shipToPlace, position,0,rows);
    }

  }

  /**
  * add the ship b to this game’s sea. Ship is added horizontally right from position p.
  * The number of cells is determined by the ship life points.
  *
  *@param shipToPlace the ship to add
  *@param position the position of the first (from the left) cell occupied by the ship
  *@throws IllegalStateException if the ship b can not be placed on the sea
  * (ship goes outside of the sea or some cell is not empty)
  */
  public void addShipHorizontally(Ship shipToPlace, Position position) throws IllegalStateException{
    this.testIfShipCanBePlacedHorizontally(shipToPlace, position);
    Position p;
    for (int columns = 0 ;columns<shipToPlace.getLifePoints() ;columns++ ) {
      this.addShip(shipToPlace, position,columns,0);
    }

  }

  /**
  * add the ship to this game's sea. Ship is added on all the variations of the given position
  * the number of cells is determined by the ship life points.
  *
  *@param shipToPlace the ship to place
  *@param position the position of the first cell occupied by the ship
  *@param dx the variation of the given position on the horizontal axe
  *@param dy the variation of the given position on the vertical axe
  *@throws IllegalStateException if the ship b can not be placed on the sea
  * (ship goes outside of the sea or some cell is not empty)
  */
  public void addShip(Ship shipToPlace, Position position, int dx, int dy) throws IllegalStateException {
    Position p = new Position(position.getX() + dx, position.getY() + dy);
    if ( ( (position.getX()+dx) >this.theCells[0].length ) || ( (position.getY()+dy) >this.theCells.length ) || !(this.getCell(p).isEmpty()) ) {
      throw new IllegalStateException();
    }
    else {
      this.addShip(shipToPlace,p);
    }

  }


}
