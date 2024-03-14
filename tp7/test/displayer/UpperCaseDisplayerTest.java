package displayer;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class UpperCaseDisplayerTest {

  private static final int WIDTH = 4;
  private static final String MESSAGE = "abc";

  protected UpperCaseDisplayer displayer;

  @Before  // => la méthode init() est exécutée avant chaque méthode de test
  public void init() {
     this.displayer = new UpperCaseDisplayer(WIDTH);
  }

  @Test
  public void testShift() {
     this.displayer.setMessage(MESSAGE);
     assertEquals("    ", this.displayer.textOnScreen());
     this.displayer.shift();
     assertEquals("   A", this.displayer.textOnScreen());
     this.displayer.shift();
     assertEquals("  AB", this.displayer.textOnScreen());
     this.displayer.shift();
     assertEquals(" ABC", this.displayer.textOnScreen());
     this.displayer.shift();
     assertEquals("ABCA", this.displayer.textOnScreen());
  }



  // ---Pour permettre l'execution des tests ----------------------
  public static junit.framework.Test suite() {
     return new junit.framework.JUnit4TestAdapter(displayer.UpperCaseDisplayerTest.class);
  }
}
