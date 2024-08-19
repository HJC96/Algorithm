import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        int a = Integer.parseInt(arr[0]);
        int b = Integer.parseInt(arr[1]);
        int c = Integer.parseInt(arr[2]);
        int d = Integer.parseInt(arr[3]);
        int e = Integer.parseInt(arr[4]);
        int f = Integer.parseInt(arr[5]);
        for(int i=-999;i<=999;i++){
            for(int j=-999;j<=999;j++){
                if((i*a + j*b == c) && (i*d + j*e == f)){
                    System.out.println(i+" "+j);
                    return ;
                }
            }
        }
    }
}

