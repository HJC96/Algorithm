import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] str = br.readLine().split(" ");
        StringBuilder sb = new StringBuilder();
        for(String s:str){
            sb.append(s);
        }
        System.out.print(sb.toString());
    }
}