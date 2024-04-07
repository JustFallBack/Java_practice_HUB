/* Vector.java
 * This class represents a 3D vector.
 */

public class Vector {

    private static int number_of_vectors = 0;
    private int x;
    private int y;
    private int z;

    // Constructor without parameters.
    public Vector() {
        this.x = 0;
        this.y = 0;
        this.z = 0;
        Vector.number_of_vectors++;
    }

    // Constructor with parameters.
    public Vector(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
        Vector.number_of_vectors++;
    }

    // Override of toString method.
    public String toString() {
        return "(" + this.x + ", " + this.y + ", " + this.z + ")";
    }

    // Display the vector.
    public void display() {
        System.out.println("(" + this.x + ", " + this.y + ", " + this.z + ")");
    }

    // Multiply the vector by a scalar.
    public void multiply(int scalar) {
        this.x *= scalar;
        this.y *= scalar;
        this.z *= scalar;
    }

    // Multiply two vectors.
    public int dot_product(Vector v) {
        if (v == null) {
            throw new NullPointerException("Cannot multiply with null vector.");
        }
        return this.x * v.x + this.y * v.y + this.z * v.z;
    }

    // Add two vectors.
    public Vector add(Vector v) {
        if (v == null) {
            throw new NullPointerException("Cannot add null vector.");
        }
        return new Vector(this.x + v.x, this.y + v.y, this.z + v.z);
    }

    // Get the number of vectors.
    public static int get_number_of_vectors() {
        return Vector.number_of_vectors;
    }


    public static void main(String[] args) {

        if(args.length != 0) {
            throw new IllegalArgumentException("No arguments are expected.");
        }
        Vector v1 = new Vector(1, 2, 3);
        Vector v2 = new Vector(4, 5, 6);
        Vector v3 = v1.add(v2);
        
        System.out.println("v1: " + v1);
        System.out.println("v2: " + v2);
        System.out.print("v3 = v1 + v2: "); v3.display();
        System.out.println("Dot product of v1 . v2: " + v1.dot_product(v2));
        System.out.println("Number of vectors: " + Vector.get_number_of_vectors());
    }
}