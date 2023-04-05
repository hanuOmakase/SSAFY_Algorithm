import java.io.*;
import java.util.*;

public class BOJ16563 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int[] prime = new int[5000001];
		for(int i = 0; i < 5000001; i++)
			prime[i] = i;
		for(int i = 2; i < 5000001; i++) {
			if(prime[i] != i) continue;
			for(int j = 2 * i; j < 5000001; j += i)
				prime[j] = i;
		}
		
		int size = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		ArrayList<Integer>[] answers = new ArrayList [size];
		for(int i = 0; i < size; i++) {
			int number = Integer.parseInt(st.nextToken());
			answers[i] = new ArrayList<Integer>();
			int leftover = number;
			
			while(leftover != 1) {
				answers[i].add(prime[leftover]);
				leftover /= prime[leftover];
			}
			Collections.sort(answers[i]);
			for(int num : answers[i])
				sb.append(num).append(" ");
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
