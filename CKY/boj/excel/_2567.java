package CKY.boj.excel;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2567 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] arr = new int[101][101];
        int papers = Integer.parseInt(br.readLine());
        while (papers-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            for (int i = x; i < x + 10; i++) {
                for (int j = y; j < y + 10; j++) {
                    arr[i][j] = 1;
                }
            }
        }

        int count = 0;

        for (int i = 1; i < 101; i++) {
            for (int j = 1; j < 101; j++) {
                if (arr[i][j] == 1)
                    count += search(arr, i, j);
            }
        }
        System.out.println(count);
    }

    public static int search(int[][] arr, int x, int y) {
        int[] xRange = {1, -1, 0, 0};
        int[] yRange = {0, 0, 1, -1};

        int count = 0;

        for (int i = 0; i < 4; i++) {
            int nx = x + xRange[i];
            int ny = y + yRange[i];

            if (nx >= 0 && nx < arr.length && ny >= 0 && ny < arr.length) {
                if(arr[nx][ny] == 0)
                    count++;
            } else { // 벽 0의 역할
                count++;
            }
        }

        if (count == 2) {
            return 2;
        } else if (count == 1) {
            return 1;
        }else
            return 0;
    }
}
