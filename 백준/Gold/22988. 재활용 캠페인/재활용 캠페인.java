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

        // 배열을 오름차순으로 정렬
        Arrays.sort(arr);

        int s = 0;
        int e = N - 1;
        int remain = 0;  // 남은 용기 수
        int cnt = 0;     // 꽉 찬 용기의 수

        while (s <= e) {
            // 큰 용기가 Xml일 경우 바로 처리
            if (arr[e] == X) {
                cnt++;
                e--;
                continue;
            }

            // 남은 용기가 하나일 경우
            if (s == e) {
                remain++;
                break;
            }

            // 두 용기를 합쳐서 조건 만족 여부 확인 (double로 처리)
            if (arr[e] + arr[s] >= (double) X / 2) {
                cnt++;
                s++;
                e--;
            } else {
                // 용량이 모자라면 작은 용기만 남김
                s++;
                remain++;
            }
        }

        // 남은 용기들을 3개씩 묶어 추가로 꽉 찬 용기를 만듦
        cnt += remain / 3;
        System.out.println(cnt);
    }
}
