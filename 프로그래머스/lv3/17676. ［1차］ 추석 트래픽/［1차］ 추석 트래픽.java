import java.io.*;
import java.util.*;

class Solution {
    public int solution(String[] lines) {
        int answer = 0;
        int []time = new int[240000000];
        int tmp_max = 0;
        for(String line:lines){
            String tmp_1[] = line.split(" ");
            String tmp_2[] = tmp_1[1].split(":");
            String tmp_3[] = tmp_2[2].split("\\.");
            String dateTime = tmp_2[0]+tmp_2[1]+tmp_3[0]+tmp_3[1];
            int interval = (int)(Float.parseFloat(tmp_1[2].substring(0,tmp_1[2].length()-1))*1000);
            int dateTimeInt = Integer.parseInt(dateTime);
            int start = dateTimeInt - interval;
            if(start>=240000000) continue;
            if(start < 0) {start = 0; }
            for(int i=start;i<=dateTimeInt;i++)
                tmp_max = ++time[i];
            answer = Math.max(tmp_max,answer);
            System.out.println(dateTimeInt);
        }
//        for(int i=0;i<240000000;i+=1000) answer = Math.max(time[i],answer);

        return answer;
    }
}

/*
좌표로 그린다.
좌표로 그려서 겹치는 부분을 카운트하면 될것 같은데...

Max T가 3...

*/