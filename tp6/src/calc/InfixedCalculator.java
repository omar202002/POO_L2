package calc;
import calc.ops.*;

/**
 * class for the infixed calculator
 */

public class InfixedCalculator implements Calculator {
  private Operator operator;
  private int previousValue;
  private int currentValue;
  private boolean newValue;

  public InfixedCalculator() {
    this.previousValue = 0;
    this.currentValue = 0;
    this.operator = null;
    this.newValue = true;
  }

  /** Get the current value of this calculator
    * It is this value that is displaid on the calculator screen.
    * @return this calculator's current value
  */
  public int getCurrentValue () {
    return this.currentValue;
  }

  /** press on a digit button
    * @param digit the value corresponding to the pressed digit
  */
  public void pressDigit (int digit) {
    if (this.newValue == true) {
      this.currentValue = digit;
      this.newValue = false;
    }
    else {
      this.currentValue = (this.currentValue*10) + digit;
    }
  }

  /**
  *Define what happens when an Operator is pressed
  *
  *@param operator the operator that is pressed
  */
  public void pressOperator(Operator operator){
    if (this.operator != null && this.newValue==false) {
      this.currentValue = this.operator.compute(this.previousValue,this.currentValue);
    }
    this.operator = operator;
    this.previousValue = this.currentValue;
    //this.currentValue = 0;
    this.newValue = true;
  }

  /** Define what happens when + is pressed */
  public void pressPlus () {
    this.pressOperator(new Plus());
  }

  /** Define what happens when - is pressed  */
  public void pressMinus () {
    this.pressOperator(new Minus());
  }

  /** Define what happens when / is pressed  */
  public void pressDiv () {
    this.pressOperator(new Div());
  }

  /** Define what happens when x is pressed  */
  public void pressMult () {
    this.pressOperator(new Mult());
  }

  /** Define what happens when = is pressed  */
  public void pressEquals () {
    if (this.operator != null) {
      try {
        this.currentValue = this.operator.compute(previousValue, currentValue);
        this.operator=null;
      } catch(ArithmeticException e) {
        this.currentValue=0;
        this.previousValue=0;
        this.operator=null;
      }
    }
  }
  /** Define what happens when Del is pressed  */
  public void pressDel () {
    this.currentValue = this.currentValue / 10;
  }
  /** Define what happens when CC is pressed  */
  public void pressClear () {
    this.previousValue = 0;
    this.currentValue = 0;
  }
  /** Define what happens when ??? is pressed  */
  public void pressSuprise () {
    this.pressOperator(new Surprise());
  }
}
