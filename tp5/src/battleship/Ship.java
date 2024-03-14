package battleship;

/**
* class for the Ship
*/
public class Ship {

  /** the life-points of the ship*/
  public int lifePoints;

  /**
  * Builds a ship with a given life-Points wich is equal to it's length
  *
  *@param length the length of the ship
  */
  public Ship(int length) {
    this.lifePoints = length;
  }

  /**
  *Tells if the ship has been sunk or not
  *
  *@return a boolean wich tells if the ship has been sunk or not
  */
  public boolean hasBeenSunk() {
    return this.lifePoints == 0;
  }

  /**
  *lessen the life-points of the ship
  */
  public void beenHitting() {
    this.lifePoints = this.lifePoints -1;
  }

  /**
  *give the life-points of the ship
  *
  *@return the life-points of the ship
  */
  public int getLifePoints() {
    return this.lifePoints;
  }

 /**
 *provide String representation of the Ship Object
 *
 *@return the String representation of the Ship Object
 */
  public String toString() {
    if (this.hasBeenSunk()) {
      return "the ship has been sunk";
    }
    else {
      return "the ship has " + this.getLifePoints() + " life points remaining";
    }
  }

}
