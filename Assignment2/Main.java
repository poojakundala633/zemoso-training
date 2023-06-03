package Assignment2;

import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("enter a string: ");
        String input =sc.nextLine();

        if(containsAllLetters(input)){
            System.out.println("the input string contains all the letters.");
        }else {
            System.out.println("the input string doesnot contains all the letters ");
        }
    }

    private static boolean containsAllLetters(String input) {
        Set<Character> seenLetters = new HashSet<>();
        for(int i=0;i<input.length();i++){
            char c =input.charAt(i);
            seenLetters.add(c);

        }
        return  seenLetters.size() ==26;
    }
}

//Time Complexity
//overall the time complexity is O(n) time

//Space Complexity
//O(n)