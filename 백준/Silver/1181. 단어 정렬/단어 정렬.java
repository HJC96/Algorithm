import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> arr = new ArrayList<>();
        HashSet<String> s = new HashSet<String>();
        int T = Integer.parseInt(br.readLine());
        for(int i=0;i<T;i++){
            String st = br.readLine();
            s.add(st);
        }
        for(String elem:s){
            arr.add(elem);
        }
        Collections.sort(arr, new Comparator<String>(){
           public int compare(String s1, String s2){
               if(s1.length() == s2.length())
                   return s1.compareTo(s2);
               else
                   return s1.length() - s2.length();
           }
        });

        for(String elem:arr){
            System.out.println(elem);
        }
    }
}