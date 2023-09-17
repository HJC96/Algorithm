import java.io.*;
import java.util.*;


class Solution {
    List<Integer> ansList = new ArrayList<>();
    void dfs(int n){
        ansList.add(n);
        if(n == 1) return ;
        else if(n % 2 == 0){
            dfs(n/2);
        }
        else{
            dfs(3*n+1);
        }
    }
    
    public int[] solution(int n) {
        dfs(n);
        int [] ans = new int[ansList.size()];
        int idx=0;
        for(int i:ansList){
            ans[idx++] = i;
        }
        return ans;
    }
}