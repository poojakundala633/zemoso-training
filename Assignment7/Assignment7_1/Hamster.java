package Assignment7.Assignment7_1;

public class Hamster extends Rodent {

    public Hamster() {
        System.out.println("I am Hamster Rodent");

    }

    @Override
    public void run() {
        System.out.println("Hamster  Started");

    }

    @Override
    public void close() {
        System.out.println("Hamster  Closed");
    }


}

