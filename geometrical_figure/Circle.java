/* Circle.java
 * 
 * This class represents a circle in a 2D space.
 * It is used to store the center and the radius of a circle.
 * The class provides a method to calculate the perimeter of the circle.
 */


public class Circle extends GeometricalFigure {

    private Dot center;
    private double radius;


    // Default constructor, initialize the center to (0,0) and the radius to 1.
    public Circle() {
        this.center = new Dot();
        this.radius = 1;
    }


    // Constructor, initialize the center and the radius.
    public Circle(Dot center, double radius) throws IllegalArgumentException {
        if(radius <= 0) {
            throw new IllegalArgumentException("The radius must be greater than zero.");
        }
        this.radius = radius;
        this.center = center;
    }


    // Get the center of the circle.
    public Dot getCenter() {
        return this.center;
    }


    // Get the radius of the circle.
    public double getRadius() {
        return this.radius;
    }

    
    // Return the perimeter of the circle.
    public double perimeter() {
        return 2 * Math.PI * this.radius;
    }
}