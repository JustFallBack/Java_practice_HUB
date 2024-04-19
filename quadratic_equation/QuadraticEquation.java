/*
 * QuadraticEquation.java
 * This program solves the quadratic equation ax^2 + bx + c = 0, 
 * where the coefficients a, b, and c are provided as arguments. 
 * Note: 's' is a String corresponding to an integer, and the call 'Integer.valueOf(s)' returns 
 * the associated integer value."
 */


public class QuadraticEquation {

	public static void main(String[] args) {

        try {

            // throw exception if the number of arguments is different from 3.
            if(args.length != 3) { 
                throw new IllegalArgumentException("Error : must have 3 arguments.");
            }

            // if there is 3 arguments.
            double a = Double.parseDouble(args[0]);
            double b = Double.parseDouble(args[1]);
            double c = Double.parseDouble(args[2]);
            double det = b*b - 4*a*c;

            if(a == 0) { // if a = 0
                if(b == 0) { // if a = b = 0
                    if(c == 0) { // if a = b = c = 0
                        System.out.println("The assertion "+a+"x^2 + "+b+"x + "+c+" = 0 is true.");
                    }
                    else { // if a = b = 0 and c != 0
                        System.out.println("The assertion "+a+"x^2 + "+b+"x + "+c+" = 0 is false.");
                    }
                }
                else { // if a = 0 and b != 0
                    System.out.println("The equation "+a+"x^2 + "+b+"x + "+c+" = 0 is not a quadratic equation:\nx = "+(-c/b)+".");
                }
            }
            else if(det < 0) { // if the determinant is negative
                System.out.println("The equation "+a+"x^2 + "+b+"x + "+c+" = 0 has no real solution.");
            }
            else if(det == 0) { // if the determinant is zero
                System.out.println("The equation "+a+"x^2 + "+b+"x + "+c+" = 0 has a one solution:\nx = "+-b/2*a);
            }
            else { // if the determinant is positive
                System.out.println("The equation "+a+"x^2 + "+b+"x + "+c+" = 0 has two solutions:\nx1 = "+(-b+Math.sqrt(det))/2*a+"\nx2 = "+(-b-Math.sqrt(det))/2*a);
            }
		}

        // catch exception if the arguments are not numbers.
        catch (NumberFormatException e) { 
            System.out.println("Error : the arguments must be numbers.");
        }

        // catch exception if the number of arguments is different from 3.
        catch (IllegalArgumentException e) { 
            System.out.println(e.getMessage());
        }
	}
}
