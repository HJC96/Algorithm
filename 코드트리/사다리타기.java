import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static String[] line;
    static List<Ladder> ladders = new ArrayList<>();
    static List<Ladder> tmpladders = new ArrayList<>();
    static int[] numbers;
    static int[] targetNumbers;
    static int answer;


    static List<Ladder> tmpLadder = new ArrayList<>();

    static int[] findResult(int[] tmpNumbers, List<Ladder> ladders){
        for(Ladder tmpLadder:ladders){
            int tmp = tmpNumbers[tmpLadder.a-1];
            tmpNumbers[tmpLadder.a-1] = tmpNumbers[tmpLadder.a];
            tmpNumbers[tmpLadder.a] = tmp;
        }

        return tmpNumbers;
    }
    
    static void choose(int cnt){
        
        if(cnt == m){
            for(Ladder l:tmpladders){
                System.out.print(l.a);
                System.out.print(l.b);
                System.out.println();
            }
            int [] tmpNumbers = new int[n];
            for(int k=0;k<n;k++){
                tmpNumbers[k] = numbers[k];
            }
            if(check(findResult(tmpNumbers,tmpladders)))
                answer = Math.min(answer, tmpladders.size());
            return;
        }
        

        tmpladders.add(ladders.get(cnt));
        choose(cnt+1);
        tmpladders.remove(tmpladders.size()-1);        

        choose(cnt+1);
        /*
        0
        1 0
        2 1 1 0
        3 2 
        ...
        5 4 3 2 1
        */
    }

    static boolean check(int []tmpNumbers){
        for(int i=0;i<n;i++)
            if(tmpNumbers[i] != targetNumbers[i]) return false;
        return true;
    }

    public static void main(String[] args) throws IOException{
        /* input*/
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        line = br.readLine().split(" ");
        n = Integer.parseInt(line[0]);
        m = Integer.parseInt(line[1]);
        answer = m;
        for(int i=0;i<m;i++){
            line = br.readLine().split(" ");
            Ladder ld = new Ladder(Integer.parseInt(line[0]), Integer.parseInt(line[1]));
            ladders.add(ld);
        }

        /* sort */
        Collections.sort(ladders, (x,y)->{
            return Integer.compare(x.b, y.b);
        });
        
        targetNumbers = new int[n];
        numbers = new int[n];
        /* Init result */
        for(int i=0;i<n;i++){
            targetNumbers[i] = i+1;
            numbers[i] = i+1;
        }
        findResult(targetNumbers,ladders);
        if(check(numbers) == true) {System.out.print(0); return;}

        /* BackTraking */        
        choose(0);
        
        System.out.print(answer);
    }
}

class Ladder{
    int a;
    int b;
    public Ladder(int a, int b){
        this.a = a;
        this.b = b;
    }
}

/*

4 6
1 1
1 3
2 2
2 4
3 3
3 5

생각해보자 어떻게 접근하지.
사다리 타기...
사다리.....
줄 연결...
최소로...
같은 결과...

1. 어떤 값이 나오는지 알아야겠지
-> 이것 또한 구현하는데 오랙럴리것 같음...
2. 그 값이 나오도록 최소한으로 사다리를 조절해라...
-> 일단 1을 구했다, 그리고 어떻게?
-> 모든 케이스를 탐색?
어떻게 탐색할건데?
모든 케이스를 넣되, 현재 값인 6과 같거나 커지면 그만 만드는 방식의 백트래킹...

1 1

1 1
1 2

1 1
1 2
1 3

...

2 1
2 2
2 3

2 1
2 3

...


1 1
1 2
1 3
1 4
1 5

1 1
1 2
1 3
1 5



1. checkResult 함수를 구현한다. -> 현재 사다리 상태에서 어떤 결과가 나타나는지 확인하는 기능.
-> 이게 어려운데??? 이걸 어떻게 구현하지??
2. 위의 조합을 구현한다.
3. 해당 조합일떼 checkResult를 활용하여, 최소값을 구한다.



--> 하나 캐치했음.

1 2 3 4 - 0
2 1 3 4 - 1  
2 3 1 4 - 2
3 2 4 1 - 3
3 4 2 1 - 4
3 4 1 2 - 5

1. 배열에 뒷자리가 숫자이니 해당 순서대로 변경하면 된다.
-> 정렬 필요한가?


*/

