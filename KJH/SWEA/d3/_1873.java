package SWEA.d3;
import java.util.Scanner;

public class _1873{
    public static void main(String[] args) {
        StringBuilder ans = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        int T=sc.nextInt(),N, M, K;
        int[] dx= {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
        for(int tc=1; tc<=T; tc++) {
            N = sc.nextInt(); M = sc.nextInt();
            int x=-1, y=-1, d=-1, nx, ny;
            char[][] arr = new char[N][];
            for(int i=0; i<N; i++) arr[i]= sc.next().toCharArray();
            for(int i=0; i<N; i++) {
                for(int j=0; j<M; j++) {
                    if(arr[i][j]== '^') {d=0;}
                    else if(arr[i][j]== '>') {d=1;}
                    else if(arr[i][j]== 'v') {d=2;}
                    else if(arr[i][j]== '<') {d=3;}
                    if(d!=-1) {x = i; y = j ;arr[i][j]= '.'; break;}
                }
                if(d!=-1) break;
            }
            K = sc.nextInt();
            char[] ord = sc.next().toCharArray();
            for(char c: ord) {
                if(c=='S') {
                    nx = x + dx[d]; ny = y + dy[d];
                    while((0<=nx && nx<N && 0<=ny && ny<M) && (arr[nx][ny]=='.' || arr[nx][ny]== '-' )) {
                        nx += dx[d]; ny += dy[d];
                    }
                    if(0<=nx && nx<N && 0<=ny && ny<M) {
                        if(arr[nx][ny]=='*') arr[nx][ny] = '.';
                    }
                    continue;
                }
                else if(c=='U') d=0;
                else if(c=='R') d=1;
                else if(c=='D') d=2;
                else if(c=='L') d=3;
                nx = x + dx[d]; ny = y + dy[d];
                if(!(0<=nx && nx<N && 0<=ny && ny<M) || arr[nx][ny]!= '.' ) continue;
                else { x= nx; y = ny;}
            }
            char tmp;
            if(d==0) tmp='^';
            else if(d==1) tmp='>';
            else if(d==2) tmp='v';
            else tmp='<';
            arr[x][y]= tmp;
            ans.append("#"+tc+" ");
            for(int i=0; i<N; i++) {
                for(int j=0; j<M; j++) {
                    ans.append(arr[i][j]);
                }ans.append("\n");
            }
        }
        System.out.println(ans.toString());
    }
}