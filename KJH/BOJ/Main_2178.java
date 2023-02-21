package BOJ;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;
public class Main_2178 {
    public static void main(String[] args) {
        int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1}, tmp;
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), M = sc.nextInt(), x, y, nx, ny, val, ans=-1;
        char[][] arr = new char[N][];
        for(int i=0; i<N; i++) {
            arr[i]= sc.next().toCharArray();
        }
        boolean[][] visited = new boolean[N][M];
        visited[0][0] = true;
        Queue<int[]> wait = new ArrayDeque<int[]>();
        wait.add(new int[]{0, 0, 1});
        while(!wait.isEmpty() && ans == -1) {
            tmp = wait.poll();
            x = tmp[0]; y = tmp[1]; val = tmp[2];
            for(int i=0; i<4; i++) {
                nx = x + dx[i]; ny = y + dy[i];
                if(0<=nx && nx<N && 0<=ny && ny<M && arr[nx][ny]=='1' && !visited[nx][ny]) {
                    if(nx == N-1 && ny == M-1) {
                        ans = val+1;
                        break;
                    }
                    wait.add(new int[] {nx, ny, val+1});
                    visited[nx][ny]= true;
                }
            }
        }
        System.out.println(ans);
    }
}
