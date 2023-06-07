package pooja.assignment5.data;


public class Data{
   private int num;
   private char alpha;

   public void printVariables(){
        System.out.println("Integer:-" + num);
        System.out.println("Character:-" + alpha);

    }

   public void printLocalVariables(){
        int myInt;
        char myChar;
       //System.out.println("myInt " + myInt);   giving error because these are not initialized
       //System.out.println("myChar " + myChar);
   }
}
/*public class Main {
    public static void main(String[] args) {
        Data myData = new Data();
        myData.printVariables();
    }
}*/

