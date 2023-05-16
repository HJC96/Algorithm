import java.io.*;
import java.util.*;

class Solution {
    private int idx = -1;

    public int solution(int[] num_list) {
        for(int i=0;i<num_list.length;i++){
            if(num_list[i] < 0) {idx = i; break;}
        }
        return idx;
    }
}