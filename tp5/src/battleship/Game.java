package battleship;

import battleship.util.Position;

import io.Input;

/**class fot the entire game*/
public class Game {

  /** A sea Object that represent the sea of the Game*/
  public Sea sea;

  /**
  * Builds a Game with a given sea Object
  *
  *@param sea A sea Object that represent the sea of the Game
  */
  public Game(Sea sea){
    this.sea = sea;
  }

  /**
  * Allows us to play the game that  will only be finished if the total life points is equal to zero
  * The defender point of view will be shown one time whereas the attacker point of view will be shown until the game ends.
  * And we will be asked the position of the cell that we want to shoot until the game ends
  */
  public void play(){
    while (this.sea.getRemainingLifePoints()!=0) {
      this.sea.display(false);
      Position position = this.inputPosition();
      Answer a = this.sea.shoot(position);
      System.out.println(a);
    }

  }

  /**
  * Returns this.sea
  *
  *@return The sea of the game
  */
  public Sea getSea(){
    return this.sea;
  }


  /**
  * Show some instructions that tells us to precise the the position of the cell that we want to shoot then
  *returns that position
  *
  *@return the positionof the cell that we want to shoot
  */
  private Position inputPosition() {
    // example for String input
    System.out.print(" enter  a String : ? ");
    String userString = Input.readString();
    String upperCaseString = userString.toUpperCase();

    char firstLetter = upperCaseString.charAt(0);

    // example for int input
    System.out.println("enter an int => " + userString);
    int userInt;
    try {
       System.out.print(" give an int : ? ");
       userInt = Input.readInt();
       System.out.println("read int => " + userInt);
    } catch (java.io.IOException e) {
       // "exception... : input does not correspond to an integer
       // here we _arbitrarily choose_ to provide 0 as default value
       userInt = 0;
       System.out.println("corrected value  => " + userInt);
    }
    System.out.println(" value  (read or corrected) => " + userInt);
    Position p = new Position(firstLetter-65,userInt);

    return p;

  }


}
