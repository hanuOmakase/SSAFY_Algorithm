package CKY.boj.excel;

import java.util.*;
import java.io.*;

public class _2477 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int point = Integer.parseInt(br.readLine());

		Map<Integer, List<Integer>> hm = new HashMap<>();
		int maxRow = 0;
		int maxCol = 0;
		int[] arr = new int[6];
		int idx = 0;

		for (int i = 0; i < 6; i++) {
			st = new StringTokenizer(br.readLine());
			int dir = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			if (dir == 4 || dir == 3)
				maxRow = Math.max(maxRow, m);
			else if (dir == 1 || dir == 2)
				maxCol = Math.max(maxCol, m);

			if (hm.containsKey(dir)) {
				hm.get(dir).add(m);
			} else
				hm.put(dir, new ArrayList<>(Arrays.asList(m)));

			arr[idx++] = dir;
		}

		boolean reverse1 = false;
		int key1 = 0;
		boolean reverse2 = false;
		int key2 = 0;
		if (arr[0] == arr[4]) {
			reverse1 = true;
			key1 = arr[0];
		}

		if (arr[1] == arr[5]) {
			reverse2 = true;
			key2 = arr[1];
		}

		int max = maxCol * maxRow;
		// 2, 4 / 4, 1 / 1, 3 / 2, 3
		// 2.1 4.2 / 2.2 1.1 / 3.2 1.1 / 2.2 3.1
		// 중간에서 시작하면 이 순서가 유효하지 않아, 역순정렬필요
		int order = 1;
		for (Map.Entry<Integer, List<Integer>> me : hm.entrySet()) {
			if (me.getValue().size() >= 2) {
				order *= me.getKey();
				if (reverse1 && key1 == me.getKey()) 
					Collections.reverse(me.getValue());
				if (reverse2 && key2 == me.getKey()) 
					Collections.reverse(me.getValue());
			}
		}

		int minus = 0;
		switch (order) {
		case 8:
			minus = hm.get(2).get(0) * hm.get(4).get(1);
			break;
		case 6:
			minus = hm.get(2).get(1) * hm.get(3).get(0);
			break;
		case 4:
			minus = hm.get(4).get(0) * hm.get(1).get(1);
			break;
		case 3:
			minus = hm.get(3).get(1) * hm.get(1).get(0);
			break;
		}
		System.out.println((max - minus) * point);
	}
}