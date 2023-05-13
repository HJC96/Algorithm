import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] num_list, int n) {
        int answer = 0;
        for(int elem : num_list){
            if(elem == n){
                answer = 1;
                break;
            }               
        }
        return answer;
    }
}