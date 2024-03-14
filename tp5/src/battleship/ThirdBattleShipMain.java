package battleship;
import battleship.util.Position;
import io.Input;

public class ThirdBattleShipMain {

  public static void main(String[] args) {
    Sea  sea = new Sea(10,10);

    Ship s1 = new Ship(5);
    Ship s2 = new Ship(3);
    Ship s3 = new Ship(4);

    Position p1 = new Position(0,0);
    Position p2 = new Position(3,2);
    Position p3 = new Position(5,4);

    sea.addShipVertically(s1, p1);
    sea.addShipHorizontally(s2,p2);
    sea.addShipVertically(s3, p3);

    System.out.println("               New game board                    ");
    System.out.println("---------------------------------------------------");
    sea.display(true);


    Game game = new Game(sea);
    game.play();

  }

}
