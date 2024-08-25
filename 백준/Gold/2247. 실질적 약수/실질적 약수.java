import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        long ans = 0;
        for(int i=2;i<=(int)(n/2);i++){
            ans += ((long)(n/i)-1)*i;
        }
        System.out.println(ans%1000000);
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



//   1 2 3 4 5 6 7 8 9
//1
//2    O   O   O   O
//3       O    O     O
//4        O       O
//5
//6
//




//f(2) -> 0
//f(3) -> 0
//f(4) -> 2
//f(5) -> 0
//f(6) -> 2 + 3 -> 5
//f(7) -> 0
//f(8) -> 2 + 4 -> 6
//f(9) -> 3
//f(10) -> 2 + 5 -> 7
//f(11) -> 0
//f(12) -> 2 + 3 + 4 + 6 -> 15
//
