import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<N;i++){
            String[] line = br.readLine().split(" ");
            int a = Integer.parseInt(line[0]);
            int b = Integer.parseInt(line[1]);
            int mul = a*b;
            while(b!=0){
                int r = a%b;
                a = b;
                b = r;
            }
            ans.add(mul/a);
        }
        for(int i:ans){
            System.out.println(i);
        }
    }
}

