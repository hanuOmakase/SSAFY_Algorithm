import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_11660_구간합구하기5_실버1_김영도_740ms {
	static int[][] map;
	static int[][] sum;
	public static void main(String[] args) throws Exception{
		// (x,y) ~ (r,c) 까지의 합
		// index는 1부터 시작
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =  new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		map = new int[N+1][N+1];
		for(int i=1;i<map.length;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<map[i].length;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		sum = new int[N+1][N+1];
		// init
		for(int i=1;i<sum.length;i++) sum[i][1] = map[i][1];
		
		for(int i=1;i<sum.length;i++) {
			for(int j=1;j<sum[i].length;j++) {
				sum[i][j] = sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1] + map[i][j];
			}
		}
		// answer 
		StringBuilder sb = new StringBuilder();
		for(int tc=0; tc<M; tc++) {
			st = new StringTokenizer(br.readLine());
			int x1, x2, y1, y2;
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());
			
			sb.append(sum[x2][y2]- sum[x1-1][y2] - sum[x2][y1-1] + sum[x1-1][y1-1]).append("\n");
		}
		System.out.println(sb.toString());
		
	}
}
