package Assignment7.Assignment7_4;

public class CycleFactoryDemo {
    public static void main(String[] args) {
        Cycle cycle;
        CycleFactory cycleFactory;
        cycleFactory=new UnicycleFactory();
        cycle = cycleFactory.getCycle();
        cycle.display();

        cycleFactory=new BicycleFactory();
        cycle = cycleFactory.getCycle();
        cycle.display();

        cycleFactory=new TricycleFactory();
        cycle = cycleFactory.getCycle();
        cycle.display();

    }
}
