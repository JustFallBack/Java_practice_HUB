/* Dot.java
 * 
 * This class represents a dot in a 2D space.
 * It is used to store the x and y coordinates of a dot.
 * 
 */

public class Dot {
    
    private double x;
    private double y;

    // Default constructor, initialize x and y to 0.
    public Dot() {
        this.x = 0;
        this.y = 0;
    }


    // Constructor, initialize x and y to the given values.
    public Dot(double x, double y) {
        this.x = x;
        this.y = y;
    }


    // Return x position.
    public double getX() {
        return this.x;
    }


    // Return y position.
    public double getY() {
        return this.y;
    }


    @Override
    public String toString() {
        return "Dot [x=" + x + ", y=" + y + "]";
    }
}
