import java.io.*;
import java.util.*;

class Solution {
    int q1ptr = 0;
    int q2ptr = 0;
    int q1idxptr = 0;
    int q2idxptr = 0;
    
    public int solution(int[] queue1, int[] queue2) {
        long q1Sum = arraySum(queue1);
        long q2Sum = arraySum(queue2);
        long halfValue = (q1Sum + q2Sum)/2;
            
        int []q1 = new int[600001];
        int []q2 = new int[600001];
        
        for(int v:queue1){
            if(v > halfValue){
                return -1;
            }
            q1[q1ptr++] = v;
        }

        for(int v:queue2){
            if(v > halfValue){
                return -1;
            }
            q2[q2ptr++] = v;
        }
        int cnt = 0;

        while(true){
            if(q1Sum > halfValue){
                q2[q2ptr++] = q1[q1idxptr];
                q1Sum -= q1[q1idxptr];
                q2Sum += q1[q1idxptr++];
                // popQ1(q1);
            }else if(q1Sum < halfValue){
                q1[q1ptr++] = q2[q2idxptr];
                q2Sum -= q2[q2idxptr];
                q1Sum += q2[q2idxptr++];
                // popQ2(q2);
            }else{
                break;
            }
            cnt+=1;
            if(cnt > 2*300000) return -1;
        }

        return cnt;
    }

    public long arraySum(int []q){
        long s = 0;
        for(int i=0;i<q.length;i++){
            s += q[i];
        }
        return s;
    }

    public long listSum(List<Integer> q){
        long s = 0;
        for(int i=0;i<q.size();i++){
            s += q.get(i);
        }
        return s;
    }

    public void popQ1(int []q){
        for(int i=0;i<q1ptr;i++){
            q[i] = q[i+1];
        }
        q[--q1ptr] = 0;
    }

    public void popQ2(int []q){
        for(int i=0;i<q2ptr;i++){
            q[i] = q[i+1];
        }
        q[--q2ptr] = 0;
    }
}
/*
import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        long halfValue = (arraySum(queue1) + arraySum(queue2))/2;
        List<Integer> q1 = new ArrayList<>();
        List<Integer> q2 = new ArrayList<>();
        for(int v:queue1){
            if(v > halfValue){
                return -1;
            }
            q1.add(v);
        }

        for(int v:queue2){
            if(v > halfValue){
                return -1;
            }
            q2.add(v);
        }
        int cnt = 0;

        while(true){
            if(listSum(q1) > halfValue){
                q2.add(q1.get(0));
                q1.remove(0);
            }else if(listSum(q1) < halfValue){
                q1.add(q2.get(0));
                q2.remove(0);
            }else{
                break;
            }
            cnt+=1;
        }

        return cnt;
    }

    public long arraySum(int []q){
        long s = 0;
        for(int i=0;i<q.length;i++){
            s += q[i];
        }
        return s;
    }

    public long listSum(List<Integer> q){
        long s = 0;
        for(int i=0;i<q.size();i++){
            s += q.get(i);
        }
        return s;
    }
}
*/