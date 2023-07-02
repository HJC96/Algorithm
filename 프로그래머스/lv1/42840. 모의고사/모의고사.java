import java.io.*;
import java.util.*;

class Solution {
    private int find_max(int a, int b, int c){
        int ans=0;
        if(a >=b && a >=c) ans = a;
        else if(b >=a && b>=c) ans = b;
        else ans = c;
        return ans;
    }
    
    public int[] solution(int[] answers) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] arr3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int cnt1=0; int cnt2=0; int cnt3=0;
        for(int i=0;i<answers.length;i++){
            if(answers[i] == arr1[i%5])  cnt1++;
            if(answers[i] == arr2[i%8])  cnt2++;
            if(answers[i] == arr3[i%10]) cnt3++;
        }
        int idx=0;
        List<Integer> map = new ArrayList<>();

        int max = find_max(cnt1,cnt2,cnt3);
        if(max == cnt1) map.add(1);
        if(max == cnt2) map.add(2);
        if(max == cnt3) map.add(3);

        
        int[] answer = new int[map.size()];
        for(int i=0;i<map.size();i++){
            answer[i] = map.get(i);
        }
        return answer;
    }
    
}