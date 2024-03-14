package battleship;

import battleship.util.Position;

public class FirstBattleShipMain {

  public static void main(String[] args) {
    Sea sea = new Sea(10,10);

    Ship s1 = new Ship(1);
    Ship s2 = new Ship(2);

    Position p1 = new Position(2,3);
    Position p2 = new Position(4,5);
    Position p3 = new Position(4,6);

    sea.addShip(s1,p1);
    sea.addShip(s2,p2);
    sea.addShip(s2,p3);


    System.out.println("               First game board                    ");
    System.out.println("---------------------------------------------------");
    sea.display(true);
    System.out.println("-------------");
    sea.display(false);
    System.out.println("----------------------------------------");
    System.out.println("");
    System.out.println("");


    sea.shoot(p1);

    System.out.println("total life points  = " + sea.getRemainingLifePoints());
    System.out.println("            Second game board           ");
    System.out.println("---------------------------------------------------");
    sea.display(true);
    System.out.println("-------------");
    sea.display(false);

  }

}
