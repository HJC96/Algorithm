import java.io.*;
import java.util.*;

class Solution {
    public int solution(int a, int b, boolean flag) {
        if(flag)
            return a+b;
        else
            return a-b;
    }
}