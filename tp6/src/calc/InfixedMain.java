package calc;
import calc.gui.CalculatorView;

public class InfixedMain {
  public static void main(String[] args) {
    Calculator c = new InfixedCalculator();
    CalculatorView calc = new CalculatorView(c);
    calc.run();
  }
}
