import java.io.*;
import java.util.*;

class Solution {
    int travelCityCount; List<String> ansList = new ArrayList<>();
    Map<String, List<Pair<String,Boolean>>> hash;
    public void dfs(String cityName, int curCount, List<String> curList){
        curList.add(cityName);

        // curList.forEach(a->System.out.println(a));
        if(curList.size() == travelCityCount) { 
            if(ansList.size() == 0 || String.join(",", curList).compareTo(String.join(",", ansList)) < 0) {
                ansList = new ArrayList<>(curList); 
            }
        }

        if(hash.get(cityName) == null){
            curList.remove(curList.size() - 1); // Backtrack
            return; // 여기서 null 체크 추가
            // 
        }

        for(int i=0;i<hash.get(cityName).size();i++){
            // System.out.println(hash.get(cityName).get(i).right);
            if(hash.get(cityName).get(i).right == false){
                String destCity = hash.get(cityName).get(i).left;
                hash.get(cityName).get(i).right = true;
                dfs(destCity, curCount+1, curList);
                hash.get(cityName).get(i).right = false;
            }
        }
        curList.remove(curList.size() - 1); // 백트래킹 로직 추가
    }

    public String[] solution(String[][] tickets) {
        travelCityCount = tickets.length+1;
        hash= new HashMap<>(); // hash객체 자체는 null이 아니지만, key-value쌍도 모두 초기화된것은 아니다.
        for(String[] ticket:tickets){
            Pair<String,Boolean> pair = new Pair<>(ticket[1],false);
            if(hash.get(ticket[0]) == null){
                List<Pair<String,Boolean>> tmp_pair = new ArrayList<>();
                tmp_pair.add(pair);
                hash.put(ticket[0],tmp_pair);
            }
            else{
                hash.get(ticket[0]).add(pair);
                Collections.sort(hash.get(ticket[0]),(a,b)->a.left.compareTo(b.left));
            }
        }
        dfs("ICN", 0, new ArrayList<>());

        String[] answer = new String[ansList.size()];
        for(int i=0;i<ansList.size();i++){
            answer[i] = ansList.get(i);
        }
        return answer;
    }
}

class Pair<T,K>{
    T left;
    K right;
    public Pair(T x, K y){
        this.left = x;
        this.right = y;
    }
}