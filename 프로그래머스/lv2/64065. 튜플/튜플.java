import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = {};
        int[][] parsedData = parseData(s);

        return answer;
    }
    
    public static int[][] parseData(String data) {
        // 바깥쪽 중괄호 제거
        data = data.substring(1, data.length() - 1);
        
        // 각 그룹을 분리
        String[] groups = data.split("\\},\\{");
        
        ArrayList<int[]> resultList = new ArrayList<>();
        for (String group : groups) {
            group = group.replace("{", "").replace("}", "");
            String[] numbers = group.split(",");
            int[] intArray = new int[numbers.length];
            for (int i = 0; i < numbers.length; i++) {
                intArray[i] = Integer.parseInt(numbers[i]);
            }
            resultList.add(intArray);
        }

        return resultList.toArray(new int[0][]);
    }
}