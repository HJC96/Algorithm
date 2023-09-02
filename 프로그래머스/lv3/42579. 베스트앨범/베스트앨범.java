import java.io.*;
import java.util.*;


class Solution {
    public int[] solution(String[] genres, int[] plays) {
        
        List<Integer> ans = new ArrayList<>();
        Map<String, List<Pair>> hashmap = new HashMap<>();
        /*1. Set HashMap*/
        int length = genres.length;
        for(int i=0;i<length;i++){
            if(hashmap.get(genres[i]) == null){
                List<Pair> list = new ArrayList<>();
                Pair pair = new Pair(plays[i], i);
                list.add(pair);
                hashmap.put(genres[i],list);
            }else{
                hashmap.get(genres[i]).add(new Pair(plays[i],i));
            }
        }
        /*2. Sort HashMap*/
        // List<Pair>
        List<Map.Entry<String, List<Pair>>> list = new ArrayList<>(hashmap.entrySet()); 
        for(int i=0;i<list.size();i++){
            Collections.sort(list.get(i).getValue(), (a,b)->
                             {
                                 return Integer.compare(b.plays,a.plays);
                             });
        }
        Collections.sort(list, (a,b)->{
            int sumA = a.getValue().stream().mapToInt(i->i.plays).sum();
            int sumB = b.getValue().stream().mapToInt(i->i.plays).sum();
            return Integer.compare(sumB, sumA);
        });
            
        /*3. Get Answer*/
        for(Map.Entry<String,List<Pair>> h:list){
            ans.add(h.getValue().get(0).playNumber);
            if(h.getValue().size() >= 2)
                ans.add(h.getValue().get(1).playNumber);
        }
        int idx=0;
        int [] answer = new int[ans.size()];
        for(int i=0;i<ans.size();i++){
            answer[i] = ans.get(i);
        }
        
        return answer;
    }
}

class Pair{
    int plays;
    int playNumber;
    public Pair(int plays, int playNumber){
        this.plays = plays;
        this.playNumber = playNumber;
    }
}