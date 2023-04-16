import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int num = Integer.parseInt((br.readLine()));
        String[][] student = new String[num][4];
        for (int i = 0; i < num; i++) {
            String[] read = br.readLine().split(" ");
            student[i][0] = read[0];
            student[i][1] = read[1];
            student[i][2] = read[2];
            student[i][3] = read[3];
        }
        Arrays.sort(student, new Comparator<String[]>(){
            public int compare(String[] o1, String[] o2){
                if(o2[1].equals(o1[1])){
                    if(o1[2].equals(o2[2])){
                        if(o2[3].equals(o1[3])){
                            return o1[0].compareTo(o2[0]);
                        }
                        return Integer.parseInt(o2[3]) - Integer.parseInt(o1[3]);
                    }
                    return Integer.parseInt(o1[2]) - Integer.parseInt(o2[2]);
                }
                return Integer.parseInt(o2[1]) - Integer.parseInt(o1[1]);
            }
        });
        for (int i = 0; i < num; i++) {
            System.out.println(student[i][0]);
        }
    }
}
