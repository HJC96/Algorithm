import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String T_str = br.readLine();
        HashMap<String,Integer> map = new HashMap();
        ArrayList<String> answer = new ArrayList<>();

        int T = Integer.parseInt(T_str);
        for(int i=0;i<T;i++) {
            String num_str = br.readLine();
            int num = Integer.parseInt(num_str);
            ArrayList<String> list = new ArrayList<>();
            for (int j = 0; j < num; j++) {
                String[] txt = br.readLine().split(" ");
                map.put(txt[0], Integer.parseInt(txt[1]));
                list = new ArrayList<>(map.keySet());
                Collections.sort(list, new Comparator<String>() {
                    public int compare(String o1, String o2) {
                        return map.get(o2) - map.get(o1);
                    }
                });
            }
            answer.add(list.get(0));
        }
        for(String key:answer){
            System.out.println(key);
        }

    }
}