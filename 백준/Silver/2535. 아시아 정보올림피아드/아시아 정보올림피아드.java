import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        String[][] arr = new String[T][3];
        for(int i=0;i<T;i++){
            String[] in = br.readLine().split(" ");
            arr[i][0] = in[0];
            arr[i][1] = in[1];
            arr[i][2] = in[2];
        }
        Arrays.sort(arr, new Comparator<String[]>(){
            public int compare(String[] o1, String[] o2){
                return Integer.parseInt(o2[2]) - Integer.parseInt(o1[2]);
            }
        });

        System.out.println(arr[0][0]+" "+arr[0][1]);
        System.out.println(arr[1][0]+" "+arr[1][1]);
        int idx=2;
        while (Integer.parseInt(arr[idx][0]) == Integer.parseInt(arr[0][0])) idx++;
        System.out.println(arr[idx][0] + " " + arr[idx][1]);

    }
}