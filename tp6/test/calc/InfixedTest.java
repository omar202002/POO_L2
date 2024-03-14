package calc;
import calc.ops.*;

import static org.junit.Assert.*;

import org.junit.Test;

public class InfixedTest {
  @Test
  public void testMinusValue() {
    InfixedCalculator inf  = new InfixedCalculator();
    inf.pressDigit(5);
    inf.pressDigit(0);
    inf.pressOperator(new Minus());
    inf.pressDigit(5);
    inf.pressEquals();
    assertEquals(inf.getCurrentValue(),45);
  }

  @Test
  public void testPlusValue() {
    InfixedCalculator inf  = new InfixedCalculator();
    inf.pressDigit(5);
    inf.pressDigit(0);
    inf.pressOperator(new Plus());
    inf.pressDigit(5);
    inf.pressEquals();
    assertEquals(inf.getCurrentValue(),55);
  }

  @Test
  public void testMultValue() {
    InfixedCalculator inf  = new InfixedCalculator();
    inf.pressDigit(5);
    inf.pressDigit(0);
    inf.pressOperator(new Mult());
    inf.pressDigit(5);
    inf.pressEquals();
    assertEquals(inf.getCurrentValue(),250);
  }

  @Test
  public void testDivValue() {
    InfixedCalculator inf  = new InfixedCalculator();
    inf.pressDigit(5);
    inf.pressDigit(0);
    inf.pressOperator(new Div());
    inf.pressDigit(5);
    inf.pressEquals();
    assertEquals(inf.getCurrentValue(),10);
  }

  @Test
  public void testSurpriseValue() {
    InfixedCalculator inf  = new InfixedCalculator();
    inf.pressDigit(5);
    inf.pressDigit(0);
    inf.pressOperator(new Surprise());
    inf.pressDigit(5);
    inf.pressEquals();
    assertEquals(inf.getCurrentValue(),0);
  }

  @Test
  public void testSuccessiveOperands() {
    InfixedCalculator inf  = new InfixedCalculator();
    inf.pressDigit(1);
    inf.pressOperator(new Plus());
    inf.pressDigit(2);
    inf.pressOperator(new Mult());
    inf.pressDigit(3);
    inf.pressOperator(new Minus());
    inf.pressDigit(5);
    inf.pressEquals();
    assertEquals(inf.getCurrentValue(),4);
  }

  @Test
  public void testSuccessiveOperators() {
    InfixedCalculator inf  = new InfixedCalculator();
    inf.pressDigit(2);
    inf.pressOperator(new Plus());
    inf.pressOperator(new Mult());
    inf.pressDigit(6);
    inf.pressEquals();
    assertEquals(inf.getCurrentValue(),12);
  }


  // ---Pour permettre l'exécution des test----------------------
  public static junit.framework.Test suite() {
     return new junit.framework.JUnit4TestAdapter(calc.InfixedTest.class);
  }
}
