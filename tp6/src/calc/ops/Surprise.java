package calc.ops;

public class Surprise implements Operator {
  public int compute(int op1,int op2){
    return op1 % op2;
  }
}
