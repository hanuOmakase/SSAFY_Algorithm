package CKY.swea.excel;

import java.util.*;
import java.io.*;

public class _2805 {
	static int[][] arr;
	static int sum;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int i = 1; i <= count; i++) {
			int size = Integer.parseInt(br.readLine());
			arr = new int[size][size];

			for (int i1 = 0; i1 < size; i1++) {
				String str = br.readLine();
				for (int i2 = 0; i2 < size; i2++) {
					arr[i1][i2] = str.charAt(i2) - '0';
				}
			}
			bfs(size / 2);
			System.out.println("#" + i + " " + sum);
			sum = 0;
		}
	}

	public static void bfs(int start) {
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(start, start));
		sum += arr[start][start];
		arr[start][start] = -1;

		int[] xRange = { 1, -1, 0, 0 };
		int[] yRange = { 0, 0, 1, -1 };

		while (!q.isEmpty()) {
			Node n = q.poll();

			int x = n.x;
			int y = n.y;

			for (int i = 0; i < 4; i++) {
				int x1 = x + xRange[i];
				int y1 = y + yRange[i];

				if (x1 < 0 || x1 >= arr.length || y1 < 0 || y1 >= arr.length)
					return;

				if (arr[x1][y1] == -1)
					continue;

				sum += arr[x1][y1];
				arr[x1][y1] = -1;
				q.offer(new Node(x1, y1));
			}
		}
	}
}

class Node {
	int x, y;

	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}
}