import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    static List<List<Integer>> list = new ArrayList<>();
    static Boolean visited[] ;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        visited = new Boolean[27];

        for(int i=0;i<=26;i++){
            list.add(new ArrayList<>());
            visited[i] = false;
        }
        for(int i=0;i<N;i++){
            String[] l = br.readLine().split(" ");
            int a = l[0].charAt(0) - '.' == 0? 0: l[0].charAt(0) - 'A';
            int b = l[1].charAt(0) - '.' == 0? 0: l[1].charAt(0) - 'A';
            int c = l[2].charAt(0) - '.' == 0? 0: l[2].charAt(0) - 'A';

            list.get(a).add(b);
            list.get(a).add(c);
        }

        preOrder(0);
        for(int i=0;i<=26;i++){
            visited[i] = false;
        }
        System.out.println();
        inOrder(0);
        for(int i=0;i<=26;i++){
            visited[i] = false;
        }
        System.out.println();
        postOrder(0);


    }

    public static void preOrder(int node){
        if(!visited[node]) {
            visited[node] = true;
            System.out.print((char)('A' + node));
            preOrder(list.get(node).get(0));
            preOrder(list.get(node).get(1));
        }
    }
    public static void inOrder(int node){
        if(!visited[node]) {
            visited[node] = true;
            inOrder(list.get(node).get(0));
            System.out.print((char)('A' + node));
            inOrder(list.get(node).get(1));
        }
    }
    public static void postOrder(int node){
        if(!visited[node]) {
            visited[node] = true;
            postOrder(list.get(node).get(0));
            postOrder(list.get(node).get(1));
            System.out.print((char)('A' + node));
        }
    }
}

