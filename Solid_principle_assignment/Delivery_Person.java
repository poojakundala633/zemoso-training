package Solid_principle_assignment;


public class Delivery_Person extends Person {
        private String vehicleNumber;

        public Delivery_Person(String name, String address, String phoneNumber, String vehicleNumber) {
            super(name, address, phoneNumber);
            this.vehicleNumber = vehicleNumber;
        }

    public Delivery_Person(String name, String address, String phoneNumber) {
        super(name, address, phoneNumber);
    }

    public String getVehicleNumber() {
            return vehicleNumber;
        }

        public void displayInformation() {
            System.out.println("Name: " + getName());
            System.out.println("Address: " + getAddress());
            System.out.println("Phone number: " + getPhoneNumber());
            System.out.println("Vehicle number: " + getVehicleNumber());
        }
    }

