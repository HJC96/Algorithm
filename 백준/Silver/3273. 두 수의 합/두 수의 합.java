import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int ans = 0;

        String[] line = br.readLine().split(" ");
        int T = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();

        for(String l:line){
            list.add(Integer.parseInt(l));
        }

        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });

        int s = 0;
        int e = list.size()-1;
        while(s < e){
            if(list.get(s)+list.get(e) == T){
                ans++;
                s+=1;
                e-=1;
            } else if (list.get(s)+list.get(e) > T) {
                e-=1;
            }else{
                s+=1;
            }
        }
        System.out.println(ans);

    }
}

