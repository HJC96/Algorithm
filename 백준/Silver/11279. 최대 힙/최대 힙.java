import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        PriorityQueue<Long> pq = new PriorityQueue<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int i=0;i<T;i++){
            long num = Long.parseLong((br.readLine()));
            if(num == 0){
                if(pq.isEmpty()){
                    sb.append("0\n");
                    continue;
                }
                sb.append(-1 * pq.poll() + "\n");
            }
            else{
                pq.add(-1 * num);
            }
        }
        System.out.print(sb);
    }
}