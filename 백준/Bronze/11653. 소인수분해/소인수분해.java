import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(reader.readLine());

        List<Integer> factors = factorize(number);
        for (int factor : factors) {
            System.out.println(factor);
        }
    }

    private static List<Integer> factorize(int n) {
        List<Integer> factors = new ArrayList<>();

        // 2로 나누어 떨어지는 경우를 먼저 처리
        while (n % 2 == 0) {
            factors.add(2);
            n /= 2;
        }

        // 3 이상의 홀수로 나누기
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            while (n % i == 0) {
                factors.add(i);
                n /= i;
            }
        }

        // n이 2보다 큰 소수인 경우
        if (n > 2) {
            factors.add(n);
        }

        return factors;
    }
}