import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static ArrayList<Integer>[] graph;
    private static boolean[] visited;
    private static int ans = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        graph = new ArrayList[n+1];
        visited = new boolean[n+1];

        for(int i=1;i<=n;i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0;i<m;i++){
            String[] line = br.readLine().split(" ");
            int a = Integer.parseInt(line[0]);
            int b =Integer.parseInt(line[1]);
            graph[a].add(b);
            graph[b].add(a);
        }

        recur(1);
        System.out.println(ans-1);
    }

    static void recur(int node){
        visited[node] = true;
        ans++;
        for(int nxt:graph[node]){
            if(visited[nxt] == true){
                continue;
            }
            recur(nxt);
        }
    }
}