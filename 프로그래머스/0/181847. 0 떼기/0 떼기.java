import java.io.*;
import java.util.*;

class Solution {
    public String solution(String n_str) {
                return Optional.of(n_str)
                .map(s -> s.replaceFirst("^0+", ""))
                .get();
    }
}
