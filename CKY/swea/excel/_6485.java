package CKY.swea.excel;

import java.util.*;
import java.io.*;

public class _6485 {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		int[] arr = new int[5001];

		for (int i = 1; i <= count; i++) {
			int busesCount = Integer.parseInt(br.readLine());

			while (busesCount-- > 0) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());

				for (int j = s; j <= e; j++) {
					arr[j]++;
				}
			}

			int wannaKnowStationCount = Integer.parseInt(br.readLine());
			List<Integer> list = new ArrayList<>();
			while (wannaKnowStationCount-- > 0) {
				int station = Integer.parseInt(br.readLine());
				list.add(station);
			}

			sb.append("#").append(i).append(" ");
			for (int station : list) {
				sb.append(arr[station]).append(" ");
			}

			sb.append("\n");
			Arrays.fill(arr, 0);
		}
		System.out.println(sb.toString().trim());
	}
}
