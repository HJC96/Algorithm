import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException {
		ArrayList<String> arr = new ArrayList<String>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			String[] st = br.readLine().split(" ");
			double num1 = Double.parseDouble(st[0]);
			double num2 = Double.parseDouble(st[1]);
			if(num1 == 0 && num2 == 0)
				break;
			if(num1%num2 == 0) {
				arr.add("multiple");
			}
			else if(num2%num1 == 0) {
				arr.add("factor");
			}
			else
				arr.add("neither");
		}
		for(int i=0;i<arr.size();i++) {
			System.out.println(arr.get(i));
		}
	}
}