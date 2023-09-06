import java.io.*;
import java.util.*;


class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, List<Pair>> hashmap = new HashMap<>();
        
        int length = plays.length;
        for(int i=0;i<length;i++){
            if(hashmap.get(genres[i]) == null){
                List<Pair> lis = new ArrayList<>();
                Pair pair = new Pair(plays[i],i);
                lis.add(pair);
                hashmap.put(genres[i],lis);
            }
            else{
                Pair pair = new Pair(plays[i],i);
                hashmap.get(genres[i]).add(pair);
            }
        }
        List<Map.Entry<String, List<Pair>>> hashmapList = new ArrayList<>();
        for(Map.Entry<String, List<Pair>>e:hashmap.entrySet()){
            Collections.sort(e.getValue(), (a, b)->{
               return Integer.compare(b.plays,a.plays);
            });
            hashmapList.add(e);
        }
        Collections.sort(hashmapList, (a,b)->{
            int sumA = 0;
            int sumB = 0;
            for(Pair p:a.getValue()){
                sumA += p.plays;
            }
            
            for(Pair p:b.getValue()){
                sumB += p.plays;
            }
            // int sumA = a.getValue().stream().sum(i.plays->i.plays);
            // int sumB = b.getValue().stream();
            
           return Integer.compare(sumB,sumA); 
        });
        
        List<Integer> ans = new ArrayList<>();
        for(Map.Entry<String, List<Pair>> m:hashmapList){
            ans.add(m.getValue().get(0).play_no);
            if(m.getValue().size()>=2) ans.add(m.getValue().get(1).play_no);
        }
        
        int[] answer = new int[ans.size()];
        int idx=0;
        for(int i:ans) answer[idx++] = i;

        
        
        return answer;
    }
}

class Pair{
    int plays;
    int play_no;
    public Pair(int plays, int play_no){
        this.plays = plays;
        this.play_no = play_no;
    }
}