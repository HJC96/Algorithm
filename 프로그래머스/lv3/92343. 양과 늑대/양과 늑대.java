import java.io.*;
import java.util.*;


class Solution {
    
    List<List<Integer>> graph = new ArrayList<>();
    
    public int dfs(int s, int w, int curNode, List<Integer> nextNodes, int[] info){
        if(info[curNode] == 0) s++;
        else w++;
        
        int ans = s;
        if(s <= w) return ans;
        
        for(int i=0;i<nextNodes.size();i++){
            int nextNode = nextNodes.get(i);
            List<Integer> stackNodes = new ArrayList<>(nextNodes);
            stackNodes.remove((Integer)nextNode);
            stackNodes.addAll(graph.get(nextNode));
            ans = Math.max(ans, dfs(s, w, nextNode,stackNodes,info));
        }
        return ans;
    }
    
    public int solution(int[] info, int[][] edges) {
        int answer = 0;
        int length = info.length;
        for(int i=0;i<length;i++){
            graph.add((new ArrayList<>()));
        }
        
        for(int[] edge:edges){
            graph.get(edge[0]).add(edge[1]);
        }
        
        List<Integer> nextNodes = new ArrayList<>();        
        for(int i:graph.get(0)){
            nextNodes.add(i);
        }
        return dfs(0, 0, 0, nextNodes, info);
    }
}