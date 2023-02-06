import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P1158 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		String answer = "<";
		Queue<Integer> q = new LinkedList<>();
		for(int i = 1; i <= N; i++) q.add(i);
		int cnt = 1;
		while(!q.isEmpty()) {
			if(cnt == K) {
				answer += q.peek();
				q.remove();
				if(!q.isEmpty()) answer += ", ";
				cnt = 1;
			}
			else {
				q.add(q.peek());
				q.remove();
				cnt++;
			}
		}
		answer += ">";
		System.out.println(answer);
		sc.close();
	}
}
