import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long k = Long.parseLong(br.readLine());
        List<Long> answer = new ArrayList<>();

        while(k%2==0){
            k/=2;
            answer.add(2L);
        }

        for(int i=3;i<=Math.sqrt(k);i+=2){
            while(k%i==0){
                k/=i;
                answer.add((long) i);
            }
        }

        if(k>2){
            answer.add(k);
        }

        System.out.println(answer.size());
        for(long ans:answer){
            System.out.print(ans + " ");
        }
    }
}