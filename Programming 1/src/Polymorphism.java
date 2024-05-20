import java.awt.*;

class Shape {
    Color color; // (must be imported from package java.awt)

    void setColor(Color newColor) {
        // Method to change the color of the shape.
        color = newColor; // change value of instance variable
        redraw(); // redraw shape, which will appear in new color
    }

    void redraw() {
        // method for drawing the shape
        ? ? ? // what commands should go here?
    }
    . . . // more instance variables and methods
} // end of class Shape

class Rectangle extends Shape {
    void redraw() {
        . . . // commands for drawing a rectangle
    }
    . . . // possibly, more methods and variables
}

class Oval extends Shape {
    void redraw() {
        . . . // commands for drawing an oval
    }
    . . . // possibly, more methods and variables
}

class RoundRect extends Shape {
    void redraw() {
        . . . // commands for drawing a rounded rectangle
    }
    . . . // possibly, more methods and variables
}

public class Polymorphism {
    public static void main(String[] args) {
        Shape[] shapelist = new Shape[];

        for(int i = 0; i < shapelist.length; i++) {
            Shape shape = shapelist[i];
            shape.redraw;
        }
    }
}