/*
 * NaturalNumber.java
 * This class represents a natural number (positive integer).
 * It provides methods to perform basic arithmetic operations on natural numbers.
 * The operations are: addition, subtraction, multiplication, and division.
 * Each operation throws a customed exception if the result exceeds the integer min 
 * or max value, or if it is a division by zero.
 */

public class NaturalNumber {
    private int value;


    public NaturalNumber(int value) throws ConstErr {
        if(value < 0) {
            throw new ConstErr("Natural numbers must be positive");
        }
        this.value = value;
    }


    public int getValue() {
        return value;
    }

    // n1 + n2
    public static int sum(NaturalNumber n1, NaturalNumber n2) throws SumErr {
        long result = (long) n1.getValue() + (long) n2.getValue();
        if(result > Integer.MAX_VALUE) {
            throw new SumErr("Sum exceeds integer max value.");
        }
        return (int) result;
    }

    // n1 - n2
    public static int difference(NaturalNumber n1, NaturalNumber n2) throws DiffErr {
        long result = (long) n1.getValue() - (long) n2.getValue();
        if(result < Integer.MIN_VALUE) {
            throw new DiffErr("Difference exceeds integer min value.");
        }
        return (int) result;
    }

    // n1 * n2
    public static int product(NaturalNumber n1, NaturalNumber n2) throws ProdErr {
        long result = (long) n1.getValue() * (long) n2.getValue();
        if(result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            throw new ProdErr("Product exceeds integer min or max value.");
        }
        return (int) result;
    }

    // n1 / n2
    public static int division(NaturalNumber n1, NaturalNumber n2) throws DivErr {
        if(n2.getValue() == 0) {
            throw new DivErr("Division by zero is forbidden.");
        }
        return n1.getValue() / n2.getValue();
    }

    public static void Operation(char operator, NaturalNumber n1, NaturalNumber n2) throws InvalidOperator, ConstErr, SumErr, DiffErr, ProdErr, DivErr {
        switch (operator) {
            case '+':
                System.out.println(n1.getValue() + " + " + n2.getValue() + " : " + sum(n1, n2) + "\n");
                break;
            case '-':
                System.out.println(n1.getValue() + " - " + n2.getValue() + " : " + difference(n1, n2) + "\n");
                break;
            case '*':
                System.out.println(n1.getValue() + " * " + n2.getValue() + " : " + product(n1, n2) + "\n");
                break;
            case '/':
                System.out.println(n1.getValue() + " / " + n2.getValue() + " : " + division(n1, n2) + "\n");
                break;
            default:
                throw new InvalidOperator("Invalid operator.");
        }
    }

    public static void main(String[] args) {
        try {
            NaturalNumber n1 = new NaturalNumber(50);
            NaturalNumber n2 = new NaturalNumber(100);
            NaturalNumber n3 = new NaturalNumber(150);
            NaturalNumber n4 = new NaturalNumber(Integer.MAX_VALUE-50);

            Operation('+', n1, n4);
            Operation('-', n3, n1);
            Operation('*', n2, n2);
            Operation('/', n1, n2);

        } catch (ConstErr | DivErr | SumErr | ProdErr | DiffErr | InvalidOperator e) {
            System.out.println(e.getMessage() + "\nUsage : java NaturalNumber");
       
        }
    }
}
