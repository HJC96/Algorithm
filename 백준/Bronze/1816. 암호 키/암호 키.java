import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for(int i=0;i<N;i++){
            String flag = "YES";
            long S = Long.parseLong(br.readLine());
            for(int j=2; j<=1000000;j++){
                if(S%j == 0){
                    flag = "NO";
                }
            }
            System.out.println(flag);
        }
    }
}

//2~1000000까지만 체크했을때, 모든 소인수가 체크가 된다?
//전부 체크해야하는거 아니야?
//근데 그러면 뒤에서 이미 했던 계산을 반복하게 될텐데...
//그거의 기준은 제곱이네...
//딱 문제에 제곱 조건이 있네...
