import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String tmp=""; 
        if(n%2 == 0) tmp += "even";
        else         tmp +=  "odd";
        System.out.print(n + " is "+tmp);
    }
}