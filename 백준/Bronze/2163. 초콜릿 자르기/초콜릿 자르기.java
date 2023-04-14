import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] st1 = br.readLine().split(" ");
		
		int num1 = Integer.parseInt(st1[0]);
		int num2 = Integer.parseInt(st1[1]);
		
		System.out.println((num1-1)+(num2-1)*(num1));	
	}
}
