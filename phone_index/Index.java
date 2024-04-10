/*
 * Index.java
 * 
 * This class manages phone numbers.
 * 
 * This Java class provides functionality to handle phone numbers. 
 * It includes methods for adding subscribers with names and phone numbers, retrieving phone
 * numbers by subscriber names, retrieving subscriber names by phone numbers, counting the 
 * number of subscribers, and obtaining a sorted array of subscribers.
 * 
 * It uses the Subscriber class to represent subscribers.
 */ 

public class Index {
    private int maxSub;
    private Subscriber[] subscribers;

    public Index(int maxSub) throws IllegalArgumentException{
        if (maxSub <= 0) {
            throw new IllegalArgumentException("The max number of subscribers must be greater than zero.");
        }
        this.maxSub = maxSub;
        this.subscribers = new Subscriber[maxSub];
    }


    // Add a subscriber to the index with the given name and phone number.
    public boolean addSubscriber(String name, String phoneNumber) throws NameException, PhoneNumberException{

        if (name.length() < 3) {
            throw new NameException("The name must be at least 3 characters long.");
        }
        if (phoneNumber.length() != 10) {
            throw new PhoneNumberException("The phone number must be 10 characters long.");
        }

       try {
            if (Long.parseUnsignedLong(phoneNumber) == 0) {
                throw new PhoneNumberException("The phone number must be a number and can't be 0000000000.");
            }
        // If the phone number is not a number, catch the NumberFormatException.
        } catch (NumberFormatException e) {
            throw new PhoneNumberException("The phone number must be a number.");
        }

        for (int i = 0; i < this.maxSub; i++) {
            if (this.subscribers[i] == null) {
                this.subscribers[i] = new Subscriber(name, phoneNumber);
                return true;
            }
        }
        // If the index is full, return false.
        return false;
    }


    // Return the phone number of the subscriber with the given name.
    public String getNumber(String name) throws NameException {
        if (name.length() < 3) {
            throw new NameException("The name must be at least 3 characters long.");
        }
        for (int i = 0; i < this.maxSub; i++) {
            if (this.subscribers[i].getName().equals(name)) {
                return this.subscribers[i].getPhoneNumber();
            }
        }
        return null;
    }


    // Return the name of the subscriber with the given phone number.
    public String getName(String phoneNumber) throws PhoneNumberException{
        if (phoneNumber.length() != 10) {
            throw new PhoneNumberException("The phone number must be 10 characters long.");
        }
        for (int i = 0; i < this.maxSub; i++) {
            if (this.subscribers[i].getPhoneNumber().equals(phoneNumber)) {
                return this.subscribers[i].getName();
            }
        }
        return null;
    }


    // Return the number of subscribers in the index.
    public int getNbSubscribers() {
        int count = 0;
        for (int i = 0; i < this.maxSub; i++) {
            if (this.subscribers[i] != null) {
                count++;
            }
        }
        return count;
    }


    // Return an sorted by names array of subscribers in the index.
    public Subscriber[] getSubscribers() {

        Subscriber[] sortedSubscribers = new Subscriber[this.getNbSubscribers()];


        for (int i = 0; i < this.getNbSubscribers(); i++) {
            if (this.subscribers[i] != null) {
                sortedSubscribers[i] = this.subscribers[i];
            }
        }

        for (int i = 0; i < sortedSubscribers.length; i++) {
            for (int j = i + 1; j < sortedSubscribers.length; j++) {
                // .compareTo() returns a negative integer, zero, or a positive integer when (this object) is less than, equal to, or greater than the specified object.
                if (sortedSubscribers[i].getName().compareTo(sortedSubscribers[j].getName()) > 0) {

                    // swap
                    Subscriber temp = sortedSubscribers[i];
                    sortedSubscribers[i] = sortedSubscribers[j];
                    sortedSubscribers[j] = temp;
                }
            }
        }
    return sortedSubscribers;
    }
    
    public static void main(String args[]) {
        try {

            if (args.length != 0) {
                throw new IllegalArgumentException("No argmunets expected.");
            }
            Index index = new Index(10);
            index.addSubscriber("Jean", "1234567890");
            index.addSubscriber("Dupont", "0987654321");
            index.addSubscriber("Marie", "0345678901");
            index.addSubscriber("Martin", "9876543210");
            index.addSubscriber("Alice", "3456789012");
            index.addSubscriber("Bob", "8765432109");
            index.addSubscriber("Eve", "4567890123");
            index.addSubscriber("Charles", "7654321098");
            index.addSubscriber("Olivia", "5678901234");
            index.addSubscriber("David", "6543210987");
            System.out.println();

            System.out.println("Jean's number : " + index.getNumber("Jean"));
            System.out.println("Dupont's number : " + index.getNumber("Dupont"));
            System.out.println("Marie's number : " + index.getNumber("Marie"));
            System.out.println("Martin's number : " + index.getNumber("Martin") + "\n");

            System.out.println("1234567890 is " + index.getName("1234567890"));
            System.out.println("0987645321 is " + index.getName("0987654321") + "\n");

            System.out.println("Number of subscribers : " + index.getNbSubscribers() + "\n");

            Subscriber[] subscribers = index.getSubscribers();
            for (int i = 0; i < subscribers.length; i++) {
                System.out.printf("%10s", subscribers[i].getName());
                System.out.printf("%15s", subscribers[i].getPhoneNumber());
                System.out.println();
            }

        } catch (NameException e) {
            System.out.println(e.getMessage() + "\nUsage : java Index");
        } catch (PhoneNumberException e) {
            System.out.println(e.getMessage() + "\nUsage : java Index");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + "\nUsage : java Index");
        }
    }

}