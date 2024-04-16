/*
 * SalesEmployee.java
 * This class represents a sales employee.
 * A sales employee has a base salary and a commission based on the sales.
 * The commission is 1% of the sales.
 * The total sales of all sales employees are stored in a static variable.
 * The total sales are used to calculate the commission of the director.
 */

public class SalesEmployee extends Employee {

    private final double baseSalary;
    private double sales;
    private static final double commission = 0.01;
    private static double totalSales = 0;

    // Constructor.
    public SalesEmployee(String name, double salary, double sales) throws IllegalArgumentException {
        super(name);
        if (salary < 0) {
            throw new IllegalArgumentException("Salary must be positive.");
        }
        if (sales < 0) {
            throw new IllegalArgumentException("Sales must be positive.");
        }
        this.baseSalary = salary;
        this.sales = sales;
        SalesEmployee.totalSales += sales;
    }

    // Getters.
    public double getSalary() {
        return baseSalary;
    }
    public double getSales() {
        return sales;
    }
    public static double getTotalSales() {
        return totalSales;
    }

    // Calculate salary.
    public double calculateSalary() {
        return baseSalary + commission * sales;
    }
}
