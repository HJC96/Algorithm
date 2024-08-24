import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int M = Integer.parseInt(line[1]);

        line = br.readLine().split(" ");
        List<Integer> numbers = new ArrayList<>();
        long right = Integer.MIN_VALUE;
        long left = 1;
        for(String l:line){
            int num = Integer.parseInt(l);
            numbers.add(num);
            right = Math.max(right, num);
        }
        numbers.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        long answer = 0;
        long wood = 0;
        while(left<=right) {
            wood = 0;
            long mid = (left+right)/2;
            for(int i= numbers.size()-1;i>=0;i--){
                if(numbers.get(i) - mid > 0) {
                    wood += (numbers.get(i) - mid);
                }
            }
            if(wood >= M){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }

        System.out.println(right);
    }
}
