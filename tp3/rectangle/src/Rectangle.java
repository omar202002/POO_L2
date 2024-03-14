/**
*class for the rectangle
*/
public class Rectangle{
  /** the length of the rectangle */
  private double length;
  /** the width of the rectangle*/
  private double width;

  /**
  *Builds a rectangle with a given length and width;
  *
  *@param length the length of the rectangle
  *@param width the width of the rectangle
  */
  public Rectangle(double length, double width){
    this.length = length;
    this.width = width;
  }

  /**
  *the length of the rectangle
  *
  *@return the length of the rectangle
  */
  public double getLength(){
    return this.length;
  }

  /**
  *the width of the rectangle
  *
  *@return the width of the rectangle
  */
  public double getWidth(){
    return this.width;
  }

  /**
  *the area of the rectangle
  *
  *@return the area of the rectangle
  */
  public double area(){
    return this.length * this.width;
  }

  /**
  *the perimeter of the rectangle
  *
  *@return the perimeter of the  rectangle
  */
  public double perimeter(){
    return (2 * this.length) + (2 * this.width);
  }

  /**
  *it tells if the rectangle is also a square
  *
  *@return true or false depending on the fact that the rectangle is square or not
  */
  public boolean isSquare(){
    return this.length == this.width;
  }

  /**
  *tells if the rectangle is equal to a another object
  *
  *@param o the object we compare the rectangle with
  *@return true or false respectively if the rectangle is equal to the object or not
  */
  public boolean equals(Object o){
    if(!( o instanceof Rectangle)){
      return false;
    }
    else {
      Rectangle other = (Rectangle) o;
      return this.length == other.length && this.width == other.width;
    }
  }

  /**
  *provide a string representation of the rectangle object
  *
  *@ return the string representation of the rectangle object
  */
  public String toString(){
    return "The length of the rectangle is: " + this.length + " and it's width is: " + this.width;
  }
}
