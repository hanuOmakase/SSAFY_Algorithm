package BOJ;
import java.util.*;

public class Main_2447 {
    static char[][] arr;
    static void draw(int x, int y, int s){
        if(s == 3) arr[x][y]=arr[x][y+1]=arr[x][y+2]=arr[x+1][y]=arr[x+1][y+2]=arr[x+2][y]=arr[x+2][y+1]=arr[x+2][y+2]='*';
        else {s/=3; draw(x,y,s); draw(x,y+s,s); draw(x,y+s*2,s); draw(x+s,y,s); draw(x+s,y+s*2,s); draw(x+s*2,y,s); draw(x+s*2,y+s,s); draw(x+s*2,y+s*2,s);}
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt();
        arr= new char[N][N];
        for(int i=0; i<N; i++) for(int j=0; j<N; j++) arr[i][j] = ' ';
        draw(0, 0, N);
        for(int i=0; i<N; i++){for(int j=0; j<N; j++){sb.append(arr[i][j]);}sb.append('\n');}
        System.out.print(sb);
    }
}
