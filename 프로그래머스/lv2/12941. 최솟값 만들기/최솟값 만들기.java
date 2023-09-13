import java.io.*;
import java.util.*;


class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        int len = B.length;
        
        for(int i=0;i<len/2;i++){
            int tmp = B[i];
            B[i] = B[len-i-1];
            B[len-i-1] = tmp;
        }
        for(int i=0;i<A.length;i++)
            answer += A[i]*B[i];

        return answer;
    }
}