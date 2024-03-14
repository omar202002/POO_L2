package calc;
import calc.ops.*;
import java.util.*;

/**
 * class for the post-fixed calculator
 */

public class PostfixedCalculator implements Calculator {
  /**tells us if we are tapping a new value orb not*/
  private boolean newValue;

  /** a Stack object that contains the numbers that we are tapping on the calculator and the results of the operations too*/
  private Stack<Integer> numbers;

  /** Builds a postfixed calculator */
  public PostfixedCalculator(){
    this.newValue = true;

    this.numbers = new Stack<>();
    this.numbers.push(0);
  }

  /** Get the current value of this calculator
    * It is this value that is displaid on the calculator screen.
    * @return this calculator's current value
  */
  public int getCurrentValue () {
    if (!this.numbers.empty()) {
      return this.numbers.peek();
    }
    return 0;
  }

  /** press on a digit button
    * @param digit the value corresponding to the pressed digit
  */
  public void pressDigit (int digit) {
    if (this.newValue == true) {
      this.numbers.push(digit);
      this.newValue = false;
    }
    else {
      try {
        int n = this.numbers.peek();
        this.numbers.pop();
        this.numbers.push(n*10 + digit);
      }
      catch (EmptyStackException e) {

      }
    }
  }

  /**
  *Define what happens when an Operator is pressed
  *
  *@param operator the operator that is pressed
  */
  public void pressOperator(Operator operator) {
    if (this.numbers.size()>=2) {
      System.out.println(this.numbers.peek());
      int op2 = this.numbers.peek();
      this.numbers.pop();

      System.out.println(this.numbers.peek());
      int op1 = this.numbers.peek();
      this.numbers.pop();

      int ops = operator.compute(op1,op2);
      this.numbers.push(ops);
    }
    this.newValue = true;
  }

  /** Define what happens when = is pressed  */
  public void pressEquals () {
    if (!this.newValue) {
      this.newValue = true;
    }
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

  /** Define what happens when Del is pressed  */
  public void pressDel () {
    if(!this.newValue){
    int peek = this.numbers.peek();
    this.numbers.pop();
    this.numbers.push(peek);
  }
  }

  /** Define what happens when CC is pressed  */
  public void pressClear () {
    this.newValue = true;

    this.numbers = new Stack<>();
    this.numbers.push(0);
  }

  /** Define what happens when ??? is pressed  */
  public void pressSuprise () {
    this.pressOperator(new Surprise());
  }


}
