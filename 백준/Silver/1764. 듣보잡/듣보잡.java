import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> h = new HashMap<String, Integer>();
        StringBuilder sb = new StringBuilder();
        ArrayList<String> s = new ArrayList<String>();
        String[] arr = br.readLine().split(" ");
        int N = Integer.parseInt(arr[0]);
        int M = Integer.parseInt(arr[1]);

        for(int i=0;i<N;i++){
            String in = br.readLine();
            h.put(in,h.getOrDefault(in,0) + 1);
        }

        int ans=0;
        for(int i=0;i<M;i++){
            String in = br.readLine();
            int value = h.getOrDefault(in,0);
            if(value == 0){
                continue;
            }
            else{
                ans++;
                //sb.append(in+'\n');
                s.add(in);
            }
        }
        sb.insert(0,String.valueOf(ans)+'\n');
        Collections.sort(s);
        for(String elem:s){
            sb.append(elem+'\n');
        }
        System.out.print(sb);
    }
}