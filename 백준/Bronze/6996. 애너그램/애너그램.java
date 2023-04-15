import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            boolean ans = true;
            String[] st = br.readLine().split(" ");
            char[] arr1 = st[0].toCharArray();
            char[] arr2 = st[1].toCharArray();
            Arrays.sort(arr1);
            Arrays.sort(arr2);

            if(Arrays.equals(arr1,arr2) == true)
                sb.append(st[0] + " & " + st[1] + " are anagrams." + "\n");
            else
                sb.append(st[0]+" & "+st[1]+" are NOT anagrams." + "\n");

        }
        System.out.print(sb);
    }
}
