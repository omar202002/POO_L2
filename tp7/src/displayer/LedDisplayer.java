package displayer;

/**
 * A LedDisplayer diplays a message on a screen of limited width. 
 * Message can scroll to be displaid char by char.
 */

public class LedDisplayer {

   protected String message;        // the full message
   protected String onScreen;       // text currently displaid on screen
   protected int screenWidth;
   protected int nextCharPosition;  // position in message of char that must appear at next shift()

   /**
    * build a displayer with a screen of width characters
    * @param width this displayer's width
    */
   public LedDisplayer(int width) {
      this.screenWidth = width;
      this.setMessage("");            // empty essage by default
   }

   /**
    * get the (full) message of this displayer
    * @return the (full) message of this displayer
    */
   public String getMessage() {
      return this.message;
   }

   /**
    * set the new message to display, a call to textOnScreen() is now blank until next shift()
    * First character of message will enter on the right at next shift() .
    * 
    * @param message the new message
    */
   public void setMessage(String message) {
      this.message = message;
      this.resetOnScreen();            
      this.nextCharPosition = 0;       // new message then next char is first char
   }

   /**
    * empty the text on screen : fill it with white spaces
    */
   private void resetOnScreen() {
      this.onScreen = "";
      // fill on screen text with white spaces
      for (int i = 0; i < this.screenWidth; i ++) {
         this.onScreen = this.onScreen + " ";
      }
   }

   /**
    * get this screen's width
    * @return this screen's width
    */
   public int getScreenWidth() {
      return this.screenWidth;
   }

   /** shift message by one character : first character on the left disappears, 
    * next character from message is added on the right */
   public void shift() {
      char nextChar = this.message.charAt(this.nextCharPosition);
      this.onScreen = this.onScreen.substring(1) + nextChar;
      // update position for next char
      this.nextCharPosition = (this.nextCharPosition + 1) % this.message.length();
   }

   /**
    * return the text that appears on the screen,
    * it is always composed of getScreenWidth() characters
    * 
    * @return the text that appears on the screen
    */
   public String textOnScreen() {
      return this.onScreen;
   }

}
