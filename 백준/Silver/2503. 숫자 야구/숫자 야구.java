import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        String [][] arr = new String[N][];
        for(int i=0;i<N;i++){
            arr[i] = br.readLine().split(" ");
        }
        for(int i=1;i<=9;i++){
            for(int j=1;j<=9;j++){
                for(int k=1;k<=9;k++){
                    if((i==j) || (j==k) || (k==i)){
                        continue;
                    }
                    String number1 = ""+i+j+k;


                    for(int m=0;m<N;m++) {
                        int strike = 0;
                        int ball = 0;
                        String number2 = arr[m][0];
                        Set<Integer> dup = new HashSet<>();
                        // strike 개수 세기
                        for (int l = 0; l < 3; l++) {
                            int target1 = number1.charAt(l) - '0';
                            int target2 = number2.charAt(l) - '0';
                            if(target1 == target2) strike++;

                            dup.add(target1);
                            dup.add(target2);
                        }
                        // ball 개수 세기
                        ball = 6 - dup.size() - strike;
                        if(strike != Integer.parseInt(arr[m][1]) || ball != Integer.parseInt(arr[m][2])){
                            break;
                        }
                        if(m==N-1) answer++;
                    }
                }
            }
        }
        System.out.println(answer);
    }
}

