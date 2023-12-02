import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {

        List<Integer> ansList = new ArrayList<>();
        /* 오늘 날짜 */
        String[] todayArray = today.split("\\.");
        int todayYear = Integer.parseInt(todayArray[0]);
        int todayMonth = Integer.parseInt(todayArray[1]);
        int todayDay = Integer.parseInt(todayArray[2]);


        /* 1. terms mapping */
        HashMap<Character, Integer> termsMap = new HashMap<>();
        for(String t:terms){
            String[] tmpArray = t.split(" ");
            termsMap.put(tmpArray[0].charAt(0), Integer.parseInt(tmpArray[1]));
        }

        /* 2. Privaces + terms 날짜 */
        int ans = 1;
        for(String privacy:privacies){
            String[] privacyArray = privacy.split(" ");
            String privacyYearMonthDay = privacyArray[0];
            Character privacyPolicy = privacyArray[1].charAt(0);
            String[] privacyDate = privacyYearMonthDay.split("\\.");
            int privacyYear = Integer.parseInt(privacyDate[0]);
            int privacyMonth = Integer.parseInt(privacyDate[1])+ termsMap.get(privacyPolicy);
            int num1 = privacyMonth/12;
            int num2 = privacyMonth%12;
            if(num1>=1 && num2 !=0){
                privacyYear+=num1;
                privacyMonth-=12*num1;
            }
            
            if(num1>=1 && num2 ==0){
                privacyYear+=(num1-1);
                privacyMonth=12;
            }
            
            
            int privacyDay = Integer.parseInt(privacyDate[2]);

            if(todayYear > privacyYear){
                ansList.add(ans);
            }
            else if(todayYear == privacyYear){
                if(todayMonth > privacyMonth){
                    ansList.add(ans);
                }
                else if(todayMonth == privacyMonth){
                    if(todayDay >= privacyDay){
                        ansList.add(ans);
                    }
                    else{
                        ;
                    }
                }
                else{
                    ;
                }
            }
            else{
                ;
            }
            ans++;
        }

        int[] answer = new int[ansList.size()];
        int idx=0;
        for(int i:ansList){
            answer[idx++] = i;
        }

        return answer;
    }
}