package battleship;

/**
* class for one cell of the game
*/
public class Cell {

  /** the ship */
  private Ship ship;
  /** a boolean wich allows us to know if the cell has been shot or not */
  private boolean shot;

  /**
  * Builds a cell
  */
  public Cell() {
    this.shot = false;
  }

  /**
  * return this.ship
  *
  *@return this.ship
  */
  public Ship getShip() {
    return this.ship;
  }

  /**
  * set a ship
  *
  *@param ship the ship that is setted
  */
  public void setShip(Ship ship) {
    this.ship = ship;
  }

  /**
  * tells if the cell is empty or not
  *
  *@return true if the cell is empty and false if not
  */
  public boolean isEmpty() {
    return this.ship == null;
  }

  /**
  *tells if the cell has been shot or not
  *
  *@return a boolean that wich says if the cell has been shot not
  */
  public boolean hasBeenShot() {
    return this.shot == true;
  }

  /**
  * Tells what happenned after shooting a Cell. THe Answer could be MISSED, HIT or SUNK the boat's lifepoints is equal to zero.
  *
  * @return an Answer that tells us what happenned ofter shooting a Cell
  */
  public Answer shot() {
    if(this.isEmpty()) {
      this.shot = true;
      return Answer.MISSED;
    }
    else {

      if (!(this.ship.hasBeenSunk())) {
        this.shot = true;
        this.ship.beenHitting();
        if (this.ship.hasBeenSunk()) {
          return Answer.SUNK;
        }
        else {
          return Answer.HIT;
        }
      }

      else {
        return Answer.MISSED;
      }

    }
  }

  /**
  * Give some infos about the state of the case from the defender's or the attacker's point of view
  * Depending on if the cell has been shot or not
  *
  *@param defender the point of view of the defender (defender=true) or the attacker(defender=false)
  *
  *@return some infos about the state of the case from the defender's or the attacker's point of view
  */
  public char toCharacter(boolean defender) {

    if (defender == true) {
      if (this.isEmpty()) {
        return '~';
      }
      else if (!(this.hasBeenShot())) {
        return 'B';
      }
      else {
        return '*';
      }
    }

    else {

      if (!(this.hasBeenShot())) {
        return '.';
      }
      else if (this.isEmpty()) {
        return '~';
      }
      else {
        return '*';
      }
    }
  }

}
