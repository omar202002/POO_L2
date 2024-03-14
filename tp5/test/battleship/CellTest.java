package battleship;

import static org.junit.Assert.*;

import org.junit.Test;

public class CellTest {
  @Test
  public void testAnswerIsSunkAfterLastShot() {
    Cell c = new Cell();

    Ship s = new Ship(1);

    c.setShip(s);

    Answer a = c.shot();
    assertEquals(Answer.SUNK,a);
    assertTrue(s.hasBeenSunk());
  }

  @Test
  public void testAnswerIsMissedIfCellIsEmpty() {
    Cell c = new Cell();


    Answer a = c.shot();
    assertEquals(Answer.MISSED,a);
  }

  @Test
  public void testAnswerIsHitAfterAShot() {
    Cell c = new Cell();

    Ship s = new Ship(2);
    c.setShip(s);

    Answer a = c.shot();

    assertEquals(Answer.HIT,a);
    assertFalse(s.hasBeenSunk());
  }

  @Test
  public void testSecondToLastAnswerIsHit() {
    Cell c = new Cell();

    Ship s = new Ship(2);
    c.setShip(s);

    Answer a = c.shot();

    assertEquals(Answer.HIT,a);

    Answer b = c.shot();

    assertEquals(Answer.SUNK,b);

    assertTrue(s.hasBeenSunk());
  }

  @Test
  public void testAnswerForDefenderIfCellIsEmpty() {
    Cell c = new Cell();

    char d = c.toCharacter(true);

    assertSame(d,'~');
  }

  @Test
  public void testAnswerForAttackerIfCellIsEmptyAndHasBeenShot() {
    Cell c = new Cell();

    c.shot();

    char a = c.toCharacter(false);

    assertTrue(c.hasBeenShot());
    assertEquals(a,'~');
  }

  @Test
  public void testAnswerIsTheSameForAttackerAndDefenderIfShipInCellHasBeenShot()  {
    Cell c = new Cell();

    Ship s = new Ship(3);
    c.setShip(s);
    c.shot();

    char d = c.toCharacter(true);
    char a = c.toCharacter(false);

    assertTrue(c.hasBeenShot());
    assertEquals(a,'*');
    assertEquals(a,d);
  }

  @Test
  public void testAnswerForDefenderIfShipInCellHasNotBeenShot() {
    Cell c = new Cell();

    Ship s = new Ship(3);
    c.setShip(s);

    char d = c.toCharacter(true);

    assertEquals(d,'B');
  }

  @Test
  public void testAnswerForAttackerIfCellHasNotBeenShot() {
    Cell c = new Cell();

    Ship s = new Ship(3);
    c.setShip(s);

    char a = c.toCharacter(false);

    assertEquals(a,'.');
  }

  // ---Pour permettre l'exécution des test----------------------
  public static junit.framework.Test suite() {
     return new junit.framework.JUnit4TestAdapter(battleship.CellTest.class);
  }
}
