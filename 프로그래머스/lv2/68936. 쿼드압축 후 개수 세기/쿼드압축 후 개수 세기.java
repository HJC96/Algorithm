import java.io.*;
import java.util.*;

class Solution {
    int [][] graph;
    Map<Integer, Integer> hashMap = new HashMap<>();
    public void dfs(int y, int x, int lastY, int lastX, int size){
        boolean checkFlag = true;
        int tmpNumber = graph[y][x];
        /* Check Quad (Total) */
        for(int i=y;i<lastY;i++){
            for(int j=x;j<lastX;j++){
                if(tmpNumber != graph[i][j]) {
                    checkFlag = false;
                    break;
                }
            }
            if(!checkFlag) break;
        }
        /* If Quad ? return */
        if(checkFlag) {
            hashMap.put(tmpNumber,hashMap.get(tmpNumber)+1);
            return;
        }
        /* If Atomic ? count */
        if(size==2){
            for(int i=y;i<lastY;i++){
                for(int j=x;j<lastX;j++){
                    hashMap.put(graph[i][j],hashMap.get(graph[i][j])+1);
                }
            }
            return;
        }
        /* Slice */
        /* y, x means offset*/
        dfs(y,x,(y+lastY)/2,(x+lastX)/2, size/2);
        dfs((y+lastY)/2,x,lastY,(lastX+x)/2, size/2);
        dfs(y,(x+lastX)/2,(y+lastY)/2,lastX, size/2);
        dfs((y+lastY)/2,(x+lastX)/2, lastY, lastX, size/2);

    }

    public int[] solution(int[][] arr) {
        int[] answer = new int [2];
        hashMap.put(0,0);
        hashMap.put(1,0);
        graph = arr;
        dfs(0,0,arr[0].length,arr[0].length, arr[0].length);
        answer[0] = hashMap.get(0);
        answer[1] = hashMap.get(1);
        return answer;
    }
}