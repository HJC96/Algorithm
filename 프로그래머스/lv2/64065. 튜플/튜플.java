import java.io.*;
import java.util.*;


class Solution {
    public int[] solution(String s) {
        
        List<List<Integer>> parsedData = parseData(s);
        
        Collections.sort(parsedData, (a,b)->{
            return Integer.compare(a.size(), b.size());
        });
        // Set<Integer> se = new HashSet<>();
        List<Integer> ans = new ArrayList<>();
        for(List<Integer> lis:parsedData){
            for(int i:lis){
                if(ans.contains(i) == false)
                    ans.add(i);
            }
        }
        int idx=0;
        int[] answer = new int[ans.size()];
        for(int i:ans) answer[idx++] = i;
        return answer;
    }
    public static List<List<Integer>> parseData(String data) {
        // 바깥쪽 중괄호 제거
        data = data.substring(1, data.length() - 1);
        
        // 각 그룹을 분리
        String[] groups = data.split("\\},\\{");
        
        List<List<Integer>> resultList = new ArrayList<>();
        for (String group : groups) {
            group = group.replace("{", "").replace("}", "");
            String[] numbers = group.split(",");
            
            List<Integer> intList = new ArrayList<>();
            for (String number : numbers) {
                intList.add(Integer.parseInt(number));
            }
            
            resultList.add(intList);
        }

        return resultList;
    }
}