/*
 * Director.java
 * This class represents a director employee (singleton class).
 * A director has a base salary and a commission based on the total sales of the sales employees.
 * The commission is 0.4% of the total sales.
 */



public class Director extends Employee {

    private static Director instance;
    private final double baseSalary;
    private static final double commission = 0.004;


    // Private constructor (singleton class).
    private Director(String name, double salary) throws IllegalArgumentException {
        super(name);
        if (salary < 0) {
            throw new IllegalArgumentException("Salary must be positive.");
        }
        this.baseSalary = salary;
    }

    // Singleton pattern.
    public static Director getInstance(String name, double salary) {
        if (instance == null) {
            instance = new Director(name, salary);
        }
        return instance;
    }

    // Getters.
    public double getSalary() {
        return baseSalary;
    }

    // Calculate salary.
    public double calculateSalary() {
        return baseSalary + commission * SalesEmployee.getTotalSales();
    }
}
