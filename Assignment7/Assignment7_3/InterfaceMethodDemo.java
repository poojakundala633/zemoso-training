package Assignment7.Assignment7_3;

public class InterfaceMethodDemo {
    public static void main(String[] args) {
        CombinedClass combinedClass=new CombinedClass();
        InterfaceMethod interfaceMethods=new InterfaceMethod();

        interfaceMethods.InterfaceMethod1(combinedClass);
        interfaceMethods.InterfaceMethod2(combinedClass);
        interfaceMethods.InterfaceMethod3(combinedClass);
        interfaceMethods.InterfaceMethod4(combinedClass);
        combinedClass.concreteMethod();
    }


}
