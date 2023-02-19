package BOJ;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_1012 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
        int T = sc.nextInt();
        for(int t=0; t<T; t++){
            int N=sc.nextInt(), M=sc.nextInt(), K=sc.nextInt(), x, y, nx, ny, ans=0;
            int[][] arr = new int[N][M];
            for(int i=0; i<K; i++){
                x=sc.nextInt(); y=sc.nextInt();
                arr[x][y] = 1;
            }
            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    if(arr[i][j] == 1){
                        ans += 1;
                        Queue<int[]> wait = new LinkedList<int[]>();
                        wait.add(new int[]{i, j});
                        while(!wait.isEmpty()){
                            x = wait.peek()[0]; y = wait.peek()[1];
                            arr[x][y] = 0;
                            wait.remove();
                            for(int k=0; k<4; k++){
                                nx = x + dx[k]; ny = y + dy[k];
                                if(0<=nx && nx < N && 0<=ny && ny < M && arr[nx][ny] == 1){
                                    arr[nx][ny] = 0;
                                    wait.add(new int[]{nx, ny});
                                }
                            }
                        }
                    }
                }
            }
            System.out.println(ans);
        }
    }
}
