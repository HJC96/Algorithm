import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T1 = Integer.parseInt(br.readLine());
        String[] M1 = br.readLine().split(" ");
        long[] arr1 = new long[T1];
        for(int i=0;i<T1;i++){
            arr1[i] = Long.parseLong(M1[i]);
        }

        int T2 = Integer.parseInt(br.readLine());
        String[] M2 = br.readLine().split(" ");
        long[] arr2 = new long[T2];
        for(int i=0;i<T2;i++){
            arr2[i] = Long.parseLong(M2[i]);
        }

        Arrays.sort(arr1);

        for(int i=0;i<T2;i++) {
            int index = Arrays.binarySearch(arr1, arr2[i]);
            if(index >=0 )
            {
                sb.append("1\n");
                continue;
            }
            else{
                sb.append("0\n");
                continue;
            }
        }
        System.out.print(sb);
    }
}