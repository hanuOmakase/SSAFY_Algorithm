
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2606 { // 2606. 바이러스
	
	private static int[][] computers; // 컴퓨터 연결 정보
	private static boolean[] isChecked; // 바이러스 감염 여부 확인했는지
	private static int N; // 컴퓨터 수
	private static int cnt; // 바이러스에 걸리게 되는 컴퓨터 수 (1번 제외)
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine());
		int pairs = Integer.parseInt(br.readLine());
		computers = new int[pairs][2];
		isChecked = new boolean[N];
		for (int i = 0; i < pairs; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 2; j++) {
				computers[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		isChecked[0] = true; // 1번 컴퓨터는 감염
		virus(1); // 1번 컴퓨터에 의해 감염
		
		System.out.println(cnt);

	}

	private static void virus(int from) {
		
		for (int i = 0; i < computers.length; i++) {
			if (computers[i][0] == from) { // 감염된 컴퓨터이면 연결된 컴퓨터 확인
				if(isChecked[computers[i][1] - 1]) { // 연결된 컴퓨터가 이미 감염 여부 체크한 상태이면
					continue;
				}
				// 감염 여부 체크하지 않은 컴퓨터이면 (= 이제 감염된 것을 확인한 상태)
				cnt++;
				isChecked[computers[i][1] - 1] = true;
				virus(computers[i][1]); // 해당 컴퓨터랑 연결된 컴퓨터 감염 여부 확인
			}
			
			// 반대의 경우도 check
			if (computers[i][1] == from) {
				if(isChecked[computers[i][0] - 1]) {
					continue;
				}
				cnt++;
				isChecked[computers[i][0] - 1] = true;
				virus(computers[i][0]);
			}
		}
		
		return; // for문 다 돌면 return
		
	}
}
