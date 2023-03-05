import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10163 { // 10163. 색종이
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int[][] plane = new int[1001][1001];
		
		int N = Integer.parseInt(br.readLine());
		int maxX = 0;
		int maxY = 0;
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			
			if (x + w > maxX) { maxX = x + w; }
			if (y + h > maxY) { maxY = y + h; }
			
			for (int r = x; r < x + w; r++) { // 방향 상관없
				for (int c = y; c < y + h; c++) {
					plane[r][c] = i;
				}
			}
		}
		
		int[] area = new int[N]; // 보이는 면적
		for (int i = 0; i < maxX; i++) {
			for (int j = 0; j < maxY; j++) {
				if (plane[i][j] > 0) {
					area[plane[i][j] - 1]++;
				}
			}
		}
		
		for (int i = 0; i < area.length; i++) {
			sb.append(area[i]).append("\n");
		}
		System.out.println(sb);
	}
}
