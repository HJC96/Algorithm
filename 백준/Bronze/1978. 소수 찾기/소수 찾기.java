import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int answer = 0;
        String[] arr =br.readLine().split(" ");

        List<Integer> numbers = new ArrayList<>();
        for(int i=0;i<n;i++)
            numbers.add(Integer.parseInt(arr[i]));

        for(int x:numbers){
            if(x==1) continue;
            boolean isPrime = true;
            int max = (int)Math.sqrt(x);
            for(int i=2;i<=max;i++){
                if(x%i==0){
                    isPrime = false;
                }
            }
            if(isPrime){
                answer++;
            }
        }
        System.out.println(answer);
    }
}