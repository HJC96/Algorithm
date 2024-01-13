import java.util.Scanner;
import java.io.FileInputStream;
class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
int answer = 999999999;
            int[] price = new int[5];
            for(int i=1;i<=4;i++){
                price[i]=sc.nextInt();
            }
            int[] days = new int[13];
            for(int i=1;i<=12;i++){
                days[i]=sc.nextInt();
            }

            int[] dp = new int[13];
            dp[1] = Math.min(days[1]*price[1], Math.min(price[2], price[3]));
            dp[2] = Math.min(dp[1]+days[2]*price[1], Math.min(price[2]+dp[1], price[3]));
            dp[3] = Math.min(dp[2]+days[3]*price[1], Math.min(price[2]+dp[2], price[3]));
            for(int i=4;i<=12;i++){
                dp[i] = Math.min(dp[i-1]+days[i]*price[1], Math.min(dp[i-1]+price[2], dp[i-3]+price[3]));
            }


            answer = Math.min(dp[12], price[4]);
			System.out.print("#");
			System.out.print(test_case);
			System.out.print(" ");
			System.out.println(answer);
        }

    }
}