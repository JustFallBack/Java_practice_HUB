/* 
 * Payroll.java
 * This class represents a payroll system.
 * The user can add multiple employees to the payroll system (workers, sales employees, and a director).
 * At the end of the process, the user can view the payroll of all employees. 
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Payroll {

    public static void main(String[] args) {

        String name, type;

        double salary, sales, hoursWorked, hourlyRate, overtimeRate;

        ArrayList<Employee> employees = new ArrayList<Employee>();

        try {

            Scanner scanner = new Scanner(System.in);
            while (true) {

                if (!(employees.isEmpty())) {
                    System.out.println("Do you want to add another employee? (yes/no)");
                    // Using name var to store the user anwser.
                    name = scanner.nextLine();
                    while (!name.equalsIgnoreCase("yes") && !name.equalsIgnoreCase("no")) {
                        System.out.println("Invalid input. Please enter 'yes' or 'no'.");
                        name = scanner.nextLine();
                    }
                    if(name.equalsIgnoreCase("no")){
                        scanner.close();
                        break;
                    }
                }

                System.out.println("Enter the name of the employee: ");
                while (true) {
                    name = scanner.nextLine();
                    if (name.length() >= 3) {
                        break;
                    } else {
                        System.out.println("Invalid input. Name must be at least 4 characters long.");
                    }

                }

                System.out.println("Enter the type of the employee (worker, sales, director): ");
                while (true) {
                    type = scanner.nextLine();
                    if ("worker".equalsIgnoreCase(type) || "sales".equalsIgnoreCase(type) || "director".equalsIgnoreCase(type)) {
                        break;
                    } else {
                        System.out.println("Invalid input. Please enter 'worker', 'sales', or 'director'.");
                    }
                }

                switch (type) {
                    case "worker":
                        System.out.println("Enter the number of hours worked: ");
                        while (true) {
                            try {
                                hoursWorked = Double.parseDouble(scanner.nextLine());
                                if (hoursWorked < 0) {
                                    throw new NumberFormatException();
                                }
                                break;
                            } catch (NumberFormatException e) {
                                System.out.println("Invalid input. Please enter a positive number.");
                            }
                        }
                        System.out.println("Enter the hourly rate: ");
                        while (true) {
                            try {
                                hourlyRate = Double.parseDouble(scanner.nextLine());
                                if (hourlyRate < 0) {
                                    throw new NumberFormatException();
                                }
                                break;
                            } catch (NumberFormatException e) {
                                System.out.println("Invalid input. Please enter a positive number.");
                            }
                        }
                        System.out.println("Enter the overtime rate: ");
                        while (true) {
                            try {
                                overtimeRate = Double.parseDouble(scanner.nextLine());
                                if (overtimeRate < 0) {
                                    throw new NumberFormatException();
                                }
                                break;
                            } catch (NumberFormatException e) {
                                System.out.println("Invalid input. Please enter a positive number.");
                            }
                        }
                        employees.add(new Worker(name, hoursWorked, hourlyRate, overtimeRate));
                        break;
                    case "sales":
                        System.out.println("Enter the base salary: ");
                        while (true) {
                            try {
                                salary = Double.parseDouble(scanner.nextLine());
                                if (salary < 0) {
                                    throw new NumberFormatException();
                                }
                                break;
                            } catch (NumberFormatException e) {
                                System.out.println("Invalid input. Please enter a positive number.");
                            }
                        }
                        System.out.println("Enter the sales: ");
                        while (true) {
                            try {
                                sales = Double.parseDouble(scanner.nextLine());
                                if (sales < 0) {
                                    throw new NumberFormatException();
                                }
                                break;
                            } catch (NumberFormatException e) {
                                System.out.println("Invalid input. Please enter a positive number.");
                            }
                        }
                        employees.add(new SalesEmployee(name, salary, sales));
                        break;
                    case "director":
                        System.out.println("Enter the base salary: ");
                        while (true) {
                            try {
                                salary = Double.parseDouble(scanner.nextLine());
                                if (salary < 0) {
                                    throw new NumberFormatException();
                                }
                                break;
                            } catch (NumberFormatException e) {
                                System.out.println("Invalid input. Please enter a positive number.");
                            }
                        }
                        employees.add(Director.getInstance(name, salary));
                        break;
                }
            }
            System.out.println("\nPayroll : ");
            for (Employee employee : employees) {
            System.out.println(employee.getName() + " salary: " + employee.calculateSalary());
        }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + "\nUsage : java Payroll");
        }
    }
}
