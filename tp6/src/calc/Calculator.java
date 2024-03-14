package calc ;
/** Define the notion of calculator, used thanks to a GUI */
public interface Calculator {
    /** Get the current value of this calculator
      * It is this value that is displaid on the calculator screen.
      * @return this calculator's current value
    */
    public int getCurrentValue () ;
    /** press on a digit button
      * @param digit the value corresponding to the pressed digit
    */
    public void pressDigit (int digit) ;
    /** Define what happens when + is pressed */ 
    public void pressPlus () ;
    /** Define what happens when - is pressed  */ 
    public void pressMinus () ;
    /** Define what happens when / is pressed  */ 
    public void pressDiv () ;
    /** Define what happens when x is pressed  */ 
    public void pressMult () ;
    /** Define what happens when = is pressed  */ 
    public void pressEquals () ;
    /** Define what happens when Del is pressed  */ 
    public void pressDel () ;
    /** Define what happens when CC is pressed  */ 
    public void pressClear () ;
    /** Define what happens when ??? is pressed  */ 
    public void pressSuprise () ;
}
