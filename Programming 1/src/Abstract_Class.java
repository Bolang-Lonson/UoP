import java.awt.color.*;

abstract class Shape {
    Color color; // color of shape.
    void setColor(Color newColor) {
        // method to change the color of the shape
        color = newColor; // change value of instance variable
        redraw(); // redraw shape, which will appear in new color
    }
    abstract void redraw();
    // abstract method---must be defined in
    // concrete subclasses
    . . . // more instance variables and methods
} // end of class Shape

public class Abstract_Class {

}
