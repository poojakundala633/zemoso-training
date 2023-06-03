package Solid_principle_assignment;

import java.util.Scanner;

public class squaresum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = 0;
        for(int i = n;i>=1;i--){
             ans += (i*i);
        }
        System.out.println(ans);
    }
}
