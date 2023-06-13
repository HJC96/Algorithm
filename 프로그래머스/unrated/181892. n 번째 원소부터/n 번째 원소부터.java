import java.util.*;
import java.util.stream.IntStream;

public class Solution {
    public int[] solution(int[] num_list, int n) {
        return IntStream.range(n - 1, num_list.length)
                        .map(i -> num_list[i])
                        .toArray();
    }
}
