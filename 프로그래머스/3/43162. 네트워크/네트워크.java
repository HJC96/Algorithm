import java.io.*;
import java.util.*;

class Solution {
    boolean [] visited;
    List<List<Integer>> computer;
    int answer = 1;
    int change = 0;
    public int solution(int n, int[][] computers) {

        visited = new boolean[computers[0].length];

        computer = new ArrayList<>();
        for(int i=0;i<n;i++){
            computer.add(new ArrayList<>());
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(computers[i][j] == 1){
                    computer.get(i).add(j);
                }
            }
        }
        
        for(int i=0;i<n;i++){
            dfs(i);
            for(int j=0;j<n;j++){
                if(visited[j] == false && change == 1) {
                    answer++;
                    break;
                }else{
                    
                }
            }
            change = 0;
        }
        return answer;
    }
    public void dfs(int num){
        if(visited[num]) return;
        visited[num] = true;
        for(int i:computer.get(num)){
            dfs(i);
        }
        change = 1;
    }
}

/*
    개념: 타고타고 들어가서 카운트 하는거
    for 문으로 계속 돌리고, 방문 처리해서 방문 했으면 방문 안하고 방문 안했을면 방문 하면 됨.
    1. 각 노드에서 연결 관계를 표시해야 한다.
    2. 그 연결관계를 이용해서, 방문한다
    3. 방문했다면, 체크하고
        1.
        2.
        3.

*/