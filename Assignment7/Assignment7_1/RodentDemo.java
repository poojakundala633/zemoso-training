package Assignment7.Assignment7_1;

public class RodentDemo {

    public static void main(String[] args) {
        Rodent[] rodents=new Rodent[3];
        rodents[0]=new Mouse();
        rodents[1]=new Gerbil();
        rodents[2]=new Hamster();
        System.out.println(" ");

        for(int i=0;i<3;i++) {
            rodents[i].display();
        }
        System.out.println(" ");

        for(int i=0;i<3;i++) {
            rodents[i].run();
        }
        System.out.println(" ");

        for(int i=0;i<3;i++) {
            rodents[i].close();
        }

    }

}
