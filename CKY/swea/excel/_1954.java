package CKY.swea.excel;

import java.util.*;
import java.io.*;

public class _1954 {
	static int[][] arr;
	static int number;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = Integer.parseInt(br.readLine().trim());

		for (int i = 1; i <= count; i++) {
			number = 1;
			int size = Integer.parseInt(br.readLine().trim());

			arr = new int[size][size];

			dal();
			
			System.out.println("#" + i);
			for (int i1 = 0; i1 < size; i1++) {
				for (int i2 = 0; i2 < size; i2++) {
					System.out.print(arr[i1][i2] + " ");
				}
				System.out.println();
			}
		}
	}

	public static void dal() {
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(0, 0, 1));

		int size = arr.length;

		while (!q.isEmpty()) {
			Node n = q.poll();

			arr[n.x][n.y] = number++;

			// 확인, 전진
			if (forward(n)) {
				q.offer(n);
			} else {
				// else 벽이거나, 0이 아니면 방향 전환
				switchDir(n);
				// 방향전환후 다시 확인
				if (forward(n)) {
					q.offer(n);
				} else {
					break;
				}
			}
		}
	}

	public static void switchDir(Node n) {
		int dir = n.dir;
		if (dir == 0) {
			n.dir = 1;
		} else if (dir == 1) {
			n.dir = 2;
		} else if (dir == 2) {
			n.dir = 3;
		} else if (dir == 3) {
			n.dir = 0;
		}
	}

	public static boolean forward(Node n) {
		int size = arr.length;
		int dir = n.dir;
		int x = n.x;
		int y = n.y;

		if (dir == 0) {
			x = x - 1;
			if (x < size && x >= 0) {
				if (arr[x][y] == 0) {
					n.x--;
					return true;
				}
			}

		} else if (dir == 1) {
			y = y + 1;
			if (y < size) {
				if (arr[x][y] == 0) {
					n.y++;
					return true;
				}
			}
		} else if (dir == 2) {
			x = x + 1;
			if (x < size) {
				if (arr[x][y] == 0) {
					n.x++;
					return true;
				}
			}
		} else if (dir == 3) {
			y = y - 1;
			if (y < size && y >= 0) {
				if (arr[x][y] == 0) {
					n.y--;
					return true;
				}
			}
		}
		return false;
	}
}

class Node {
	int x, y, dir;

	public Node(int x, int y, int dir) {
		this.x = x;
		this.y = y;
	}
}
