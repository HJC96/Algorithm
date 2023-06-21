import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> tmpAns = new ArrayList<>();
        
        boolean [] checkAns = new boolean[plays.length];
        Arrays.fill(checkAns, false);

        HashMap<Integer, Integer> indexTbl = new HashMap<>();
        for(int i=0;i<plays.length;i++){
            indexTbl.put(plays[i],i);
        }
        HashMap<String, List<Integer>> hash = new HashMap<>();
        for(int i=0;i<plays.length;i++){
            if(hash.containsKey(genres[i])){
                 hash.get(genres[i]).add(plays[i]);
            }else{
                 List<Integer> lis = new ArrayList<>();
                 lis.add(plays[i]);
                 hash.put(genres[i],lis);
            }
        }
        HashMap<String, Integer> tbl = new HashMap<>();
        for(Map.Entry<String, List<Integer>> e: hash.entrySet()){
              int tmp = 0;
              for(Integer i: e.getValue())
                  tmp +=i;
              tbl.put(e.getKey(), tmp);
        }
        List<Map.Entry<String, Integer>> sortedEntries = new ArrayList<>(tbl.entrySet());
        Collections.sort(sortedEntries, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> entry1, Map.Entry<String, Integer> entry2) {
                return entry2.getValue().compareTo(entry1.getValue()); // 내림차순 정렬
            }
        });
        for(Map.Entry<String, Integer> e:sortedEntries){
             List<Integer> tmp = hash.get(e.getKey());
             Collections.sort(tmp, new Comparator<Integer>() {
            public int compare(Integer entry1, Integer entry2) {
                return entry2-entry1;}});
             for(int i = 0;i<tmp.size();i++){
                 if(i==2)
                      break;
                 //tmp.get(i) -> 5
                 for(int j=0;j<plays.length;j++){
                     if(checkAns[j] == false){
                        if(plays[j] == tmp.get(i)){
                            checkAns[j] = true;
                            tmpAns.add(j);
                            break;
                        }
                     }
                 }
            }        
        }
        int [] answer=new int[tmpAns.size()];
        for(int i=0;i<tmpAns.size();i++){
             answer[i]=tmpAns.get(i);        
        }
        
        return answer;
    }
}