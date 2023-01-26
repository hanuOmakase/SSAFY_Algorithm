package CKY.swea.excel;

import java.util.*;
import java.io.*;

public class _1940 {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = Integer.parseInt(br.readLine().trim());

		for (int i = 1; i <= count; i++) {
			int lines = Integer.parseInt(br.readLine()); // 이동 시간 s

			int moveDistance = 0;
			int speed = 0;
			for (int j = 0; j < lines; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine().trim());
				int fir = Integer.parseInt(st.nextToken());
				if (fir == 0) {
					moveDistance += speed;
				} else {
					if (fir == 1) { // 가속
						speed += Integer.parseInt(st.nextToken());
						moveDistance += speed;
					} else { // 감속
						speed -= Integer.parseInt(st.nextToken());
						if (speed < 0)
							speed = 0;
						moveDistance += speed;
					}
				}
			}
			System.out.println("#" + i + " " + moveDistance);
		} // end for
	}
}
