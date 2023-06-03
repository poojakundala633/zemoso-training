package Collections;
import java.util.*;
public class Collection {
    public static void main(String[] args) {
        ArrayList<String> message = new ArrayList<>();
        message.add("hiii");
        message.add("hello");
        message.add("hel");
        System.out.println(message);
        message.add(2,"hell");
        System.out.println(message);
        message.set(0,"pooja");
        System.out.println(message);
        message.remove("hello");
        System.out.println(message);
        for(String i:message){
            System.out.println(i);
        }
        System.out.println(message.get(0));
    }
}
