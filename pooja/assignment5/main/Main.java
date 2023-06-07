package pooja.assignment5.main;
import pooja.assignment5.data.Data;
import pooja.assignment5.singleton.Singleton;

public class Main {
    public static void main(String[] args) {
        Data myData = new Data();
        myData.printVariables();
        Singleton mySingleton = new Singleton();
        //Singleton singletonObject = Singleton.SingletonIni("Hello");
        mySingleton.printString();
    }
}
