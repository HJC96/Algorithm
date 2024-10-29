import java.util.stream.Collectors;


class Solution {
    public int solution(String myString, String pat) {
        String swapped = myString.chars()
                .mapToObj(ch -> (char) ch == 'A' ? 'B' : 'A')
                .map(String::valueOf)
                .collect(Collectors.joining());

        return swapped.contains(pat) ? 1 : 0;
    }
}