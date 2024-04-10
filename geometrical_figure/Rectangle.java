/*
 * Rectangle.java
 * This class extends the Quadri class.
 * It represents a rectangle in a 2D space.
 */


public class Rectangle extends Quadri {

    private double length;
    private double width;

    // Constructor, initialize the length and width of the rectangle.
    public Rectangle(double length, double width) {
        super(new double[] {length, width, length, width});
        this.length = length;
        this.width = width;
    }


    // Return the length of the rectangle.
    public double getLength() {
        return this.length;
    }


    // Return the width of the rectangle.
    public double getWidth() {
        return this.width;
    }


    // Return the perimeter of the rectangle.
    public double perimeter() {
        return super.perimeter();
    }

    
    // Return the area of the rectangle.
    public double area() {
        return this.length * this.width;
    }    
}
