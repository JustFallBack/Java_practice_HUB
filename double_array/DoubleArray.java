/* DoubleArray.java
 * 
 */

public class DoubleArray {

    private double[][] array;


    // Constructor, put random values in the array. (0-100)
    public DoubleArray(int row, int col) {
        this.array = new double[row][col];

        for (int i = 0; i < this.array.length; i++) {
            for (int j = 0; j < this.array[i].length; j++) {
                this.array[i][j] = Math.random() * 100;
            }
        }
    }


    // Display the content of an array of double.
    public void display() {
        for (int i = 0; i < this.array.length; i++) {
            for (int j = 0; j < this.array[i].length; j++) {
                System.out.printf("%12.6f",this.array[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }


    // Return true if number of raw = number of columns.
    public boolean regular() {
        return this.array.length == this.array[0].length;
    }


    // Return a DoubleArray object with each line the sum of the two lines of the two arrays. They must have the same dimensions.
    public DoubleArray addLine(DoubleArray t) throws IllegalArgumentException {

        // Check if the two arrays have the same dimensions.
        if (this.array.length != t.array.length || this.array[0].length != t.array[0].length) {
            throw new IllegalArgumentException("Error : Arrays must have the same dimensions.");
        }

        DoubleArray sum = new DoubleArray(this.array.length, this.array[0].length);

        for (int i = 0; i < this.array.length; i++) {
            for (int j = 0; j < this.array[i].length; j++) {
                sum.array[i][j] = this.array[i][j] + t.array[i][j];
            }
        }

        return sum;
    }


    // Return a double[] with the sum of each line of the two arrays. They must have the same number of lines.
    public double[] sumLine(DoubleArray t) throws IllegalArgumentException {

        // Check if the two arrays have the same number of lines.
        if (this.array.length != t.array.length) {
            throw new IllegalArgumentException("Error : Arrays must have the same number of lines.");
        }

        double[] sum = new double[this.array.length];

        for (int i = 0; i < this.array.length; i++) {
            sum[i] = 0;
            for (int j = 0; j < this.array[i].length; j++) {
                sum[i] += this.array[i][j] + t.array[i][j];
            }
        }

        return sum;
    }



    public static void main(String[] args) {
        
        try {

            if (args.length != 2) {
                throw new IllegalArgumentException("Error : must have 2 arguments.");
            }

            int row = Integer.parseInt(args[0]);
            int col = Integer.parseInt(args[1]);

            if (row <= 0 || col <= 0 || row > 100 || col > 100) {
                throw new IllegalArgumentException("Error : <nbRows> and <nbCols> must be positive integers inferior or equal to 100.");
            }

            DoubleArray t1 = new DoubleArray(row, col);
            System.out.println("Array is regular: " + t1.regular());
            t1.display();

            DoubleArray t2 = new DoubleArray(row, col);
            System.out.println("Array is regular: " + t2.regular());
            t2.display();

            System.out.println("Sum of the two arrays:");
            DoubleArray sum = t1.addLine(t2);
            sum.display();

            System.out.println("Sum of each line of the two arrays:");
            double[] sumLine = t1.sumLine(t2);
            for (int i = 0; i < sumLine.length; i++) {
                System.out.printf("%12.6f",sumLine[i]);
                System.out.println();
            }

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("\nError : <nbRows> and <nbCols> must be positive integers inferior or equal to 100.\nUsage: java DoubleArray <nbRows> <nbCols>");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + "\nUsage: java DoubleArray <nbRows> <nbCols>");
        }
    }
}