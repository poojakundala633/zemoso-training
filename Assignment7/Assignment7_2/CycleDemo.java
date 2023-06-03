package Assignment7.Assignment7_2;

public class CycleDemo {

    public static void main(String[] args) {
        Cycle[] cycles=new Cycle[3];
        cycles[0]=new Unicycle();
        cycles[1]=new Bicycle();
        cycles[2]=new Tricycle();

        for(int i=0;i<3;i++) {
            cycles[i].display();
        }

        for(int i=0;i<3;i++) {
            //Uncomment to below line to see that, the Cycle doesn't have balance()
            //cycles[i].balance();
        }

        for(int i=0;i<3;i++) {
            if(cycles[i] instanceof Unicycle) {
                Unicycle unicycle=(Unicycle) cycles[i];
                unicycle.balance();
            }
            else if(cycles[i] instanceof Bicycle) {
                Bicycle bicycle=(Bicycle) cycles[i];
                bicycle.balance();
            }
            else {
                Tricycle tricycle=(Tricycle) cycles[i];
                //uncomment the below line to see that tricycle doesn't have a balance()
                //tricycle.balance();
            }
        }
    }

}

