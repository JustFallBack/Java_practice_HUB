/* Subscriber.java
 * 
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
