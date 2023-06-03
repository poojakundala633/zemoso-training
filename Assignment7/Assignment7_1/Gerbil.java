package Assignment7.Assignment7_1;

public class Gerbil extends Rodent {

    public Gerbil() {
        System.out.println("I am Gerbil Rodent");

    }

    @Override
    public void run() {
        System.out.println("Gerbil  Started");

    }

    @Override
    public void close() {
        System.out.println("Gerbil  Closed");
    }


}
