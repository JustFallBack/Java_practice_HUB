/*
 * Main.java
 * This class is the main class of the program.
 * It creates instances of the Triangle, Rectangle, Square, Dot and Circle classes.
 */


public class Main {
    
    public static void main(String args[]) {
        try {

            double[] edges = {3.245, 4.12, 0.98};
            Triangle triangle = new Triangle(edges);
            System.out.println("\nPerimeter of the triangle: " + triangle.perimeter() + "\n");
            
            Rectangle rectangle = new Rectangle(34, 12.8);
            System.out.println("Perimeter of the rectangle: " + rectangle.perimeter());
            System.out.println("Area of the rectangle: " + rectangle.area() + "\n");
            
            Square square = new Square(8552.6);
            System.out.println("Perimeter of the square: " + square.perimeter());
            System.out.println("Area of the square: " + square.area() + "\n");

            Dot dot = new Dot(3.4, 5.6);
            Circle circle = new Circle(dot,3.33);
            System.out.println("Perimeter of the circle: " + circle.perimeter() + "\n");

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + "\nUsage : java Main");
        }
    }
}
