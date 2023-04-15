import java.util.*;
import java.io.*;

public class Main{
    public static void main(String args[]) throws IOException{
        HashMap<String, Integer> h = new HashMap<String, Integer>();
        h.put("black",0);
        h.put("brown",1);
        h.put("red",2);
        h.put("orange",3);
        h.put("yellow",4);
        h.put("green",5);
        h.put("blue",6);
        h.put("violet",7);
        h.put("grey",8);
        h.put("white",9);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String color1 = br.readLine();
        String color2 = br.readLine();
        String color3 = br.readLine();

        long answer = (h.get(color1)*10 + h.get(color2))*(long)Math.pow(10,h.get(color3));
        System.out.printf("%d", answer);
        }
    }
