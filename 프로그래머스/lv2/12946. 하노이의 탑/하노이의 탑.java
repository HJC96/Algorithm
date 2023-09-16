import java.io.*;
import java.util.*;

class Solution {
    List<List<Integer>> path = new ArrayList<>();
    List<Integer> p = new ArrayList<>();
    void dfs(int numOfCircle,int curNode, int otherNode, int targetNode){
        List<Integer> tmpAns = new ArrayList<>();
        if(numOfCircle == 0) {
            // p.add(curNode);
            return;
        }
        dfs(numOfCircle-1, curNode, targetNode, otherNode);
        tmpAns.add(curNode);
        tmpAns.add(targetNode);
        path.add(tmpAns);
        // System.out.println(curNode);
        dfs(numOfCircle-1, otherNode, curNode,targetNode);
        
    }
    
    public int[][] solution(int n) {
        
        
        dfs(n, 1, 2, 3);
        int idx=0;
        int[][] answer = new int[path.size()][2];
        for(List<Integer> p:path){
            int tmp=0;
            for(int i:p){
                answer[idx][tmp++] = i;
            }
            idx+=1;
        }
        return answer;
    }
}