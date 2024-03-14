package displayer;

/**
 * A DisplayerWithLatency diplays a message on a screen of limited width and a latency between the first and the last
 * character of the message. 
 * Message can scroll to be displaid char by char.
 */

public class DisplayerWithLatency extends LedDisplayer {

  /**the latency of the message*/
  private int latency;

  /**
  * build a displayer with a screen of width characters and a given latency
  *@param width this displayer's width
  *@ param latency the latency of the displayer
  */
  public DisplayerWithLatency(int width, int latency) {
    super(width);
    this.latency = latency;
  }

  /**
   * set the new message to display, a call to textOnScreen() is now blank until next shift()
   * First character of message will enter on the right at next shift() .
   *
   * @param message the new message
   */
  public void setMessage(String message) {
    String spaces = "";
    for(int i = 0; i<this.latency; i++) {
      spaces += " ";
    }
    super.setMessage(message + spaces);
  }
}
