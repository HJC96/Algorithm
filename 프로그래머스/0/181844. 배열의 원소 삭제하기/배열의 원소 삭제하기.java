import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[] delete_list) {
        List<Integer> resultList = new ArrayList<>();
        Map<Integer, Boolean> hashMap = new HashMap<>();
        
        // delete_list의 값을 HashMap에 저장
        for (int i : delete_list) {
            hashMap.put(i, true);
        }
        
        // arr 배열에서 delete_list에 없는 값만 resultList에 추가
        for (int i : arr) {
            if (!hashMap.containsKey(i)) {
                resultList.add(i);
            }
        }
        
        // resultList를 int 배열로 변환하여 반환
        int[] answer = resultList.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}