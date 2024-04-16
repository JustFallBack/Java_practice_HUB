/*
 * Worker.java
 * This class represents a worker employee.
 * A worker has a number of hours worked, an hourly rate, and an overtime rate.
 * If the number of hours worked is greater than 35, the worker is paid overtime.
 * The overtime rate is used to calculate the overtime pay.
 */


public class Worker extends Employee {
    
    private double hoursWorked;
    private double hourlyRate;
    private double overtimeRate;


    // Constructor.
    public Worker(String name, double hoursWorked, double hourlyRate, double overtimeRate) throws IllegalArgumentException {
        super(name);
        if (hoursWorked < 0) {
            throw new IllegalArgumentException("Hours worked must be positive.");
        }
        if (hourlyRate < 0) {
            throw new IllegalArgumentException("Hourly rate must be positive.");
        }
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    // Getters.
    public double getHoursWorked() {
        return hoursWorked;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public double getOvertimeRate() {
        return overtimeRate;
    }

    // Calculate salary.
    public double calculateSalary() {
        if (hoursWorked > 35) {
            return 35 * hourlyRate + (hoursWorked - 35) * overtimeRate;
        }
        return hoursWorked * hourlyRate;
    }
}
