import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");

        long A = Long.parseLong(line[0]);
        long B = Long.parseLong(line[1]);

        long FA = 0;
        A -= 1;
        FA += A;
        for(int i=1;(Math.pow(2, i))<=A;i++){
            FA += (long)(A/(Math.pow(2, i))) * (long)(Math.pow(2, i)-Math.pow(2, i-1));
        }

        long FB = 0;
        FB += B;
        for(int i=1;(Math.pow(2, i))<=B;i++){
            FB += (long)(B/(Math.pow(2, i))) * (long)(Math.pow(2, i)-Math.pow(2, i-1));
        }

        System.out.println(FB - FA);
    }
}


/*

1 2 3 4 5 6 7 8 9 10
1 2 1 4 1 2 1 8 0 2


  1 2 3 4 5 6 7 8 9 10
1 o o o o o o o o o o
2 x o x o x o x o x o
4 x x x o x x x o x x

1 2 1 8 1

*/
//f(1) f(2) f(3) f(4) f(5) f(6) f(7) f(8) f(9)
//1     2     1   4    1     2    1    8   1