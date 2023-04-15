import java.io.*;
import java.util.*;


public class Main{
	public static void main(String[] args) throws IOException{
		Queue<Integer> q = new LinkedList<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int i=0;i<T;i++) {
			String[] command = br.readLine().split(" ");
			if(command[0].compareTo("push") == 0) {
				q.add(Integer.parseInt(command[1]));
			}
			else if(command[0].compareTo("front") == 0) {
				if(q.isEmpty()) {
					sb.append("-1\n");
					continue;
				}
				sb.append(String.valueOf(q.peek())+'\n');
			}
			else if(command[0].compareTo("back") == 0) {
				if(q.isEmpty()) {
					sb.append("-1\n");
					continue;
				}
				int back =((LinkedList<Integer>)q).getLast();
				sb.append((String.valueOf(back)+'\n'));
			}
			else if(command[0].compareTo("size") == 0) {
				sb.append(String.valueOf(q.size())+'\n');
			}
			else if(command[0].compareTo("pop") == 0) {
				if(q.isEmpty()) {
					sb.append("-1\n");
					continue;
				}
				sb.append(String.valueOf(q.poll())+'\n');
			}
			else if(command[0].compareTo("empty") == 0) {
				if(q.isEmpty())
					sb.append((String.valueOf(1)+'\n'));
				else
					sb.append((String.valueOf(0)+'\n'));
			}		
		}
		System.out.print(sb);

	}
}