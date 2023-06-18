import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int l, int r) {
        ArrayList<Integer> arr = new ArrayList<>();
        while(l<=r){
            String str = Integer.toString(l);
            for(int i=0;i<str.length();i++){
                if(str.charAt(i) != '5' && str.charAt(i) != '0' )   break; 
                if(i == str.length()-1) arr.add(Integer.parseInt(str));
            }
            l++;  
        }
        int[] array = new int[arr.size()];
        if(array.length == 0) return new int[]{-1};
        else{
            for (int i = 0; i < arr.size(); i++) {
                array[i] = arr.get(i);
            }
            return array;
        }
    }
}