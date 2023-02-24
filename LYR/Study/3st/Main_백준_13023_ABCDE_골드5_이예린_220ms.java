import java.io.*;
import java.util.*;

public class Main_백준_13023_ABCDE_골드5_이예린_220ms {
	static int N;
	static int M;
	static boolean isExist = false;
	static boolean[] isVisited;
	static ArrayList<Integer>[] relations;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		isVisited = new boolean [N];
		relations = new ArrayList [N];
		for(int i = 0; i < N; i++)
			relations[i] = new ArrayList<Integer>();
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int left = Integer.parseInt(st.nextToken());
			int right = Integer.parseInt(st.nextToken());
			relations[left].add(right);
			relations[right].add(left);
		}
		for(int i = 0; i < N; i++) {
			isVisited[i] = true;
			dfs(0, i);
			if(isExist) break;
			isVisited[i] = false;
		}
		System.out.println(isExist ? "1" : "0");
	}
	public static void dfs(int cnt, int currFriend) {
		if(cnt == 4) {
			isExist = true;
			return;
		}
		for(int i = 0; i < relations[currFriend].size(); i++) {
			int nextFriend = relations[currFriend].get(i);
			if(isVisited[nextFriend]) continue;
			isVisited[nextFriend] = true;
			dfs(cnt + 1, nextFriend);
			if(isExist) return;
			isVisited[nextFriend] = false;
		}
	}
}
