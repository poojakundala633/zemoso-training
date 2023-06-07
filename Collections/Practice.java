package Collections;

import java.util.ArrayList;
import java.util.*;

public class Practice {
    public static void main(String[] args){
        ArrayList<Integer> marks = new ArrayList<>();
        System.out.println("enter n:-");
        Scanner sc=new Scanner(System.in);
        int n= sc.nextInt();
        for(int i=0;i<n;i++){
            int mark = sc.nextInt();
            marks.add(mark);
        }
        Collections.sort(marks);
        System.out.println(marks);
        System.out.println("removing of duplicates");
        ArrayList<Integer> balance = new ArrayList<>();
        for (Integer i:marks) {
            if(!balance.contains(i)) {
                balance.add(i);
            }
        }
        System.out.println(balance);

    }
}
