package CKY.study._4;

import java.io.*;
import java.util.*;

public class 섬의개수 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int[][]arr;
    static int low;
    static int col;
    
    public static void main(String[] args) throws IOException {
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            col = Integer.parseInt(st.nextToken());
            low = Integer.parseInt(st.nextToken());
            if(col  == 0 && low == 0)
                break;

            arr = new int[low][col];

            int lowCount = low;
            int lows = 0;
            int cols = 0;
            while(lowCount --> 0){
                st = new StringTokenizer(br.readLine(), " ");
                while(st.hasMoreTokens()){
                    arr[lows][cols++] = Integer.parseInt(st.nextToken());
                }
                lows++;
                cols = 0;
            }

            int count = 0;
            for(int i = 0; i<arr.length; i++){
                for(int j = 0; j<arr[i].length; j++){
                    if(arr[i][j] == 1) {
                        bfs(i, j);
                        count++;
                    }
                }
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);

    }
    public static void bfs(int low1, int col1){
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(low1, col1));
        arr[low1][col1] = 2;
        int[] xrange = {1, -1, 0, 0 ,-1, -1, 1, 1};
        int[] yrange = {0, 0, 1, -1 , -1, 1, -1, 1};

        while(!q.isEmpty()){
            Point p  = q.poll();
            int x = p.x;
            int y = p.y;

            for(int i = 0; i<8; i++){
                int x1 = x + xrange[i];
                int y1 = y + yrange[i];
                if(x1 >= 0 && x1 < low && y1 >=0 && y1<col){
                    if(arr[x1][y1] == 1){
                        arr[x1][y1] = 2;
                        q.offer(new Point(x1, y1));
                    }
                }
            }
        }
    }
    
    static class Point{
        int x;
        int y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}