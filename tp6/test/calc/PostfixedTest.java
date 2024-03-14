package calc;
import calc.ops.*;

import static org.junit.Assert.*;

import org.junit.Test;

public class PostfixedTest {
  @Test
  public void testMinusValue() {
    PostfixedCalculator inf  = new PostfixedCalculator();
    inf.pressDigit(4);
    inf.pressEquals();
    inf.pressDigit(5);
    inf.pressOperator(new Minus());
    assertEquals(inf.getCurrentValue(),-1);
  }

  @Test
  public void testPlusValue() {
    PostfixedCalculator inf  = new PostfixedCalculator();
    inf.pressDigit(4);
    inf.pressEquals();
    inf.pressDigit(5);
    inf.pressOperator(new Plus());
    assertEquals(inf.getCurrentValue(),9);
  }

  @Test
  public void testMultValue() {
    PostfixedCalculator inf  = new PostfixedCalculator();
    inf.pressDigit(4);
    inf.pressEquals();
    inf.pressDigit(5);
    inf.pressOperator(new Mult());
    assertEquals(inf.getCurrentValue(),20);
  }

  @Test
  public void testDivValue() {
    PostfixedCalculator inf  = new PostfixedCalculator();
    inf.pressDigit(4);
    inf.pressEquals();
    inf.pressDigit(5);
    inf.pressOperator(new Div());
    assertEquals(inf.getCurrentValue(),0);
  }

  @Test
  public void testSurpriseValue() {
    PostfixedCalculator inf  = new PostfixedCalculator();
    inf.pressDigit(4);
    inf.pressEquals();
    inf.pressDigit(5);
    inf.pressOperator(new Surprise());
    assertEquals(inf.getCurrentValue(),4);
  }

  @Test
  public void testWithTreeOperands() {
    PostfixedCalculator inf  = new PostfixedCalculator();
    inf.pressDigit(1);
    inf.pressEquals();
    inf.pressDigit(2);
    inf.pressEquals();
    inf.pressDigit(3);
    inf.pressOperator(new Mult());
    inf.pressOperator(new Plus());
    assertEquals(inf.getCurrentValue(),7);
  }

  @Test
  public void testWithTreeOtherOperands() {
    PostfixedCalculator inf  = new PostfixedCalculator();
    inf.pressDigit(1);
    inf.pressEquals();
    inf.pressDigit(2);
    inf.pressOperator(new Plus());
    inf.pressDigit(3);
    inf.pressOperator(new Minus());
    assertEquals(inf.getCurrentValue(),0);
  }




  // ---Pour permettre l'exécution des test----------------------
  public static junit.framework.Test suite() {
     return new junit.framework.JUnit4TestAdapter(calc.PostfixedTest.class);
  }
}
