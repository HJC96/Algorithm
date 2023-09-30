import java.util.*;

class Solution {
    public String solution(String number, int k) {
        Stack<Character> stack = new Stack<>();
        char[] result = new char[number.length() - k];
        
        for(int i = 0; i < number.length(); i++){
            while(!stack.isEmpty() && stack.peek() < number.charAt(i) && k > 0){
                stack.pop();
                k--;
            }
            stack.push(number.charAt(i));
        }
        
        for(int i = 0; i < result.length; i++){
            result[i] = stack.get(i);
        }
        return new String(result);
    }
}
