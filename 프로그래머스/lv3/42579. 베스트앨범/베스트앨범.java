import java.io.*;
import java.util.*;


class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, List<Pair>> hashmap = new HashMap<>();
        int idx=0;
        for(String str:genres){
            if(hashmap.get(str) == null){
                Pair p = new Pair(plays[idx], idx);
                List<Pair> lis = new ArrayList<>();
                lis.add(p);
                hashmap.put(str, lis);
            }else{
                Pair p = new Pair(plays[idx], idx);
                hashmap.get(str).add(p);
            }
            idx++;
        }
        List<Map.Entry<String, List<Pair>>> sortedList = new ArrayList<>();
        for(Map.Entry<String, List<Pair>> m:hashmap.entrySet()){
            Collections.sort(m.getValue(), (a,b)->{
                return Integer.compare(b.plays,a.plays);
            });
            sortedList.add(m);
        };
//         Collections.sort(sortedList, (a,b) ->{
            
//             return Integer.compare(a.getValue());
//         });
        
        Collections.sort(sortedList, (a,b) ->{
            int sumA = a.getValue().stream().mapToInt(i->i.plays).sum();
            int sumB = b.getValue().stream().mapToInt(i->i.plays).sum();
            return Integer.compare(sumB, sumA);
        });
        
        int len = hashmap.size();
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<len;i++){
            ans.add(sortedList.get(i).getValue().get(0).playNumber);
            if(sortedList.get(i).getValue().size()>=2) ans.add(sortedList.get(i).getValue().get(1).playNumber);
        }
        
        int []answer = new int[ans.size()];
        int id=0;
        for(int i:ans) answer[id++] = i;
        
        
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