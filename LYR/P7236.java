package SWEA;

import java.util.Scanner;

public class P7236 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        final int[] dx = {1, 0, -1, 0, -1, 1, -1, 1};
        final int[] dy = {0, 1, 0, -1, -1, -1, 1, 1};
        for(int tc = 1; tc <= T; tc++){
            int N = sc.nextInt();

            //저수지 초기화 & 입력
            char[][] water = new char [N][N];
            for(int i = 0; i < N; i++)
                for(int j = 0; j < N; j++)
                    water[i][j] = sc.next().charAt(0);

            int max = 0;
            boolean isWater = false;

            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    if(water[i][j] == 'W'){
                        isWater = true;
                        int cnt = 0;
                        for(int k = 0; k < 8; k++){
                            int x = j + dx[k];
                            int y = i + dy[k];
                            if(0 <= x && x < N  && 0 <= y && y < N && water[y][x] == 'W')
                                cnt++;
                        }
                        if(max < cnt) max = cnt;
                    }
                }
            }
            if(isWater && max == 0) max = 1;
            System.out.println("#" + tc + " " + max);
        }
        sc.close();
    }
}
