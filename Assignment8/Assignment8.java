package Assignment8;

public class Assignment8 {
    public static void main(String[] args) {
        CustomExceptionDemo obj=new CustomExceptionDemo();
        try {
            obj.CustomMethod();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        finally {
            System.out.println("Successfully Executed");
        }

    }


}
