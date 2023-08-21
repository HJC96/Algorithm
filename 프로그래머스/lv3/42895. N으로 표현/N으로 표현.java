import java.io.*;
import java.util.*;

class Solution {
    int []dp = new int[32001];
    public void makeDp(int N, int number){
        Queue<Pair<Integer, Integer>> que = new LinkedList<>();
        que.add(new Pair<>(N,1));
        for(int i=0;i<32001;i++) dp[i] = 99999;
        String tmp = "";
        while(!que.isEmpty()){
            Pair p = que.poll();
            int level = (int)p.right;
            int cur_val = (int)p.left;
            String num = "" +N;
            if(cur_val > 32000 || cur_val < 0) continue;
            if(Math.min(dp[cur_val], level) == level){
                dp[cur_val] = level;
                que.add(new Pair<>(cur_val+N,level+1));
                que.add(new Pair<>(cur_val-N,level+1));
                que.add(new Pair<>(cur_val*N,level+1));
                que.add(new Pair<>(cur_val/N,level+1));
                que.add(new Pair<>(cur_val+num,level+1));
                que.add(new Pair<>(num+cur_val,level+1));
                
                tmp += N;
                que.add(new Pair<>(Integer.parseInt(tmp),level+1));
            }
        }
    }
    
    public int solution(int N, int number) {
        makeDp(N,number);
        int answer = dp[number];
        if(answer > 8) answer = -1;
        
        return answer;
    }
}

class Pair<T,E>{
    T left;
    E right;
    public Pair(T x, E y){
        this.left = x;
        this.right = y;  
    }

}

/*
import java.io.*;
import java.util.*;

class Solution {
    public int solution(int N, int number) {
        int answer = 0;
        int []dp = new int[32001];
        for(int i=0;i<32001;i++) dp[i] = 999999;
        for(int i=N;i<32001;i+=N)
            dp[i] = (i/N);
        
//         dp[1] = 2; // 5/5
//         dp[2] = 3; //10/5
//         dp[3] = 4; //15/5
//         dp[4] = 3; // 5-5/5
//         dp[5] = 1;
        
//         dp[11] = 3;
//         dp[111] = 4;
//         dp[1111] = 5;
//         dp[11111] = 6;
        // 1. 초기 세팅
        for(int i=6;i<32001;i++){
            for(int j=1;j<i;j++){   
                int tmp = (dp[j] + dp[i-j]);
                dp[i] =Math.min(dp[i],tmp);
            }
        }
        for(int i=0;i<101;i++)
            System.out.println(dp[i]);
     return dp[number];

    }
}
        
        


*/