import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String answer = "";
        String a = sc.next();
        for(int i=0;i<a.length();i++){
            if(a.charAt(i) - 'a' >= 0)  answer += Character.toUpperCase(a.charAt(i));
            else                        answer += Character.toLowerCase(a.charAt(i));
        }
        System.out.print(answer);
    }
}