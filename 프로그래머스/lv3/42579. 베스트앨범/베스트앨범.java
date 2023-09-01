import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, List<Pair>> hashmap = new HashMap<>();
        for(int i=0;i<genres.length;i++){
            if(hashmap.get(genres[i]) == null){
                List<Pair> list = new ArrayList<>();
                Pair pair = new Pair(plays[i], i);
                list.add(pair);
                hashmap.put(genres[i], list);
            }
            else{
                Pair pair = new Pair(plays[i], i);
                hashmap.get(genres[i]).add(pair);
            }
        }
        List<Map.Entry<String, List<Pair>>> entryList = new ArrayList<>(hashmap.entrySet());

        for(List<Pair> list : hashmap.values()){
            Collections.sort(list, (a, b) -> Integer.compare(b.plays, a.plays));
        }

        Collections.sort(entryList, (a, b) -> {
            int sumA = a.getValue().stream().mapToInt(pair->pair.plays).sum();
            int sumB = b.getValue().stream().mapToInt(pair->pair.plays).sum();
            return Integer.compare(sumB, sumA); 
        });
        
        // hashmap이라는 hashmap 하나에 sort를 쓸 수 있는지.
        // 쓸 수 있다면, 
        List<Integer> ans = new ArrayList<>();
        for(Map.Entry<String, List<Pair>> e:entryList){
            List<Pair> pairs = e.getValue();
            int size = Math.min(pairs.size(), 2); // 리스트 크기가 2 미만인 경우를 대비
            for(int i = 0; i < size; i++) {
                ans.add(pairs.get(i).number);  // number 필드를 ans에 추가
    }
        }
        
        return ans.stream().mapToInt(i -> i).toArray();
    }
}

class Pair{
    int plays;
    int number;
    public Pair(int plays, int number){
        this.plays = plays;
        this.number = number;
    }
}
