import java.io.*;
import java.util.*;

class Solution {
    public int solution(String[] lines) {
        int []time = new int[236000000];
        int answer=0;
        int tmp_answer = 0;
        List<Integer> start = new ArrayList<>();
        List<Integer> end = new ArrayList<>();
        for(String line:lines){
            String tmp_1[] = line.split(" ");
            String tmp_2[] = tmp_1[1].split(":");
            String tmp_3[] = tmp_2[2].split("\\.");
            
            int hour = Integer.parseInt(tmp_2[0]);
            int minute = Integer.parseInt(tmp_2[1]);
            int second = Integer.parseInt(tmp_3[0]);
            int millisecond = Integer.parseInt(tmp_3[1]);
            
            int endTime = ((hour * 60 + minute) * 60 + second) * 1000 + millisecond;
            
            int processTime = (int)(Float.parseFloat(tmp_1[2].substring(0,tmp_1[2].length()-1))*1000) ;
            int startTime = endTime - processTime + 1;
            
            start.add(startTime);
            end.add(endTime);
        }
        
        for(int i=0;i<lines.length;i++){
            int startRange = end.get(i);
            int endRange = startRange + 1000;

            int count = 0;
            for(int j=0;j<lines.length;j++){
                if(start.get(j) < endRange && end.get(j) >= startRange)
                {
                    count++;
                }
            }
            answer = Math.max(answer, count); 

        }
        
        for(int i=0;i<lines.length;i++){
            int startRange = start.get(i);
            int endRange = startRange + 1000;
            int count = 0;
            for(int j=0;j<lines.length;j++){
                if(start.get(j) < endRange && end.get(j) >= startRange)
                {
                    count++;
                }
            }
            answer = Math.max(answer, count); 
        }
        

        return answer;
    }
}

/*
좌표로 그린다.
좌표로 그려서 겹치는 부분을 카운트하면 될것 같은데...

Max T가 3...

*/