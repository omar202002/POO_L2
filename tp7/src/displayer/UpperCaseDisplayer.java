package displayer;

/**
 * A UpperCaseDisplayer diplays a message on a screen of limited width with all characters that are capitalized.
 * Message can scroll to be displaid char by char.
 */

public class UpperCaseDisplayer extends LedDisplayer {

  /**
   * build a displayer with a screen of width characters
   * @param width this displayer's width
   */
  public UpperCaseDisplayer(int width) {
    super(width);
  }

  /**
   * set the new message to display, a call to textOnScreen() is now blank until next shift()
   * First character (witch is capitalized) of message will enter on the right at next shift() .
   *
   * @param message the new message
   */
  public void setMessage(String message) {
    super.setMessage(message.toUpperCase());
  }
}
