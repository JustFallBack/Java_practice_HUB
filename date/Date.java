/*
 * File: Date.java
 * Description: Given three integer arguments representing a date (day, month, year), this program displays the following day." 
 */

public class Date {

    private int day;
    private int month;
    private int year;
    final static String listOfMonth[] = { "January", "February", "March", "April", "May", "June", "July", "August",
            "September", "October", "November", "December" };

    // Exception class for IsNotValidDateException.
    public static class IsNotValidDateException extends Exception {
        public IsNotValidDateException(String s) {
            super(s);
        }
    }

    // Constructor with string main argument.
    public Date(String[] args) throws IsNotValidDateException{

        try {
            
            this.day = Integer.parseInt(args[0]);
            this.month = Integer.parseInt(args[1])-1; 
            this.year = Integer.parseInt(args[2]);

            // Throw exception if the date is not valid.
            if(!this.checkDate()) {
                throw new IsNotValidDateException(null);
            }

        }

        // Catch exception if the date is not valid.
        catch (IsNotValidDateException e) {
            throw new IsNotValidDateException("Error : provided date does not exist.");
        }
        // Catch exception if the arguments are not numbers.
        catch (NumberFormatException e) {
            System.out.println("Error : arguments must be numbers." + "\nUsage : java Date <1-31> <1-12> <0-3000>.");
            System.exit(1);
        }
        
    }

    // Constructor with 3 integers.
    private Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    // Return true if the date is correct.
    private boolean checkDate() {
        if (this.day <= 0 || this.day > this.lastDayOfMonth()) {
            return false;
        } else if (this.month < 0 || this.month > 11) {
            return false;
        } else if (this.year < 0 || this.year > 3000) {
            return false;
        } else {
            return true;
        }
    }

    // Return the correct ordinal indicator depending on the day.
    private String dayString() {
        switch (this.day) {
            case 1:
            case 21:
            case 31:
                return ("st");
            case 2:
            case 22:
                return ("nd");
            case 3:
            case 23:
                return ("rd");
            default:
                return ("th");
        }
    }

    // Return the string value of the month (January, June).
    private String monthString() {
        return (listOfMonth[this.month]);
    }

    // Return true if the year is leap.
    private boolean isLeapYear() {
        if ((this.year % 4 == 0 && this.year % 100 != 0) || (this.year % 400 == 0)) {
            return true;
        } else {
            return false;
        }
    }

    // Return the last day of the month.
    private int lastDayOfMonth() {
        switch (this.month) {

            // 31-day month.
            case 0:
            case 2:
            case 4:
            case 6:
            case 7:
            case 9:
            case 11:
                return 31;

            // February : if the year is leap, return 29, else 28.
            case 1:
                if (isLeapYear()) {
                    return 29;
                } else {
                    return 28;
                }

                // 30-day month.
            default:
                return 30;
        }
    }

    // Return true if the day is the last day of its month.
    private boolean isLastDayOfMonth() {
        if (this.day == this.lastDayOfMonth()) {
            return true;
        } else {
            return false;
        }
    }

    // Return true if the month is December.
    private boolean isDecember() {
        if (this.month == 11) {
            return true;
        } else {
            return false;
        }
    }

    // Return true if it is the 28th of February.
    private boolean is28thOfFebruary() {
        if (this.day == 28 && this.month == 1) {
            return true;
        } else {
            return false;
        }
    }

    // Override of toString() to print the date.
    public String toString() {
        return this.day + this.dayString() + " of " + this.monthString() + ", " + this.year;
    }

    // Return the date of the day after the current one.
    public Date nextDate() {
        if (isLastDayOfMonth()) {
            if (isDecember()) {
                return new Date(1, 0, (this.year + 1));
            } else if (is28thOfFebruary()) {
                if (isLeapYear()) {
                    return new Date((this.day + 1), this.month, this.year);
                } else {
                    return new Date(1, (this.month + 1), this.year);
                }
            } else {
                return new Date(1, (this.month + 1), (this.year + 1));
            }
        } else {
            return new Date((this.day + 1), this.month, this.year);
        }
    }

    public static void main(String[] args) {

        try {

            // Throw exception if the number of arguments is different from 3.
            if (args.length != 3) {
                throw new IllegalArgumentException("Error : must be 3 arguments.");
            }

            Date date = new Date(args);
            Date dayAfter = date.nextDate();
            System.out.println("The day after the " + date.toString() + " will be the " + dayAfter.toString() + ".");
        }

        // Catch exception if the number of arguments is different from 3.
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + "\nUsage : java Date <1-31> <1-12> <0-3000>.");
        }
        // Catch exception if the date is not valid.
        catch (IsNotValidDateException e) {
            System.out.println(e.getMessage() + "\nUsage : java Date <1-31> <1-12> <0-3000>.");
        }
    }
}
