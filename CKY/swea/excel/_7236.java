package CKY.swea.excel;

import java.util.*;
import java.io.*;

public class _7236 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		for(int i =1; i<=testCase; i++) {
			int size = Integer.parseInt(br.readLine());
			
			String[][] arr = new String[size][size];
			for(int j =0; j<size; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int k =0; k<size; k++) {
					arr[j][k] = st.nextToken();
				}
			}
			
			int maxDepth = 0;
			for(int j =0; j<size; j++) {
				for(int k =0; k<size; k++) {
					maxDepth = Math.max(maxDepth, search(arr, j, k));
				}
			}
			System.out.println("#" + i + " " + maxDepth);
		}
	}
	
	public static int search(String[][] arr, int x, int y) {
		int[] xRange = {-1, -1, -1, 0, 1, 1, 1, 0};
		int[] yRange = {-1, 0, 1, 1, 1, 0, -1, -1};
		int depth = 0;
		
		for(int i = 0; i<8; i++) {
			int nx = x + xRange[i];
			int ny = y + yRange[i];
			
			if(nx >=0 && arr.length > nx && ny >= 0 && ny < arr.length) {
				if(arr[nx][ny].equals("W"))
					depth++;
			}
		}
		
		if(depth == 0) 
			depth = 1;
		return depth;
	}
}
