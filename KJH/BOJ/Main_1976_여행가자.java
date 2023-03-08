package BOJ;

import java.util.*;

public class Main_1976_여행가자 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), M = sc.nextInt(), pre, next;
        int[][] arr = new int[N][N];
        for(int i=0; i<N; i++) for(int j=0; j<N; j++) arr[i][j] = sc.nextInt();
        for(int k=0; k<N; k++) for(int i=0; i<N; i++) for(int j=0; j<N; j++) if(arr[i][k] == 1 && arr[k][j] == 1) arr[i][j] = 1;
        for(int i=0; i<N; i++) arr[i][i] = 1;
        pre = sc.nextInt()-1;
        boolean flag = true;
        for(int i=1; i<M; i++){
            next = sc.nextInt()-1;
            if(arr[pre][next] == 0) flag = false;
            pre = next;
        }
        if(flag) System.out.println("YES");
        else System.out.println("NO");
    }
}
