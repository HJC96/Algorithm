import java.io.*;
import java.util.*;

class Solution {
    int answer = 0;
    Map<Integer, List<Integer>> hashmap = new HashMap<>(); 
    void dfs(int wolf, int sheep, int curNode, List<Integer> nextNodes, int[] info){
        if(info[curNode] == 0) sheep++;
        else wolf++;
        if(wolf>=sheep){
            answer = Math.max(answer, sheep);
            return;
        }
        
        for(int i=0;i<nextNodes.size();i++){
            int nextNode = nextNodes.get(i);
            List<Integer> stackNodes = new ArrayList<>(nextNodes);
            stackNodes.remove((Integer)nextNode);
            for(int num:hashmap.get(nextNode))
                stackNodes.add(num);   
            dfs(wolf,sheep,nextNode,stackNodes,info);
        }
        answer = Math.max(answer, sheep);
    }
    
    public int solution(int[] info, int[][] edges) {
        
        /* Make Graph */
        int len = info.length;
        for(int i=0;i<len;i++)
            hashmap.put(i, new ArrayList<>());
        for(int[] e:edges){
            if(hashmap.get(e[0]) == null){
                List<Integer> lis = new ArrayList<>();
                lis.add(e[1]);
                hashmap.put(e[0],lis);
            }else{
                hashmap.get(e[0]).add(e[1]);
            }
        }
        List<Integer> nextNodes = new ArrayList<>();
        nextNodes.addAll(hashmap.get(0));
        /* Logic */
        dfs(0,0,0,nextNodes,info);
        
        
        return answer;
    }
}