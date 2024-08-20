import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<int[]> arr = new ArrayList<>();
        List<Integer> arrY = new ArrayList<>();
        List<Integer> arrX = new ArrayList<>();
        int[] answer = new int[n];
        Arrays.fill(answer, Integer.MAX_VALUE);

        // 입력 받기
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            arr.add(new int[]{a, b});
            arrY.add(b);
            arrX.add(a);
        }

        // 만날 장소 정하기
        for (int y : arrY) {
            for (int x : arrX) {
                List<Integer> dist = new ArrayList<>();

                // 만날 장소로 각각의 점들이 오는 비용 계산하기
                for (int[] point : arr) {
                    int d = Math.abs(point[0] - x) + Math.abs(point[1] - y);
                    dist.add(d);
                }

                // 가까운 순서대로 정렬하기
                Collections.sort(dist);

                int tmp = 0;
                for (int i = 0; i < dist.size(); i++) {
                    tmp += dist.get(i);
                    answer[i] = Math.min(tmp, answer[i]);
                }
            }
        }

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int ans : answer) {
            sb.append(ans).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}