package displayer;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LeftRightDisplayerTest {

  private static final int WIDTH = 5;
  private static final String MESSAGE = "abcd";

  protected LeftRightDisplayer displayer;

  @Before  // => la méthode init() est exécutée avant chaque méthode de test
  public void init() {
     this.displayer = new LeftRightDisplayer(WIDTH);
  }

  @Test
  public void testShift() {
     this.displayer.setMessage(MESSAGE);
     assertEquals("     ", this.displayer.textOnScreen());
     this.displayer.shift();
     assertEquals("a    ", this.displayer.textOnScreen());
     this.displayer.shift();
     assertEquals("ba   ", this.displayer.textOnScreen());
     this.displayer.shift();
     assertEquals("cba  ", this.displayer.textOnScreen());
     this.displayer.shift();
     assertEquals("dcba ", this.displayer.textOnScreen());
     this.displayer.shift();
     assertEquals("adcba", this.displayer.textOnScreen());
     this.displayer.shift();
     assertEquals("badcb", this.displayer.textOnScreen());
     this.displayer.shift();
     assertEquals("cbadc", this.displayer.textOnScreen());
     this.displayer.shift();
     assertEquals("dcbad", this.displayer.textOnScreen());
  }



  // ---Pour permettre l'execution des tests ----------------------
  public static junit.framework.Test suite() {
     return new junit.framework.JUnit4TestAdapter(displayer.LeftRightDisplayerTest.class);
  }
}
