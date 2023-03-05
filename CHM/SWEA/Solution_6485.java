
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// i번째 버스 노선 -> 번호가 A 이상, B 이하인 정류장만 다님
// P개의 버스 정류장 -> 각 정류장에 몇 개의 버스 노선?
public class Solution_6485 { // 6485. 삼성시의 버스 노선
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스
		
		for (int i = 1; i <= T; i++) {
			int[] busStop = new int[5001]; // 버스 정류장
			sb.append("#").append(i).append(" ");
			
			int N = Integer.parseInt(br.readLine()); // 버스 노선
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());
				
				for (int k = A; k <= B; k++) {
					busStop[k]++;
				}
			}
			
			int P = Integer.parseInt(br.readLine()); // 정류장 번호
			for (int j = 0; j < P; j++) {
				int C = Integer.parseInt(br.readLine());
				sb.append(busStop[C]).append(" ");
			}
			sb.append("\n");
			
		} // end of for testCase

		System.out.println(sb);
	}
}