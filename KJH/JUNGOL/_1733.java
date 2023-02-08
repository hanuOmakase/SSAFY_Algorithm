package JUNGOL;
import java.util.*;
public class _1733 {
    static boolean[][][][] visited = new boolean[3][4][21][21];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] arr;
        int[] dx= {0, 1, 1, 1}, dy = {1, 0, 1, -1};
        arr = new int[21][21];
        int x, y, nx, ny, temp=1;
        for(int i=1; i<=19; i++) {for(int j=1; j<=19; j++) {arr[i][j]= sc.nextInt();}}
        for(int i=1; i<=19; i++) {
            for(int j=1; j<=19; j++) {
                if(arr[i][j]==0 ) continue;
                for(int k=0; k<4; k++) {
                    temp = 1;
                    if(visited[arr[i][j]][k][i][j]) continue;
                    visited[arr[i][j]][k][i][j]= true;
                    nx = i + dx[k]; ny = j + dy[k];
                    while(nx>=1 && nx<=19 && ny>=1 && ny<=19 && arr[nx][ny] == arr[i][j] && !visited[arr[i][j]][k][nx][ny]) {
                        visited[arr[i][j]][k][nx][ny] = true;
                        temp += 1; nx = nx + dx[k]; ny = ny + dy[k];
                    }
                    if(temp == 5) {
                        System.out.println(arr[i][j]);
                        if(k==3) {System.out.println((i+4)+" "+(j-4));}
                        else System.out.println(i+" "+j);
                        System.exit(0);
                    }
                }
            }
        }
        System.out.println(0);
    }
}
