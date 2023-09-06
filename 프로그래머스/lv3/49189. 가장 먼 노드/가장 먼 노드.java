import java.io.*;
import java.util.*;

class Solution {
    int INFINITY = 999999999;
    static List<List<Integer>> graph = new ArrayList<>();
    static Map<Integer, Integer> hashDistance = new HashMap<>();
    
   

    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        /* Set Graph */
        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
            hashDistance.put(i,INFINITY);
        }
        hashDistance.put(0,0);
        int edgeLength = edge.length;
        for(int i=0;i<edgeLength;i++){
            graph.get(edge[i][0]).add(edge[i][1]);
            graph.get(edge[i][1]).add(edge[i][0]);
        }


        
        /* BFS */
        Queue<Pair> que = new LinkedList<>();
        que.add(new Pair(1,0));
        
        while(!que.isEmpty()){
            Pair pair = que.poll();
            if(hashDistance.get(pair.node) > pair.distance){
                hashDistance.put(pair.node, pair.distance);
            }else{
                continue;
            }
            for(int i=0;i<graph.get(pair.node).size();i++){
                int next = graph.get(pair.node).get(i);
                Pair p = new Pair(next, pair.distance+1);
                if(hashDistance.get(next) > pair.distance+1) que.add(p);
            }
        }
        
        /* Find Answer */
        List<Map.Entry<Integer, Integer>> lists = new ArrayList<>();
        for(Map.Entry<Integer, Integer> e:hashDistance.entrySet()){
            lists.add(e);
        }
        
        Collections.sort(lists, (a,b)->{
            return Integer.compare(a.getValue(),b.getValue());
        });
        
        int lastValue = (int)lists.get(lists.size()-1).getValue();
        for(int i=lists.size()-1;i>=0;i--){
            if(lastValue != lists.get(i).getValue()) break;
            answer++;
        }
        return answer;
    }
}

class Pair{
    int node;
    int distance;
    public Pair(int node, int distance){
        this.node = node;
        this.distance = distance;
    }
}

/*
        1 2 3
        2 1 3 4 5
        3 1 2 4 6
        4 2 3 
        5 2
        6 3
 */      
        