package Assignment7.Assignment7_4;

public class TricycleFactory implements CycleFactory{
    @Override
    public Cycle getCycle() {
        return new Tricycle();
    }
}
