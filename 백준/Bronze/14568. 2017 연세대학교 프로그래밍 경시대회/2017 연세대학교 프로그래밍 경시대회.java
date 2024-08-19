import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int cnt = 0;
        for(int i=1;i<=N;i++){
            for(int j=1;j<=N;j++){
                for(int k=1;k<=N;k++){
                    if((i+j+k == N) && (i >= j + 2) && (k % 2 == 0)){
                        cnt++;
                    }
                }
            }
        }
        System.out.print(cnt);
    }
}

