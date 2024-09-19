import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(String myString) {
        int ans = 0;
        List<Integer> ansList = new ArrayList<>();
        
        for (int i = 0; i < myString.length(); i++) {
            if (myString.charAt(i) == 'x') {
                ansList.add(ans);
                ans = 0;
            } else {
                ans++;
            }
        }
        ansList.add(ans);  // 마지막 'x' 이후의 문자 개수를 추가
        
        return ansList.stream().mapToInt(Integer::intValue).toArray();
    }
}