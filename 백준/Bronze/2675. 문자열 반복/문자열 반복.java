import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int i=0;i<T;i++){
            String[] input = br.readLine().split(" ");
            String tmp = "";
            for(int k=0; k<input[1].length();k++){
                for(int j=0;j<Integer.parseInt(input[0]);j++){
                    tmp += input[1].charAt(k);
                }
            }
            sb.append(tmp + "\n");
        }
        System.out.print(sb);
    }
}