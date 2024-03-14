package displayer;

/**
 * A LedDisplayer diplays a message on a screen of limited width.
 * Message can scroll to be displaid char by char.
 */

public class LeftRightDisplayer extends LedDisplayer {

  public LeftRightDisplayer(int width) {
    super(width);
  }

  /**
   * return the reverse of the text that should appears on the screen,
   * it is always composed of getScreenWidth() characters
   *
   * @return the reverse of the text that should appears on the screen
   */
  public String textOnScreen() {
    StringBuffer revers = new StringBuffer();
    revers.append(super.textOnScreen());
    revers.reverse();
    String res = revers.toString();
    return res;
  }
}
