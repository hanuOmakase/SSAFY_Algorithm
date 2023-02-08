package JUNGOL;

import java.util.*;

public class _1037 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] arr = new int[N][N];
        for(int i=0; i<N; i++) {
            for(int j=0; j<N;j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        int[] row = new int[N], col = new int[N];
        for(int i=0; i<N; i++) {
            int r = 0, c = 0;
            for(int j=0; j<N; j++) {
                if(arr[i][j]== 1 ) r++;
                if(arr[j][i]== 1 ) c++;
            }
            if(r%2==0) row[i]= 1;
            if(c%2==0) col[i]= 1;
        }
        int r=-1, c=-1;
        for(int i=0; i<N;i++) {
            if(row[i]== 0) {
                if(r == -1) {r = i;}
                else {r = -2;break;}
            }
            if(col[i]== 0) {
                if(c == -1) {c = i;}
                else {c = -2;break;}
            }
        }
        if(r==-2 || c==-2) {System.out.println("Corrupt");}
        else if(r==-1 && c==-1) {System.out.println("OK");}
        else if(r==-1 || c==-1) {System.out.println("Corrupt");}
        else {System.out.printf("Change bit (%d,%d)",r+1,c+1);}
    }
}