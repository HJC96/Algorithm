import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        long X = Long.parseLong(line[1]);

        line = br.readLine().split(" ");
        long[] arr = new long[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(line[i]);
        }

        Arrays.sort(arr);

        int s = 0;
        int e = N - 1;
        int remain = 0;  
        int cnt = 0; 

        while (s <= e) {
            if (arr[e] == X) {
                cnt++;
                e--;
                continue;
            }

            if (s == e) {
                remain++;
                break;
            }

            // 두 용기를 합쳐서 조건 만족 여부 확인 (double로 처리, 정수처리되면 제대로 계산 안됨.)
            if (arr[e] + arr[s] >= (double) X / 2) {
                cnt++;
                s++;
                e--;
            } else {
                s++;
                remain++;
            }
        }

        cnt += remain / 3;
        System.out.println(cnt);
    }
}
