import java.io.*;
import java.util.*;

class Solution {
        public int solution(int sticker[]) {
        int answer = 0; 
        int length = sticker.length;
        if(length == 1) return sticker[0];
        if(length == 2) return Math.max(sticker[0],sticker[1]) ;
        int []tmp_sticker  = new int[length];
        int []tmp_sticker2  = new int[length];
        for(int i=0;i<length;i++ ) tmp_sticker[i] = sticker[i];
        tmp_sticker[length-1] = 0;

        for(int i=0;i<length-1;i++) tmp_sticker2[i] = sticker[i+1];
        tmp_sticker2[length-1] = 0;


        // fix circle -> 1 dimension
        // start 1st elem
        int[] dp = new int[length];
        int[] dp2 = new int[length];


        //init
        dp[0] = tmp_sticker[0];
        dp[1] = Math.max(dp[0], tmp_sticker[1]);


        for(int i=0;i<length-2;i++){
            dp[i+2] = Math.max(dp[i] + tmp_sticker[i+2], dp[i+1]);   
        }

        // for(int i:dp) System.out.println(i);

        dp2[0] = tmp_sticker2[0];
        dp2[1] = Math.max(dp2[0], tmp_sticker2[1]);

        for(int i=0;i<length-2;i++){
            dp2[i+2] = Math.max(dp2[i] + tmp_sticker2[i+2], dp2[i+1]);
        }


        // for(int i:dp2) System.out.println(i);


        return Math.max(dp[length-1], dp2[length-1]);
    }
}
