package Assignment9;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.*;
import java.util.Scanner;
public class Assignment9 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a Sentence");
        String inp= sc.nextLine();
        String regex="^[A-Z].*\\.$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(inp);
        if(matcher.matches()) {
            System.out.println("The Sentence starts with capital and end with period");
        }
        else {
            System.out.println("The Sentence doesn't meet the expectations ");
        }
    }
}
