import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        HashMap<Long,Long> h = new HashMap<Long,Long>();
        int N = Integer.parseInt(br.readLine());
        String[] num = br.readLine().split(" ");
        for(int i=0;i<N;i++){
            h.put(Long.parseLong(num[i])+10000000,h.getOrDefault(Long.parseLong(num[i])+10000000, Long.valueOf(0))+1);
        }

        int K = Integer.parseInt(br.readLine());
        String[] num2 = br.readLine().split(" ");
        for(int i=0;i<K;i++) {
            sb.append(Long.toString(h.getOrDefault(Long.parseLong(num2[i])+10000000, Long.valueOf(0))) +" ");
        }
        System.out.print(sb);


    }
}