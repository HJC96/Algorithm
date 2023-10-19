import java.io.*;
import java.util.*;


class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for(int i:scoville) pq.add(i);
        while(pq.peek() < K){
            int num1 = pq.poll();
            int num2 = pq.poll();
            int num = num1 + num2*2;
            answer++;
            if(pq.isEmpty()) { if(num<K) answer=-1;break;}
            pq.add(num);
        }
        return answer;
    }
}