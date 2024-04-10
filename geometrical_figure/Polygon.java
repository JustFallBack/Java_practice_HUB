/*
 * Polygon.java
 * This class represents a polygon in a 2D space.
 * It extends the GeometricalFigure abstract class.
 * It is used to store the number of edges and the length of each edge of a polygon.
 * The class provides a method to calculate the perimeter of the polygon.
 */


public class Polygon extends GeometricalFigure {

    private int nb_edges;
    private double[] edges;

    // Constructor, initialize the number of edges of the polygon.
    public Polygon(int nb_edges) throws IllegalArgumentException {
        if (nb_edges < 3) {
            throw new IllegalArgumentException("A polygon must have at least 3 edges.");
        }
        this.nb_edges = nb_edges;
        this.edges = new double[nb_edges];
    }


    // Constructor, initialize the number of edges and the length of each edge.
    public Polygon(int nb_edges, double[] edges) throws IllegalArgumentException {
        if (nb_edges < 3) {
            throw new IllegalArgumentException("A polygon must have at least 3 edges.");
        }
        if (edges.length != nb_edges) {
            throw new IllegalArgumentException("The number of edges must be equal to the length of the array.");
        }
        for(int i = 0; i < edges.length; i++) {
            if (edges[i] <= 0) {
                throw new IllegalArgumentException("The length of an edge must be greater than zero.");
            }
        }
        this.nb_edges = nb_edges;
        this.edges = edges;
    }


    // Return the perimeter of the polygon.
    public double perimeter() {
        double perimeter = 0;
        for (int i = 0; i < this.edges.length; i++) {
            perimeter += this.edges[i];
        }
        return perimeter;
    }


    // Return the number of edges of the polygon.
    public int getNbEdges() {
        return this.nb_edges;
    }


    // Return the array of edges of the polygon.
    public double[] getEdges() {
        return this.edges;
    }
}
