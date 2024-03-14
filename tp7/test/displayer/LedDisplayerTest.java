package displayer;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LedDisplayerTest {

   private static final int WIDTH = 4;
   private static final String MESSAGE = "abc";

   protected LedDisplayer displayer;

   @Before  // => la méthode init() est exécutée avant chaque méthode de test
   public void init() {
      this.displayer = new LedDisplayer(WIDTH);      
   }

   @Test
   public void testInitialization() {
      assertEquals(WIDTH, this.displayer.getScreenWidth());
      assertEquals("", this.displayer.getMessage());
   }

   @Test
   public void testGetScreenWidth() {
      assertEquals(WIDTH, this.displayer.getScreenWidth());
   }

   @Test
   public void testSetMessage() {   
      this.displayer.setMessage(MESSAGE);
      assertEquals(MESSAGE, this.displayer.getMessage());
      // check textOnScreen is reset with WIDTH white spaces
      String whiteSpaces = "";
      for(int i = 0; i < WIDTH; i++) {
         whiteSpaces = whiteSpaces + " ";
      }
      assertEquals(whiteSpaces, this.displayer.textOnScreen());
   }

   @Test
   public void testShift() {      
      this.displayer.setMessage(MESSAGE);
      assertEquals("    ", this.displayer.textOnScreen());
      this.displayer.shift();
      assertEquals("   a", this.displayer.textOnScreen());
      this.displayer.shift();
      assertEquals("  ab", this.displayer.textOnScreen());
      this.displayer.shift();
      assertEquals(" abc", this.displayer.textOnScreen());
      this.displayer.shift();
      assertEquals("abca", this.displayer.textOnScreen());
   }

   // ---Pour permettre l'execution des tests ----------------------
   public static junit.framework.Test suite() {
      return new junit.framework.JUnit4TestAdapter(displayer.LedDisplayerTest.class);
   }

}
