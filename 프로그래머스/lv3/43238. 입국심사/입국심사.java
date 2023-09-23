import java.io.*;
import java.util.*;

public class Solution {
    public long solution(int n, int[] times) {
        int length = times.length;
        Arrays.sort(times);

        long maxTime = (long) times[length - 1] * n; // 가장 느린 사람에게 모든 일을 주는 경우
        long minTime = 1; // 최소 시간은 1
        long answer = maxTime; // 초기화

        while (minTime <= maxTime) {
            long averageTime = (minTime + maxTime) / 2;
            long tmp_n = 0;

            for (int i = 0; i < length; i++) {
                tmp_n += averageTime / times[i];
                if (tmp_n >= n) break; // n을 초과하면 더 이상 더할 필요 없음
            }

            if (tmp_n < n) {
                minTime = averageTime + 1;
            } else {
                answer = Math.min(answer, averageTime); // 가능한 답 중 최소값을 저장
                maxTime = averageTime - 1;
            }
        }

        return answer;
    }
}