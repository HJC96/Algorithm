import java.io.*;
import java.util.*;
import java.util.stream.IntStream;


class Solution {
    public int solution(int[] num_list) {
        int oddSum = IntStream.range(0, num_list.length)
                              .filter(i -> i % 2 == 0)  // 홀수 번째 원소 (인덱스는 0부터 시작하므로 짝수 인덱스)
                              .map(i -> num_list[i])
                              .sum();
        
        int evenSum = IntStream.range(0, num_list.length)
                               .filter(i -> i % 2 != 0)  // 짝수 번째 원소 (인덱스는 0부터 시작하므로 홀수 인덱스)
                               .map(i -> num_list[i])
                               .sum();
        
        return Math.max(oddSum, evenSum);
    }
}