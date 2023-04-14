import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String st1 = br.readLine();
        String st2 = br.readLine();
        int num1 = Integer.parseInt(st1);
        int num2 = Integer.parseInt(st2);

        System.out.println(num1 + num2);
    }
}