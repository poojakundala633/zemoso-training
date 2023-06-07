package Assignment7.Assignment7_5;

public class InnerClassDemo {
    public static void main(String[] args) {
        SubClass subClass=new SubClass(5);
        SubClass.SubInnerClass subInnerClass=subClass.new SubInnerClass(10);
        System.out.println("OuterClass Value:"+subClass.x);
        System.out.println("InnerClass Value:"+subInnerClass.y);
    }
}
