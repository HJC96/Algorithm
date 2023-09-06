import java.io.*;
import java.util.*;

class Solution {

    static List<List<Integer>> graph = new ArrayList<>();

    public int dfs(int wolf, int sheep, int CurrNode, List<Integer> nextNodes, int[] info){
        if(info[CurrNode] == 0) sheep++;
        else wolf++;
        
        int ans = sheep;
        if(sheep <= wolf)
            return ans;
        
        for(int i=0;i<nextNodes.size();i++){
            List<Integer> stackNode = new ArrayList<>(nextNodes);
            int nextNode = nextNodes.get(i);
            stackNode.remove((Integer)nextNode);
            stackNode.addAll(graph.get(nextNode));
            
            
            ans = Math.max(ans, dfs(wolf, sheep, nextNode, stackNode, info));
            
        }
        return ans;
    }
    
    public int solution(int[] info, int[][] edges) {
        int graphLength = info.length;
        
        for(int i=0;i<graphLength;i++){
            graph.add(new ArrayList<>());
        }
        
        int edgeLength = edges.length;
        for(int i=0;i<edgeLength;i++){
            graph.get(edges[i][0]).add(edges[i][1]);
        }
        
        List<Integer> st = new ArrayList<>();
        for (int i : graph.get(0)) {
            st.add(i);
        }
        
        return dfs(0, 0, 0, st, info);
    }
}