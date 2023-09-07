import java.io.*;
import java.util.*;


class Solution {
    int INFINITY = 99999999;
    public int solution(int n, int[][] edge) {
        int answer = 0;
        Map<Integer, Integer> hashData = new HashMap<>();
        List<List<Integer>> nodes = new ArrayList<>();
        
        for(int i=0;i<=n;i++){
            nodes.add(new ArrayList<>());
            hashData.put(i,INFINITY);
        }
        hashData.put(0,0);
        
        for(int[] e:edge){
            nodes.get(e[0]).add(e[1]);
            nodes.get(e[1]).add(e[0]);
        }
        
        Queue<Pair> que = new LinkedList<>();
        que.add(new Pair(1,0));
        
        while(!que.isEmpty()){
            Pair p = que.poll();
            if(hashData.get(p.node) > p.distance){
                hashData.put(p.node, p.distance);
            }else{
                continue;
            }
            int len = nodes.get(p.node).size();
            for(int i=0;i<len;i++){
                int nextNode = nodes.get(p.node).get(i);
                que.add(new Pair(nextNode, p.distance+1));
            }
        }
        List<Map.Entry<Integer, Integer>> lis = new ArrayList<>();
        for(Map.Entry<Integer, Integer> m:hashData.entrySet()){
            lis.add(m);
        }
        
        Collections.sort(lis, (a,b)->{
            return Integer.compare(a.getValue(),b.getValue());
        });
        
        int tmp = lis.get(lis.size()-1).getValue();
        for(int i=lis.size()-1;i>=0;i--){
            if(tmp != lis.get(i).getValue()) break;
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