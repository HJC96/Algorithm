import java.io.*;
import java.util.*;

class Solution {
    List<List<Integer>> graph = new ArrayList<>();
    int answer = 0;
    void choose(int wolf, int sheep, int curNode, List<Integer> nextNodes, int[] info){
        if(info[curNode] == 0) sheep++;
        else wolf++;
        answer = Math.max(answer, sheep);
        if(wolf >=sheep) {
            // answer = Math.max(answer, sheep);
            return;
        }
        
        for(int i=0;i<nextNodes.size();i++){
            int nextNode = nextNodes.get(i);
            List<Integer> stackNodes = new ArrayList<>(nextNodes);
            stackNodes.remove((Integer)nextNode);
            stackNodes.addAll(graph.get(nextNode));
            choose(wolf, sheep, nextNode, stackNodes, info);
        }
        
    }
    public int solution(int[] info, int[][] edges) {
        
        for(int i=0;i<info.length;i++){
            graph.add(new ArrayList<>());
        }
            
        for(int[] e:edges){
            graph.get(e[0]).add(e[1]);
        }
        List<Integer> nextNodes = new ArrayList<>();
        nextNodes.addAll(graph.get(0));
        choose(0, 0, 0, nextNodes, info);
        
        return answer;
    }
}