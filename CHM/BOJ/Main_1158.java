import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 1 2 3 4 5 6 7 -> 3
// 4 5 6 7 1 2 -> 6
// 7 1 2 4 5 -> 2
// 4 5 7 1 -> 7
// 1 4 5 -> 5
// 1 4 -> 1
// 4
public class Main_1158 { // 1158. 요세푸스 문제
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder("<");
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken()) - 1;
		
		List<Integer> circle = new ArrayList<Integer>();
		int start = 0;
		int end = N - 1;
		for (int i = 1; i <= N; i++) {
			circle.add(i);
		}
		
		while (circle.size() > 1) {
			int dead = (start + K) % circle.size();
			sb.append(circle.get(dead)).append(", ");
			circle.remove(dead);
			start = dead;
		}
		sb.append(circle.get(0)).append(">");
		
		System.out.println(sb);
	}
}
