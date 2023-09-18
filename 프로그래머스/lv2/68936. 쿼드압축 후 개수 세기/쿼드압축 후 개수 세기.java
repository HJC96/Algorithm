import java.io.*;
import java.util.*;


class Solution {
    Map<Integer, Integer> hashMap = new HashMap<>();
    void dfs(int startY, int startX, int endY, int endX, int[][] arr){
        
        boolean checkQuad = true;
        /* Check Quad */
        for(int i=startY;i<endY;i++){
            for(int j=startX;j<endX;j++){
                if(j+1 < endX){
                    if(arr[i][j] != arr[i][j+1]){
                        checkQuad = false;
                        break;
                    }
                }
                if(i+1 < endY){
                    if(arr[i][j] != arr[i+1][j]){
                        checkQuad = false;
                        break;
                    }
                }
            }
        }
        /*  */
        if(checkQuad){
            hashMap.put(arr[startY][startX], hashMap.get(arr[startY][startX])+1);
            return;
        }
        /* if atomic */
        if(endY - startY <=1){
            for(int i=startY;i<endY;i++){
                for(int j=startX;j<endX;j++){
                    hashMap.put(arr[i][j], hashMap.get(arr[i][j])+1);
                }
            }
            return;
        }
        
        dfs(startY, startX, (startY+endY)/2, (startX+endX)/2, arr);
        dfs((startY+endY)/2, startX, endY, (startX+endX)/2, arr);
        dfs(startY, (startX+endX)/2, (startY+endY)/2, endX, arr);
        dfs((startY+endY)/2, (startX+endX)/2, endY, endX, arr);
        
    }
    
    
    
    public int[] solution(int[][] arr) {

        int len = arr.length;
        hashMap.put(0,0);
        hashMap.put(1,0);
        dfs(0, 0, len, len, arr);
        int[] answer = new int[]{hashMap.get(0),hashMap.get(1)};        
        return answer;
    }
}