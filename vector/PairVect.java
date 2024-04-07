/* PairVect.java
 * This class represents a pair of 3D vectors.
 * It is a subclass of Vector.
 */

 public class PairVect extends Vector{
    private Vector v1;
    private Vector v2;
    
    // Constructor without parameters.
    public PairVect() {
        this.v1 = new Vector();
        this.v2 = new Vector();
    }

    // Constructor with 6 int parameters.
    public PairVect(int x1, int y1, int z1, int x2, int y2, int z2) {
        this.v1 = new Vector(x1, y1, z1);
        this.v2 = new Vector(x2, y2, z2);
    }

    // Constructor with 2 Vector as parameters.
    public PairVect(Vector v1, Vector v2) {
        this.v1 = v1;
        this.v2 = v2;
    }

    // Override of toString method.
    public String toString() {
        return this.v1.toString() + " " + this.v2.toString();
    }

    // Get the first or second vector.
    public Vector getVector(int i) {
        switch (i) {
            case 1:
                return this.v1;
            case 2:
                return this.v2;
            default:
                throw new IllegalArgumentException("Invalid index : " + i + "\nIndex must be 1 or 2.");
        }
    }

    public static void main(String[] args) {

        if(args.length != 0) {
            throw new IllegalArgumentException("No arguments are expected.");
        }

        PairVect pv = new PairVect(1, 2, 3, 4, 5, 6);
        System.out.println("Pair of vectors : " + pv);
        System.out.println("First Vector : " + pv.getVector(1));
        System.out.println("Second vector : " + pv.getVector(2));
    }

}  
