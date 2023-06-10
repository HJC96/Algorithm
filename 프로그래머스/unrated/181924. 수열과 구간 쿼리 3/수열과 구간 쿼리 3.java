import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        for(int[] q:queries){
            int SWAP = arr[q[0]];
            arr[q[0]] = arr[q[1]];
            arr[q[1]] = SWAP;
        }
        return arr;
    }
}