import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<String> stk = new Stack<String>();
        int N = Integer.parseInt(br.readLine());
        for(int i=0;i<N;i++){
            String[] in = br.readLine().split(" ");
            sb.append("Case #"+(i+1)+": ");
            for(int j=0;j<in.length;j++){
                stk.push(in[j]);
            }
            while(!stk.empty()){
                sb.append(stk.pop()+" ");
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}