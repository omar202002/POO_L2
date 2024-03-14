package displayer;

/**
 * A SpeedDisplayer diplays a message on a screen of limited width with a certain latency and speed.
 * Message can scroll to be displaid char by char.
 */

public class SpeedDisplayer extends DisplayerWithLatency {

  /**the speed of the message*/
  private int speed;

  /**
   * build a displayer with a screen of width characters, a given latency and speed
   * @param width this displayer's width
   *@param latency the latency between the first and last character of the message
   *@param speed the speed of the displayer
   */
  public SpeedDisplayer(int width, int latency, int speed) {
    super(width, latency);
    this.speed = speed;
  }

  /** shift message by one character : first character on the left disappears,
   * next character from message is added on the right
  */
  public void shift() {
     for (int i = 0; i<speed ;i++ ) {
       super.shift();
     }
  }
}
