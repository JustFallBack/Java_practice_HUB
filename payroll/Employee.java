/* 
 * Employee.java 
 * This abstract class represents an employee.
 * An employee has a name and a method to calculate the salary.
 * The salary calculation is specific to each type of employee.
 */

public abstract class Employee {

    protected String name;

    // Constructor.
    public Employee(String name) throws IllegalArgumentException {
        if (name == null || name.isEmpty() || name.length() < 3) {
            throw new IllegalArgumentException("Name must be at least 3 characters long.");
        }
        this.name = name;
    }

    // Getters.
    public String getName() {
        return name;
    }

    public abstract double calculateSalary();
}
