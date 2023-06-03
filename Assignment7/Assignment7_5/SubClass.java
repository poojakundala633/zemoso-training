package Assignment7.Assignment7_5;

public class SubClass extends Outer {
    public SubClass(int x) {
        super(x);
    }

    public class SubInnerClass extends InnerClass {

        public SubInnerClass(int y) {
            super(y);
        }

    }
}