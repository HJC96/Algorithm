import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int max = n;
        while(0<n){
            for(int i=2;i<=max;i++){
                if(n%i==0){
                    n/=i;
                    max = n;
                    System.out.println(i);
                    break;
                }
            }
            if(1==max)
                return;
        }
    }
}