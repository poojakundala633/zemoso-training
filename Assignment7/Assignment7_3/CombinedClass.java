package Assignment7.Assignment7_3;

public class CombinedClass extends ConcreteClass implements InheritInterface {


    @Override
    public void method7() {
        System.out.println("method 7 from inherit interface");
    }

    @Override
    public void method1() {
        System.out.println("method 1 from interface1");
    }

    @Override
    public void method2() {
        System.out.println("method 2 from interface1");
    }

    @Override
    public void method3() {
        System.out.println("method 3 from interface2");
    }

    @Override
    public void method4() {
        System.out.println("method 4 from interface2");
    }

    @Override
    public void method5() {
        System.out.println("method5 from interface3");
    }

    @Override
    public void method6() {
        System.out.println("method6 from interface3");
    }
}
