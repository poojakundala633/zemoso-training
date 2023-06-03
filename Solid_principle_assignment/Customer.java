package Solid_principle_assignment;


public class Customer extends Person  {
private String email;

public Customer(String name, String address, String phoneNumber, String email) {
        super(name, address, phoneNumber);
        this.email = email;
        }

public String getEmail() {
        return email;
        }

public void displayInformation() {
        System.out.println("Name: " + getName());
        System.out.println("Address: " + getAddress());
        System.out.println("Phone number: " + getPhoneNumber());
        System.out.println("Email: " + getEmail());
        }
}






