import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    private static int answer = 0;
    private static int[][] numbers;
    private static int N;
    public static void main(String[] args) throws IOException
    {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            N = Integer.parseInt(br.readLine());
            numbers = new int[N][2];
            for(int i=0;i<N;i++){
                String[] input = br.readLine().split(" ");
                numbers[i][0] = Integer.parseInt(input[0]);
                numbers[i][1] = Integer.parseInt(input[1]);
            }
            curr(0, 0);

            System.out.println(answer);
        }

        private static void curr(int day, int money){
            if(day >= N){
                answer = Math.max(answer, money);
                return;
            }
            if(day+numbers[day][0] <= N) {
                curr(day + numbers[day][0], money + numbers[day][1]); // 해당 날짜 선택시
            }
            curr(day+1, money);
        }
    }

