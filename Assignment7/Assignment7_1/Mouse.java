package Assignment7.Assignment7_1;

public class Mouse extends Rodent {

    public Mouse() {
        System.out.println("I am Mouse Rodent");

    }

    @Override
    public void run() {
        System.out.println("Mouse  Started");

    }

    @Override
    public void close() {
        System.out.println("Mouse  Closed");
    }

}
