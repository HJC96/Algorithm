import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
         
        int max_0 = 0; int max_1 = 0;
        for(int[] arr:sizes){
             if(arr[0] > arr[1]){
                 if(arr[0] >= max_0) max_0 = arr[0] ;
                 if(arr[1] >= max_1) max_1 = arr[1] ;            
             }
             else{
                 if(arr[1] >= max_0) max_0 = arr[1] ;
                 if(arr[0] >= max_1) max_1 = arr[0] ; 
             }
        }
        
        
        
        return max_1 * max_0;
    }
}