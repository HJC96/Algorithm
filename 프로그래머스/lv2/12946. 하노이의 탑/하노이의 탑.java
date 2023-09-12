import java.io.*;
import java.util.*;

class Solution {
    List<List<Integer>> res = new ArrayList<>();
    
    void hanoi(int numOfCircle, int from, int to, int other){
        if(numOfCircle == 0) return;
        hanoi(numOfCircle-1,from, other,to);
        List<Integer> l = new ArrayList<>();
        l.add(from); l.add(to);
        res.add(l);
        hanoi(numOfCircle-1,other, to,from);
    }
    
    public int[][] solution(int n) {
        hanoi(n, 1, 3, 2);
        int[][] answer = new int[res.size()][2];
        for(int i=0;i<res.size();i++){
            for(int j=0;j<2;j++){
                answer[i][j] = res.get(i).get(j);
            }
        }
        return answer;
    }
}
