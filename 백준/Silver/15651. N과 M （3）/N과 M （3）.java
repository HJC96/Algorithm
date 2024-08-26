import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static int N;
    private static int M;
    private static List<Integer> result = new ArrayList<>();
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);
        
        backtrack(0);
        System.out.print(sb);
    }

    private static void backtrack(int depth) {
        if (depth == M) {
            for (int num : result) {
                sb.append(num).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = 1; i <= N; i++) {
            result.add(i);
            backtrack(depth + 1);
            result.remove(result.size() - 1);
        }
    }
}