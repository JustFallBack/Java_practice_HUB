/* 
 * Quadri.java
 * This class extends the Polygon class.
 * It represents a quadrilateral (4 edges) in a 2D space.
 */


public class Quadri extends Polygon {


    // Constructor, initialize the number of edges to 4 and the length of each edge.
    public Quadri(double[] edges) {
        super(4, edges);
    }
    

    // Constructor that takes a Polygon as parameter.
    public Quadri(Polygon b) {
        super(b.getNbEdges(), b.getEdges());
    }


    // Return the perimeter of the quadri.
    public double perimeter() {
        return super.perimeter();
    }
}
