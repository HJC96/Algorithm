import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    static List<List<Integer>> list = new ArrayList<>();
    static int []memory;
    static Boolean [] visited;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        memory = new int[N+1];
        visited = new Boolean[N+1];

        for(int i=0;i<=N;i++){
            list.add(new ArrayList<>());
            memory[i] = 0;
            visited[i] = false;
        }

        for(int i=0;i<N-1;i++){
            String[] l = br.readLine().split(" ");
            list.get(Integer.parseInt(l[0])).add(Integer.parseInt(l[1]));
            list.get(Integer.parseInt(l[1])).add(Integer.parseInt(l[0]));
        }

        dfs(1);

        for(int i=2;i<=N;i++) {
            System.out.println(memory[i]);
        }

    }

    static void dfs(int node){
        visited[node] = true;
        for(int i:list.get(node)) {
            if(visited[i]) continue;
            if(memory[i] == 0) {
                memory[i] = node;
            }
            dfs(i);
        }
    }
}

