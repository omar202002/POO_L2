package calc;
import calc.gui.CalculatorView;

public class PostfixedMain {
  public static void main(String[] args) {
    Calculator c = new PostfixedCalculator();
    CalculatorView calc = new CalculatorView(c);
    calc.run();
  }
}
