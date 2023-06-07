package Assignment7.Assignment7_4;

public class BicycleFactory implements CycleFactory{
    @Override
    public Cycle getCycle() {
        return new Bicycle();
    }
}
