package CKY.jo.excel;

import java.io.*;
import java.util.*;

public class _1733 {
	static int[] win = new int[2];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] arr = new int[19][19];

		for (int i = 0; i < 19; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 19; j++)
				arr[i][j] = Integer.parseInt(st.nextToken());
		}

		int answer = 0;
		answer = search(arr);
		
		if (answer == 1)
			System.out.println(answer + "\n" + win[0] + " " + win[1]);
		else if (answer == 2)
			System.out.println(answer + "\n" + win[0] + " " + win[1]);
		else
			System.out.println(0);
	}

	public static int search(int[][] arr) {
		for (int i = 0; i < 19; i++) {
			for (int j = 0; j < 19; j++) {
				if(arr[i][j] != 0) {
					for(int k =1; k<=4; k++) {
						if(check(arr, i, j, k, 1))
							return 1;
						if(check(arr, i, j, k, 2))
							return 2;
					}
				}
			}
		}
		return 0;
	}

	public static boolean check(int[][] arr, int x, int y, int dir, int playerNumber) {
		int count = 0;
		// range
		if (dir == 1) {
			if (!(x - 4 >= 0 && y + 4 < arr.length))
				return false;
		} else if (dir == 2) {
			if (!(y + 4 < arr.length))
				return false;
		} else if (dir == 3) {
			if (!(x + 4 <arr.length && y + 4 < arr.length))
				return false;
		} else if (dir == 4) {
			if (!(x + 4 < arr.length))
				return false;
		}

		// number
		for (int i = 0; i < 5; i++) {
			if (dir == 1 && arr[x - i][y + i] == playerNumber) {
				count++;
			} else if (dir == 2 && arr[x][y + i] == playerNumber) {
				count++;
			} else if (dir == 3 && arr[x + i][y + i] == playerNumber) {
				count++;
			} else if (dir == 4 && arr[x + i][y] == playerNumber) {
				count++;
			}
		}
		
		if(count != 5)
			return false;
		
		if (dir == 1) {
			if(x - 5 >= 0 && y+5 < arr.length) {
				if(arr[x-5][y+5] == playerNumber)
					return false;
			}
		} else if (dir == 2) {
			if(y+5 < arr.length) {
				if(arr[x][y+5] == playerNumber)
					return false;
			}
		} else if (dir == 3) {
			if(x + 5 < arr.length && y+5 < arr.length) {
				if(arr[x+5][y+5] == playerNumber)
					return false;
			}
		} else if (dir == 4) {
			if(x + 5 <arr.length) {
				if(arr[x+5][y] == playerNumber)
					return false;
			}
		}
		
		if (dir == 1) {
			if(x + 1 <arr.length && y-1 >= 0) {
				if(arr[x+1][y-1] == playerNumber)
					return false;
			}
		} else if (dir == 2) {
			if(y-1 >=0 ) {
				if(arr[x][y-1] == playerNumber)
					return false;
			}
		} else if (dir == 3) {
			if(x - 1 >= 0 && y-1 >= 0 ) {
				if(arr[x-1][y-1] == playerNumber)
					return false;
			}
		} else if (dir == 4) {
			if(x - 1 >= 0) {
				if(arr[x-1][y] == playerNumber)
					return false;
			}
		}
		win[0] = x + 1;
		win[1] = y + 1;
		return true;
	}
}
