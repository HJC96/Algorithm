import java.util.OptionalInt;
import java.util.stream.IntStream;

class Solution {
    public int solution(int[] arr, int idx) {
        return IntStream.range(idx, arr.length) // idx보다 큰 인덱스 범위
                .filter(i -> arr[i] == 1) // 1인 경우만 필터링
                .findFirst() // 첫 번째 요소를 찾기
                .orElse(-1); // 없으면 -1 반환
    }
}
