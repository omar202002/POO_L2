package battleship;

import static org.junit.Assert.*;

import org.junit.Test;

public class ShipTest {

  @Test
  public void theShipBeenHitting() {
    Ship s1 = new Ship(3);

    assertEquals(s1.getLifePoints(),3);

    s1.beenHitting();

    assertEquals(s1.getLifePoints(),2);
  }

  @Test
  public void theShipHasBeenSunk() {
    Ship s1 = new Ship(2);

    assertEquals(s1.getLifePoints(),2);

    s1.beenHitting();
    s1.beenHitting();

    assertTrue(s1.hasBeenSunk());
  }

  // ---Pour permettre l'exécution des test----------------------
  public static junit.framework.Test suite() {
     return new junit.framework.JUnit4TestAdapter(battleship.ShipTest.class);
  }
}
