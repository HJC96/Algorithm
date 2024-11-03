import java.io.*;
import java.util.*;

class Solution {
    public long solution(long n) {
        return Math.sqrt(n) % 1 == 0 ? (long)(Math.sqrt(n) + 1) * (long)(Math.sqrt(n) + 1) : -1;
    }
}