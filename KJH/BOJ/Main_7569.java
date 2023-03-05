package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_7569 {
    static class p{
        int x, y, z;
        public p(int x, int y, int z) {
            this.x = x; this.y = y; this.z = z;
        }
    }
    static int[][][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int siz, ans = 0, nx, ny, nz, num=0;
        int M=Integer.parseInt(st.nextToken());
        int N=Integer.parseInt(st.nextToken());
        int H=Integer.parseInt(st.nextToken());
        int[] dx={-1, 0, 1, 0, 0, 0}, dy={0, 1, 0, -1, 0, 0}, dz={0, 0, 0, 0, 1, -1};
        p tmp;
        arr = new int[N][M][H];
        Queue<p> wait = new ArrayDeque<>();
        for(int z=0; z<H; z++){
            for(int i=0; i<N; i++){
                st = new StringTokenizer(bf.readLine());
                for(int j=0; j<M; j++){
                    arr[i][j][z] =Integer.parseInt(st.nextToken());
                    if(arr[i][j][z] == 0) num += 1;
                    else if(arr[i][j][z] == 1) wait.add(new p(i, j, z));
                }
            }
        }
        while(!wait.isEmpty()){
            if(num == 0) break;
            siz = wait.size();
            for(int t=0; t<siz; t++){
                tmp = wait.poll();
                for(int i=0; i<6; i++){
                    nx = tmp.x + dx[i]; ny = tmp.y + dy[i]; nz = tmp.z + dz[i];
                    if(nx<0 || nx>=N || ny<0 || ny>=M || nz<0 || nz>=H) continue;
                    if(arr[nx][ny][nz] == 0){
                        arr[nx][ny][nz] = 1;
                        num -= 1;
                        wait.add(new p(nx, ny , nz));
                    }
                }
            }
            ans += 1;
        }
        if(num == 0) System.out.print(ans);
        else System.out.print(-1);
    }
}
