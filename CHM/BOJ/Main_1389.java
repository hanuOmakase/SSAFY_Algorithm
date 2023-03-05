
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1389 { // 1389. 케빈 베이컨의 6단계 법칙
	
	static int N; // 유저의 수
	static int M; // 친구 관계의 수
	static int[][] people; // 친구 관계 저장
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		people = new int[N][N];
		
//		배열 초기값 세팅
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (i == j) {
					people[i][j] = 0; // 자기 자신
				} else {
					people[i][j] = 10000;
				}	
			}		
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int A = Integer.parseInt(st.nextToken()) - 1;
			int B = Integer.parseInt(st.nextToken()) - 1;
			people[A][B] = people[B][A] = 1;
		}
		
//		플로이드-워셜
		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (people[i][j] > people[i][k] + people[k][j]) {
						people[i][j] = people[i][k] + people[k][j];
					}
				}
			}
		}
		
		int min = Integer.MAX_VALUE; // 케빈베이컨의 수 최소값
		int minIndex = -1; // 케빈베이컨의 수가 최소인 사람
		for (int i = 0; i < N; i++) {
			int sum = 0; // 케빈베이컨의 수 누적합
			for (int j = 0; j < N; j++) {
				sum += people[i][j];
			}
			
			if (sum < min) {
				min = sum;
				minIndex = i + 1;
			}
		}
		
		System.out.println(minIndex);
	}

}
