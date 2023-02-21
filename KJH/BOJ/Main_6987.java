package BOJ;

import java.util.Scanner;

public class Main_6987 {
    static int[][] arr;
    static int[] dt1 = {0, 1, 2}, dt2 = {2, 1, 0};
    static boolean flag;
    public static void dfs(int t1, int t2) {
        if(t1 == 5) {
            for(int i=0; i<6; i++) {for(int j=0; j<3; j++) {if(arr[i][j]!= 0) return;}}
            flag = true;
            return;
        }
        if(t2 == 6) {dfs(t1+1, t1+2); return;}
        for(int i=0; i<3; i++) {
            if(arr[t1][dt1[i]] >= 1 && arr[t2][dt2[i]] >= 1 && !flag) {
                arr[t1][dt1[i]] -= 1;  arr[t2][dt2[i]]-= 1;
                dfs(t1, t2+1);
                arr[t1][dt1[i]] += 1;  arr[t2][dt2[i]]+= 1;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int k=0; k<4; k++) {
            flag = false;
            arr = new int[6][3];
            for(int i=0; i<6; i++) {
                arr[i][0] = sc.nextInt(); arr[i][1] = sc.nextInt(); arr[i][2] = sc.nextInt();
            }
            dfs(0, 1);
            if(flag) System.out.print("1 ");
            else System.out.print("0 ");
        }
    }
}
