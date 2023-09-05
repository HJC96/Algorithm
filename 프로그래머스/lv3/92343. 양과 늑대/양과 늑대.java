import java.io.*;
import java.util.*;

class Solution {
    public static int dfs(int currNode, int w, int s, List<Integer> nextNodes, int[] info) {
        int animal = info[currNode];
        if (animal == 0) {
            s++;
        } else {
            w++;
        }

        int ans = s;

        if (w >= s) {
            return ans;
        }

        for (int i = 0; i < nextNodes.size(); i++) {
            List<Integer> next = new ArrayList<>(nextNodes);
            int nextNode = nextNodes.get(i);
            next.remove((Integer)nextNode);
            next.addAll(graph.get(nextNode));
            ans = Math.max(ans, dfs(nextNode, w, s, next, info));
        }

        return ans;
    }

    static List<List<Integer>> graph = new ArrayList<>();

    public static int solution(int[] info, int[][] edges) {
        graph.clear();
        for (int i = 0; i < info.length; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            graph.get(edges[i][0]).add(edges[i][1]);
        }

        List<Integer> st = new ArrayList<>();
        for (int i : graph.get(0)) {
            st.add(i);
        }
        return dfs(0, 0, 0, st, info);
    }
}