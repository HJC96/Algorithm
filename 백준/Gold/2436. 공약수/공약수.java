import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);

        long target = (long) a *b;
        long ans = 0;
        List<Long> nums = new ArrayList<>();
        for(int i=2;i<=(int)Math.sqrt(target);i++){
            long temp = target % i ;
            if(temp != 0) continue;
            long tmp = target / i ;

            ans = gcd(i, tmp);
            if(ans == a){
                nums.add((long) i);
            }
        }
        long answer = nums.get(nums.size()-1);
        System.out.println(answer + " " + target/answer);


    }

    public static long gcd(long a, long b){
        long tmp = 0;
        while(a%b!=0){
            tmp=a%b;
            a=b;
            b = tmp;
        }
        return b;
    }
    public static long lcm(long a, long b, long gcd){
        return a*b/gcd;
    }
}

