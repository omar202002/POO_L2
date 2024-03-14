package battleship.util;

import static org.junit.Assert.*;

import org.junit.Test;

public class PositionTest {
   
   @Test
   public void initiliizationIsOk() {
      Position pos = new Position(3,5);
      assertEquals(3, pos.getX());
      assertEquals(5, pos.getY());
   }

   @Test
   public void testEqualsWhenEquals() {
      Position pos1 = new Position(3,5);
      Position pos2 = new Position(3,5);
      assertTrue(pos1.equals(pos2));      
   }

   @Test
   public void testEqualsWhenNotEquals() {
      Position pos1 = new Position(3,5);
      Position pos2 = new Position(13,5);
      assertFalse(pos1.equals(pos2));      
      assertFalse(pos1.equals(new String("abc")));      
   }


   // ---Pour permettre l'exécution des test----------------------
   public static junit.framework.Test suite() {
      return new junit.framework.JUnit4TestAdapter(battleship.util.PositionTest.class);
   }
}
