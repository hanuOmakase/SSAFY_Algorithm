import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_11659_구간합구하기4_실버3_김영도_552ms {
	static int[] arr;
	static int tmpN;
	static int[] tree;
	/*
	 * Version 1. -> i번쨰 까지의 합 저장 576ms / 56324 KB
	 */

	/*
	 * Version 2. -> SegmentTree 이용 576ms / 58164 KB
	 */
	public static void main(String[] args) throws Exception {
		// i ~ j 번쨰 수 까지의 합을 구하기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N, M;
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		int tmp = 0;
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken()); // input end

		// start
		makeTree();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());

			sb.append(getValue(s - 1, e - 1)).append("\n");
		}
		System.out.println(sb.toString());
	}

	/** index 는 0부터 시작 */
	private static int getValue(int from, int end) {
		int s = tmpN + from;
		int e = tmpN + end;

		int sum = 0;
		while (s <= e) {
			// s가 오른쪽 자식일 경우
			if ((s & 1) == 1) {
				sum += tree[s];
				s++;
			}
			s >>= 1;

			// e가 왼쪽 자식일 경우
			if ((e & 1) == 0) {
				sum += tree[e];
				e--;
			}
			e >>= 1;
		}
		return sum;
	}

	private static void makeTree() {
		// TODO Auto-generated method stub
		tmpN = (int) Math.pow(2, Math.ceil(Math.log(arr.length) / Math.log(2)));
		tree = new int[2 * tmpN];
		System.arraycopy(arr, 0, tree, tmpN, arr.length);

		// update
		for (int i = tmpN - 1; i > 0; i--) {
			tree[i] = tree[2 * i] + tree[2 * i + 1];
		}
	}

	/* Verson1. 1~i번쨰 합 이용 */
//	static int[] arr;
//	static int[] sum; // 0 ~ i 번쨰 자리까지의 합
//
//	public static void main(String[] args) throws Exception {
//		// i ~ j 번쨰 수 까지의 합을 구하기
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int N, M;
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		N = Integer.parseInt(st.nextToken());
//		M = Integer.parseInt(st.nextToken());
//		arr = new int[N];
//		sum = new int[N+1];
//		st = new StringTokenizer(br.readLine());
//		int tmp =0;
//		for (int i = 0; i < N; i++) {
//			arr[i] = Integer.parseInt(st.nextToken()); // input end
//			tmp += arr[i];
//			sum[i+1] = tmp;
//		}
//
//		// start
//		StringBuilder sb = new StringBuilder();
//		for(int tc=0; tc<M; tc++) {
//			st = new StringTokenizer(br.readLine());
//			int s, e;
//			s = Integer.parseInt(st.nextToken());
//			e = Integer.parseInt(st.nextToken());
//			
//			sb.append(sum[e] - sum[s-1]).append("\n");
//		}
//		System.out.println(sb.toString());
//	}

}
