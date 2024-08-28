import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    private static int answer = 0;
    private static int[][] numbers;
    private static int N;
    public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            N = Integer.parseInt(br.readLine());
            numbers = new int[N][3];
            for(int i=0;i<N;i++){
                String[] input = br.readLine().split(" ");
                numbers[i][0] = Integer.parseInt(input[0]);
                numbers[i][1] = Integer.parseInt(input[1]);
                numbers[i][2] = Integer.parseInt(input[2]);
            }
            curr(100, 0);

            System.out.println(answer);
        }

        private static void curr(int number, int count){
        
            if(number == 1000){
                return;
            }

            if(count == N){
                answer+=1;
                curr(number+1, 0);
                return;
            }
            int A = number/100;
            int B = (number%100)/10;
            int C = (number%10);

            if(A == B || A == C || B == C){
                curr(number+1, 0);
                return;
            }
            if(A== 0 || B == 0 || C == 0){
                curr(number+1, 0);
                return;
            }
            int hintA = numbers[count][0]/100;
            int hintB = (numbers[count][0]%100)/10;
            int hintC = (numbers[count][0]%10);

            boolean pass = false;
            int strike = 0;
            int ball = 0;
            if(A == hintA){
                strike++;
            }
            if(B == hintB){
                strike++;
            }
            if(C == hintC){
                strike++;
            }
            if(A == hintB || A == hintC){
                ball++;
            }
            if(B == hintA || B == hintC){
                ball++;
            }
            if(C == hintA || C == hintB){
                ball++;
            }
            if(strike == numbers[count][1] && ball == numbers[count][2]){
                pass = true;
            }
            // if 힌트가 맞으면
            if(pass) {
                curr(number, count + 1);
            }// 힌트가 맞지 않으면
            else{
                curr(number+1, 0);
            }
        }
    }

