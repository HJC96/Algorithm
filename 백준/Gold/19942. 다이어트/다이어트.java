import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    private static int answer = Integer.MAX_VALUE;
    private static int[][] numbers;
    private static int[][] target;
    private static List<Integer> tmpList = new ArrayList<>();
    private static List<Integer> ansList = new ArrayList<>();
    private static int N;
    public static void main(String[] args) throws IOException
    {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String[] line = br.readLine().split(" ");
            N = Integer.parseInt(line[0]);

            String[] input = br.readLine().split(" ");
            target = new int[1][4];
            target[0][0] = Integer.parseInt(input[0]);
            target[0][1] = Integer.parseInt(input[1]);
            target[0][2] = Integer.parseInt(input[2]);
            target[0][3] = Integer.parseInt(input[3]);

            numbers = new int[N][5];
            for(int i=0;i<N;i++){
                input = br.readLine().split(" ");
                numbers[i][0] = Integer.parseInt(input[0]);
                numbers[i][1] = Integer.parseInt(input[1]);
                numbers[i][2] = Integer.parseInt(input[2]);
                numbers[i][3] = Integer.parseInt(input[3]);
                numbers[i][4] = Integer.parseInt(input[4]);
            }
            curr(0, 0, 0, 0, 0,0);

            if(ansList.size()==0){
                System.out.println("-1");
                return;
            }
            System.out.println(answer);
            for(int i:ansList){
                System.out.print(i + " ");
            }
        }

        private static void curr(int p, int f, int s, int v, int pr, int level){
            if(p>=target[0][0] && f>=target[0][1] && s >=target[0][2] && v>=target[0][3]){
                if(answer > Math.min(answer, pr)){
                    answer = Math.min(answer, pr);
                    ansList = new ArrayList<>(tmpList);
                }
                return;
            }
            if(level==N){
                return;
            }
            tmpList.add(level+1);
            curr(p+numbers[level][0],f+numbers[level][1],s+numbers[level][2],v+numbers[level][3],pr+numbers[level][4],level+1); // 선택 하고 넘김
            tmpList.remove(tmpList.size()-1);
            curr(p,f,s,v,pr, level+1); // 선택 안하고 넘김
        }
    }

