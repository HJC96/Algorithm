

import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        Map<String,String> hashMapping = new HashMap<>();
        Map<String,Integer> hashData = new HashMap<>();
        int length = enroll.length;
        /*Make Hash*/
        for(int i=0;i<length;i++){
            if(hashMapping.get(enroll[i]) == null){
                hashMapping.put(enroll[i],referral[i]);
                hashData.put(enroll[i],0);
            }
        }
        /*Input Test*/
        // for(Map.Entry<String,String> l :hashMapping.entrySet()) {
        //     System.out.print(l.getKey() +" "+l.getValue());
        //     System.out.println();
        // }

        /*Logic*/
        int len = seller.length;
        for(int i=0;i<len;i++){
            String person = seller[i];
            int money = amount[i]*100;
            int commission = money / 10;
            int earning = money - commission;    
            if(hashMapping.containsKey(person)){
                hashData.put(person, hashData.get(person) + earning);
                while(!hashMapping.get(person).equals("-")) {
                    person = hashMapping.get(person);
                    money /= 10;
                    if(money == 0 ) break;
                    commission = money / 10;
                    earning = money - commission;            
                    hashData.put(person, hashData.get(person) + earning);
                }
            }
        }

        int[] answer = new int[enroll.length];
        int index=0;
        for(String en:enroll){
            answer[index++] = hashData.get(en);
        }

        return answer;
    }
}

