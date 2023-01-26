
import java.util.*;

public class _2309_B1 {

	static List<Integer> answer = new ArrayList<>();
	static boolean found = false;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 합이 100이 되는 경우의 수 찾기 -> 조합
		int[] num = new int[9];
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 9; i++) {
			num[i] = sc.nextInt();
		}

		// start
		Arrays.sort(num);
		boolean[] used = new boolean[9];
		dfs(num, 0, 0, used);

		// answer out
		for (int w : answer)
			System.out.println(w);
	}

	private static void dfs(int[] num, int depth, int cnt, boolean[] used) {
		// TODO Auto-generated method stub
		// backtracking
		if (found)
			return;
		if (cnt == 7) {
			int sum = 0;
			for (int i = 0; i < 9; i++) {
				if (used[i])
					sum += num[i];
			}
			if (sum == 100) {
				found =true;
				for (int i = 0; i < 9; i++) {
					if (used[i])
						answer.add(new Integer(num[i]));
				}
			}
			return;
		}
		if (depth >= num.length)
			return;

		// progress
		used[depth] = true;
		dfs(num, depth + 1, cnt + 1, used);
		used[depth] = false;
		dfs(num, depth + 1, cnt, used);
	}

}
