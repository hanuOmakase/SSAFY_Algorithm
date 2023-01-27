import java.io.*;
import java.util.*;

public class _2563_S5 {
	public static void main(String[] args) throws Exception {
		int[][] map = new int[100][100];

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			for(int j=r;j<r+10;j++) {
				for(int k=c;k<c+10;k++) {
					map[j][k] = 1;
				}
			}
		}
		// print out
		int size = 0;
		for(int i=0;i<map.length;i++) {
			for(int j=0;j<map[i].length;j++) {
				if(map[i][j] == 1) size++;
			}
		}
		System.out.println(size);
	}
}
