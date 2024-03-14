package battleship;

import static org.junit.Assert.*;

import org.junit.Test;

import battleship.util.Position;

public class SeaTest {

  @Test
  public void testIfAShipsIsAddedInTheSea() {
    Sea s = new Sea(4,4);

    Ship s1 = new Ship(2);
    Position p = new Position(2,3);

    s.addShip(s1,p);
    assertFalse(s.getCell(p).isEmpty());
  }


  @Test
  public void testAnswerIsSunkAfterLastShot() throws ArrayIndexOutOfBoundsException {
    Sea sea = new Sea(4,4);

    Ship s1 = new Ship(1);
    Position p = new Position(2,3);

    sea.addShip(s1,p);

    Answer a = sea.shoot(p);
    assertEquals(Answer.SUNK,a);
    assertTrue(s1.hasBeenSunk());
  }

  @Test
  public void testAnswerIsMissedIfCellIsEmpty() throws ArrayIndexOutOfBoundsException {
    Sea sea = new Sea(4,4);


    Position p = new Position(2,3);

    Answer a = sea.shoot(p);
    assertEquals(Answer.MISSED,a);
  }

  @Test
  public void testAnswerIsHitAfterAShot() throws ArrayIndexOutOfBoundsException {
    Sea sea = new Sea(4,4);

    Ship s = new Ship(2);
    Position p = new Position(2,3);
    Position p1 = new Position(1,3);

    sea.addShip(s,p);
    sea.addShip(s,p1);

    Answer a = sea.shoot(p);

    assertEquals(Answer.HIT,a);
    assertFalse(s.hasBeenSunk());
  }

  @Test
  public void testSecondToLastAnswerIsHit() throws ArrayIndexOutOfBoundsException {
    Sea sea = new Sea(4,4);

    Ship s = new Ship(2);
    Position p = new Position(2,3);
    Position p1 = new Position(1,3);
    sea.addShip(s,p);
    sea.addShip(s,p1);

    Answer a = sea.shoot(p);

    assertEquals(Answer.HIT,a);

    Answer b = sea.shoot(p1);

    assertEquals(Answer.SUNK,b);

    assertTrue(s.hasBeenSunk());
  }

  @Test(expected=ArrayIndexOutOfBoundsException.class)
  public void testException() throws ArrayIndexOutOfBoundsException {
    Sea sea = new Sea(4,4);

    Ship s = new Ship(2);
    Position p = new Position(2,8);
    sea.addShip(s,p);
  }

  @Test
  public void testTheRemaningLifePointsAfterAShot() throws Exception {
    Sea sea = new Sea(6,6);

    Ship s1 = new Ship(1);
    Position p1 = new Position(2,3);

    Ship s2 = new Ship(2);
    Position p2 = new Position(3,1);
    Position p3 = new Position(3,2);

    sea.addShip(s1,p1);
    sea.addShip(s2,p2);
    sea.addShip(s2,p3);

    assertEquals(sea.getRemainingLifePoints(),3);

    sea.shoot(p3);
    sea.shoot(p1);

    assertEquals(sea.getRemainingLifePoints(),1);

  }

  @Test(expected = IllegalStateException.class)
  public void testIfShipCanBePlacedVerticallyException() throws IllegalStateException {
    Sea sea = new Sea(4,10);
    Ship s = new Ship(6);
    //Ship s1 = new Ship(1);


    Position p = new Position(0,0);
    //sea.addShip(s1,p);
    sea.addShipVertically(s,p);
  }

  @Test
  public void testIfShipCanBePlacedVertically() throws IllegalStateException {
    Sea sea = new Sea(10,10);
    Ship s = new Ship(3);

    Position p = new Position(0,0);
    Position p1 = new Position(0,1);
    Position p2 = new Position(0,2);

    sea.addShipVertically(s,p);

    Answer a = sea.shoot(p);
    assertEquals(a,Answer.HIT);

    Answer b = sea.shoot(p);
    assertEquals(b,Answer.MISSED);

    sea.shoot(p1);
    Answer c = sea.shoot(p2);
    assertEquals(c,Answer.SUNK);

  }

  @Test(expected = IllegalStateException.class)
  public void testIfShipCanBePlacedHorizontallyException() throws IllegalStateException {
    Sea sea = new Sea(10,4);
    Ship s = new Ship(6);


    Position p = new Position(0,0);

    sea.addShipHorizontally(s,p);
  }

  @Test
  public void testIfShipCanBePlacedHorizontally() throws IllegalStateException {
    Sea sea = new Sea(10,10);
    Ship s = new Ship(3);

    Position p = new Position(0,0);
    Position p1 = new Position(1,0);
    Position p2 = new Position(2,0);

    sea.addShipHorizontally(s,p);

    Answer a = sea.shoot(p);
    assertEquals(a,Answer.HIT);

    Answer b = sea.shoot(p);
    assertEquals(b,Answer.MISSED);

    sea.shoot(p1);
    Answer c = sea.shoot(p2);
    assertEquals(c,Answer.SUNK);

  }




  // ---Pour permettre l'exécution des test----------------------
  public static junit.framework.Test suite() {
     return new junit.framework.JUnit4TestAdapter(battleship.SeaTest.class);
  }
}
