package displayer;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SpeedDisplayerTest {

  private static final int WIDTH = 5;
  private static final String MESSAGE = "abcd";

  protected SpeedDisplayer displayer;

  @Before  // => la méthode init() est exécutée avant chaque méthode de test
  public void init() {
     this.displayer = new SpeedDisplayer(WIDTH,3,2);
  }


    @Test
    public void testShift() {
       this.displayer.setMessage(MESSAGE);
       assertEquals("     ", this.displayer.textOnScreen());
       this.displayer.shift();
       assertEquals("   ab", this.displayer.textOnScreen());
       this.displayer.shift();
       assertEquals(" abcd", this.displayer.textOnScreen());
       this.displayer.shift();
       assertEquals("bcd  ", this.displayer.textOnScreen());
       this.displayer.shift();
       assertEquals("d   a", this.displayer.textOnScreen());
       this.displayer.shift();
       assertEquals("  abc", this.displayer.textOnScreen());
       this.displayer.shift();
       assertEquals("abcd ", this.displayer.textOnScreen());
       this.displayer.shift();
       assertEquals("cd   ", this.displayer.textOnScreen());
       this.displayer.shift();
       assertEquals("   ab", this.displayer.textOnScreen());
    }



  // ---Pour permettre l'execution des tests ----------------------
  public static junit.framework.Test suite() {
     return new junit.framework.JUnit4TestAdapter(displayer.SpeedDisplayerTest.class);
  }
}
