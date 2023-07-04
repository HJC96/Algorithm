import java.io.*;
import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> q_bridge = new LinkedList<>();
        Queue<Integer> q_wait = new LinkedList<>();       
        for(int i:truck_weights){
            q_wait.add(i);
        }
        int num; int cur_weight = 0; int cnt =0;
        
        for(int i=0;i<bridge_length;i++){
            q_bridge.add(0);
        }
        
        while(true){
            if(cnt == truck_weights.length){
                break;
            }
            if(q_bridge.peek() != 0){
                cnt++;              
            }
            cur_weight -= q_bridge.poll();
            if(!q_wait.isEmpty()) {
               if(cur_weight + q_wait.peek() <=weight){
                 int wei = q_wait.poll();
                 q_bridge.add(wei);
                 cur_weight+=wei;
                }
                else q_bridge.add(0);
            }else q_bridge.add(0);

            answer++;
        }
        
        return answer;
    }
}