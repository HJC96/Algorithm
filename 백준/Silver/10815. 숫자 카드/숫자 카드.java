import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        HashMap<Long,Long> h = new HashMap<Long,Long>();
        int N = Integer.parseInt(br.readLine());
        String[] arr1 = br.readLine().split(" ");

        for(int i=0;i<N;i++){
            h.put(Long.parseLong(arr1[i])+10000000,h.getOrDefault(arr1[i],Long.valueOf(0)+1));
        }

        int M = Integer.parseInt(br.readLine());
        String[] arr2 = br.readLine().split(" ");

        for(int i=0;i<M;i++){
            long value = h.getOrDefault(Long.parseLong(arr2[i])+10000000,Long.valueOf(0));
            if(value == 0){
                sb.append(0 + " ");
            }
            else{
                sb.append(1 + " ");
            }
        }
        System.out.print(sb);
    }
}
