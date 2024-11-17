import java.io.*;
import java.util.*;
class Solution {
    public int solution(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) {
            return arr1.length > arr2.length ? 1 : -1;
        }else
        {return Integer.compare(Arrays.stream(arr1).sum(), Arrays.stream(arr2).sum());}
    }
}