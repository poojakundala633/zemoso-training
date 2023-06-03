package Collections;

import java.util.ArrayList;
import java.util.Scanner;

public class StringColl {
    public static void main(String[] args){
        ArrayList<String> names = new ArrayList<>();
        System.out.println("enter n:-");
        Scanner sc =new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=0;i<=n;i++){
            String name = sc.nextLine();
            names.add(name);

        }
        System.out.println(names);
        System.out.println("removing duplicates");
        ArrayList<String> people = new ArrayList<>();
       for(String i:names)
        {
            if(!names.contains(i)){
                people.add(i);
            }
        }
        System.out.println(people);
    }
}
