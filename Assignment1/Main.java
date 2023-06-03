package Assignment1;

import java.io.File;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        File directory = new File("C:\\Users\\raosh\\IdeaProjects\\");
        Scanner sc = new Scanner(System.in);
        String s;
        while(true)
        {
            boolean flag= false;
            System.out.println("Enter File Name");
            s =sc.nextLine();
            String[] files = directory.list();
            for (String file : files){
                if (s.equals(file)){
                    flag = true;
                    System.out.println("File found!");
                    System.out.println(file);
                    System.out.println("AbsoluteFilePath : "+ directory.getAbsolutePath());
                }
            }
            if(!flag)
            {
                System.out.println("File not found");
                return;
            }
        }

    }
}



