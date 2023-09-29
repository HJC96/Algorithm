import java.util.Stack;

class Solution {
    Stack<Character> stk = new Stack<Character>();

    boolean solution(String s) {
    for(int i=0;i<s.length();i++){
        if(s.charAt(i) == '('){
            stk.add('(');
        }else{
            if(stk.isEmpty() == false){
                if(stk.peek() == ')'){
                    return false;
                }
                else {
                    stk.pop();
                }    
            }
            else{
                return false;
            }
        }
    }
        return stk.isEmpty();
    }
}
