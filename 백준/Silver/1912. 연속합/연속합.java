import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int N = Integer.parseInt(input);
        String[] numbers = br.readLine().split(" ");
        int [] sum = new int[N+1]; // 앞 한개 버퍼
        int answer = Integer.MIN_VALUE;
        for(int i=1;i<N+1;i++){
            int num = sum[i-1] + Integer.parseInt(numbers[i-1]);
            if(num<=0){
                sum[i] = 0;
            }else{
                sum[i] = sum[i-1] + Integer.parseInt(numbers[i-1]);
            }
            answer = Math.max(answer, num);
        }
        System.out.println(answer);
    }
}