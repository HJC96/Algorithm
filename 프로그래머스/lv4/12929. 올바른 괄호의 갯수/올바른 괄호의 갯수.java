import java.util.*;

class Solution {
    private int n;
    private int answer = 0;

    public int solution(int n) {
        this.n = n;
        generateParenthesis(0, 0, "");
        return answer;
    }

    private void generateParenthesis(int open, int close, String current) {
        if (open == n && close == n) {
            answer++;
            return;
        }

        if (open < n) {
            generateParenthesis(open + 1, close, current + "(");
        }
        if (close < open) {
            generateParenthesis(open, close + 1, current + ")");
        }
    }
}
