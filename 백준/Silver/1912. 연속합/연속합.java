import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int n = Integer.parseInt(str);
        String[] array = br.readLine().split(" ");
        if(n == 1) {System.out.println(array[0]); return;}
        int length = n;
        int[] arr = new int[length];
        long[] dp = new long[length];
        for (int i = 0; i < length; i++) arr[i] = Integer.parseInt(array[i]);
//        if(arr[0] > 0)
            dp[0] = arr[0];
//        else dp[0] = 0;

        long answer = arr[0];
        for(int i=1;i<n;i++) {
            dp[i] = Math.max(dp[i - 1] + arr[i], arr[i]);
            answer = Math.max(answer, dp[i]);
        }


        System.out.println(answer);
    }
}