import java.util.Scanner;

public class P1493 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] graph = new int [300][300];
		int cnt = 1;
		for(int i = 299; i >= 0; i--) {
			int x = 0;
			int y = i;
			while(y < 300) {
				graph[y][x] = cnt;
				cnt++;
				x++;
				y++;
			}
		}
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			int p = sc.nextInt();
			int q = sc.nextInt();
			int dx = 0;
			int dy = 0;
			int py = 0;
			int px = 0;
			int qy = 0;
			int qx = 0;
			for(int i = 299; i >= 0; i--) {
				for(int j = 0; j < 300; j++) {
					if(graph[i][j] == p) {
						py = i;
						px = j;
					}
					if(graph[i][j] == q) {
						qy = i;
						qx = j;
					}
				}
			}
			dx = qx + px + 1;
			dy = 299 - ((299 - qy) + (299 - py)) - 1;
			System.out.println("#" + tc + " " + graph[dy][dx]);
		}
		sc.close();
	}
}
