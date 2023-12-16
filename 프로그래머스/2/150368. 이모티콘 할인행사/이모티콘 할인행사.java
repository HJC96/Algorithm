import java.io.*;
import java.util.*;

class Solution {
    public int n;
    public int[] emoticonPtr;
    public int[][] usersPtr;
    int serviceUser = 0;
    int revenue = 0;

    public List<Integer> combiList = new ArrayList<>();

    public void combi(int curValue, int level){
        if(curValue <= 4) {
            if (combiList.size() == n) {
                if (curValue <= 4) {
                    if (combiList.size() == n) {
                        int tmpServiceUser = 0;
                        int tmpRevenue = 0;
                        for(int i=0;i<usersPtr.length;i++){
                            int totMoney = 0;   int idx=0;
                            for (int j : combiList) {
                                if(j*10 >= usersPtr[i][0]){
                                    totMoney += (10-combiList.get(idx))*0.1*emoticonPtr[idx];
                                }
                                idx++;
                            }
                            if(totMoney >= usersPtr[i][1]){
                                tmpServiceUser++;
                            }else{
                                tmpRevenue += totMoney;
                            }
                        }
                        if(serviceUser == tmpServiceUser) {
                            revenue = Math.max(tmpRevenue,revenue);
                        }else if(serviceUser < tmpServiceUser){
                            serviceUser = Math.max(serviceUser, tmpServiceUser);
                            revenue = tmpRevenue;
                        }
//                        System.out.println();
                    }
                }
                return;
            }
        }else{
            return;
        }
        for(int i = 1; i <= 4; i++) {
            combiList.add(i);
            combi(i, level+1); // 다음 레벨로 넘어갈 때 현재 값을 전달
            combiList.remove(combiList.size()-1);
        }
    }

    public int[] solution(int[][] users, int[] emoticons) {
        emoticonPtr = emoticons;
        usersPtr = users;


        // 1. 총 몇개의 조합을 만들어야 하는지 계산한다
        n = emoticons.length;
        // 2. 조합을 계산한다.
        combi(1, 1);
        // 3. 값을 만든다.

        // 4. 그 값을 일일이 users에 비교한다.
        int[] answer = {serviceUser, revenue};
        for(int i:answer)
            System.out.println(i);
        return answer;
    }
}