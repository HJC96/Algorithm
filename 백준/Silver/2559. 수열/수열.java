import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);
        String[] numbers = br.readLine().split(" ");
        int[] sum = new int[N];
        sum[0] = Integer.parseInt(numbers[0]);
        for(int i=1;i<N;i++){
            sum[i] = sum[i-1] + Integer.parseInt(numbers[i]);
        }
        int tmp=0;
        for(int i=0;i<K;i++) tmp+=Integer.parseInt(numbers[i]);
        int answer = tmp;
        for(int i=K;i<N;i++){
            answer = Math.max(sum[i] - sum[i-K], answer);
        }
        System.out.println(answer);
    }
}