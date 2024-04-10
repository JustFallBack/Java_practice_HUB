/* 
 * Subscriber.java
 * 
 * This file defines the Subscriber class, which represents a subscriber in a telecommunications system.
 * A subscriber has a name and a phone number.
 * 
 * The class provides two constructors: a default constructor that initializes the name and phone number to empty strings,
 * and a parameterized constructor that allows the caller to specify the name and phone number.
 * 
 * The class also provides getter methods to retrieve the name and phone number of a subscriber.
 */

public class Subscriber {
    private String name;
    private String phoneNumber;

    public Subscriber() {
        this.name = "";
        this.phoneNumber = "";
    }

    public Subscriber(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return this.name;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }
}
