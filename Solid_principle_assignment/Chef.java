package Solid_principle_assignment;
public class Chef extends Person implements ChefInterface {
        private int yearsOfExperience;

        public Chef(String name, String address, String phoneNumber, int yearsOfExperience) {
            super(name, address, phoneNumber);
            this.yearsOfExperience = yearsOfExperience;
        }

        public int getYearsOfExperience() {
            return yearsOfExperience;
        }

        public void displayInformation() {
            System.out.println("Name: " + getName());
            System.out.println("Address: " + getAddress());
            System.out.println("Phone number: " + getPhoneNumber());
            System.out.println("Years of experience: " + getYearsOfExperience());
        }

    @Override
    public void startCooking(Order order) {
        System.out.println("start cooking");
    }

    @Override
    public void stopCooking(Order order) {
        System.out.println("stop cooking");
    }
}

