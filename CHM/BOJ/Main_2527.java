import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 왼쪽 위 꼭짓점(x, q) 오른쪽 위 꼭짓점(p, q)
// 왼쪽 아래 꼭짓점(x, y) 오른쪽 아래 꼭짓점(p, y)

// 겹치는 부분이 선인 경우 b
// p1 == x2 && 
// p1 == x2 전제 하에서 c, d에서 걸러지고 남은 경우는 모두 선분에서 만나는 경우
// 따라서, d와 c를 먼저 체크하고 b를 체크하면, p1 == x2이면 c라고 판단 가능 

// 겹치는 부분이 점인 경우 c
// p1 == x2 && y1 == q2 || p1 == x2 && q1 == y2 || x1 == p2 && q1 == y2 || x1 == p2 && y1 == q2

// 겹치지 않는 경우 d
// p1 < x2 || x1 > p2 || q1 < y2 || y1 > q2

// 나머지 (직사각형) a
public class Main_2527 { // 2527. 직사각형
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int p1 = Integer.parseInt(st.nextToken());
			int q1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int p2 = Integer.parseInt(st.nextToken());
			int q2 = Integer.parseInt(st.nextToken());
			
			if (p1 < x2 || x1 > p2 || q1 < y2 || y1 > q2) {
				sb.append("d\n");
			} else if (p1 == x2 && y1 == q2 || p1 == x2 && q1 == y2 || x1 == p2 && q1 == y2 || x1 == p2 && y1 == q2) {
				sb.append("c\n");
			} else if (p1 == x2 || x1 == p2 || q1 == y2 || y1 == q2) {
				sb.append("b\n");
			} else {
				sb.append("a\n");
			}
		}
		System.out.println(sb);
		
	}
}
