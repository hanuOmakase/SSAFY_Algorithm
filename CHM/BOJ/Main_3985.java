import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_3985 { // 3985. 롤 케이크
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int L = Integer.parseInt(br.readLine());
		int[] roll = new int[L]; // 롤케이크
		
		int max = 0;
		int maxIndex = 0;
		int N = Integer.parseInt(br.readLine()); // 방청객 수
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int P = Integer.parseInt(st.nextToken()) - 1;
			int K = Integer.parseInt(st.nextToken()) - 1;
			
			if (K - P > max) { max = K - P; maxIndex = i; }
			
			for (int j = P; j <= K; j++) {
				if (roll[j] == 0) { roll[j] = i; } // 번호가 써져있지 않을 때만 번호 적기
			}
		}
		System.out.println(maxIndex);
		
		int[] pieces = new int[N + 1];
		for (int i = 0; i < roll.length; i++) {
			pieces[roll[i]]++;
		}
		
		int maxPiece = 0;
		int maxPieceIndex = 0;
		for (int i = 1; i < pieces.length; i++) {
			if (pieces[i] > maxPiece) {
				maxPiece = pieces[i];
				maxPieceIndex = i;
			}
		}
		System.out.println(maxPieceIndex);
	}
}
