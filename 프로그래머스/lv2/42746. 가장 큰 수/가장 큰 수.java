import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        List<String> ans = new ArrayList<>();
        
        for(int num : numbers)
            ans.add(Integer.toString(num));
            
        Collections.sort(ans, (a, b) -> (b + a).compareTo(a + b));
        
        if(ans.get(0).equals("0"))
            return "0";
            
        for(String str : ans)
            answer += str;
            
        return answer;
    }
}
