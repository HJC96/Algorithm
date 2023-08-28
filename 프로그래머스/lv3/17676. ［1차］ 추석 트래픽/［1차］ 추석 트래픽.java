import java.io.*;
import java.util.*;

class Solution {
    public int solution(String[] lines) {
        int answer=0;
        List<Integer> startTimes = new ArrayList<>();
        List<Integer> endTimes = new ArrayList<>();
        
        for(String line:lines){
            String[] spaceSplit = line.split(" ");
            String[] colonSplit = spaceSplit[1].split(":");
            String[] dotSplit = colonSplit[2].split("\\.");
            
            int hour = Integer.parseInt(colonSplit[0]);
            int minute = Integer.parseInt(colonSplit[1]);
            int second = Integer.parseInt(dotSplit[0]);
            int millisecond = Integer.parseInt(dotSplit[1]);
            
            int endTime = ((hour * 60 + minute) * 60 + second) * 1000 + millisecond;
            int processDuration = (int) (Float.parseFloat(spaceSplit[2].substring(0, spaceSplit[2].length() - 1)) * 1000);
            int startTime = endTime - processDuration + 1;
            
            startTimes.add(startTime);
            endTimes.add(endTime);
        }
        
        for (int i = 0; i < lines.length; i++) {
            int startRange = endTimes.get(i);
            int endRange = startRange + 1000; // 1000ms

            int count = 0;
            for (int j = 0; j < lines.length; j++) {
                if (startTimes.get(j) < endRange && endTimes.get(j) >= startRange) { // 1001ms 검사하는 것이 아닌, 1000ms 검사이므로 부등호에 유의
                    count++;
                }
            }
            answer = Math.max(answer, count);
        }

        for (int i = 0; i < lines.length; i++) {
            int startRange = startTimes.get(i);
            int endRange = startRange + 1000;

            int count = 0;
            for (int j = 0; j < lines.length; j++) {
                if (startTimes.get(j) < endRange && endTimes.get(j) >= startRange) {
                    count++;
                }
            }
            answer = Math.max(answer, count);
        }

        return answer;
    }
}
