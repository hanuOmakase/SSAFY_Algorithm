package BOJ;

import java.io.*;
import java.util.*;

public class Main_5373 {
    static char[][][] cube = new char[6][3][3];
    static char[] alpa = {'w','y','r','o','g','b'};
    static HashMap<Character, Integer> dir = new HashMap(){{put('U', 0); put('D', 1); put('F', 2); put('B', 3); put('L', 4); put('R', 5);}};
    static void turn90(int m){
        char[][] tmp = new char[3][3];
        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                tmp[j][2-i] = cube[m][i][j];
            }
        }
        cube[m] = tmp;
    }
    // 전부 다 오른쪽으로 돌리자 , 왼쪽으로 돌리는거면 세번 돌리면 됨
    static void turn(int N){
        turn90(N); // 우선 해당 면을 90도 돌린다
        if( N==0 ){ // 윗면이면 주소이동 사용
            char[] tmp = cube[2][0]; cube[2][0] = cube[5][0]; cube[5][0] = cube[3][0]; cube[3][0] = cube[4][0]; cube[4][0] = tmp;
        }
        else if(N==1){ // 바닥면이여도 주소이동 사용
            turn90(N); turn90(N);
//            char[] tmp = cube[2][2]; cube[2][2] = cube[4][2]; cube[4][2] = cube[3][2]; cube[3][2] = cube[5][2]; cube[5][2] = tmp;
            char[] tmp = cube[2][2]; cube[2][2] = cube[4][2]; cube[4][2] = cube[3][2]; cube[3][2] = cube[5][2]; cube[5][2] = tmp;
        }
        else if(N==2){
            char[] tmp = new char[3];
            for(int i=0; i<3; i++) tmp[i] = cube[0][2][i];
            cube[0][2][0] = cube[4][2][2]; cube[0][2][1] = cube[4][1][2]; cube[0][2][2] = cube[4][0][2];
            cube[4][0][2]=cube[1][2][0]; cube[4][1][2]=cube[1][2][1]; cube[4][2][2] = cube[1][2][2];
            cube[1][2][0] = cube[5][2][0]; cube[1][2][1] = cube[5][1][0]; cube[1][2][2] = cube[5][0][0];
            cube[5][2][0]=tmp[2]; cube[5][1][0] = tmp[1]; cube[5][0][0] = tmp[0];
        }
        else if(N==3){
            char[] tmp = new char[3];
            for(int i=0; i<3; i++) tmp[i] = cube[0][0][i];
            cube[0][0][0] = cube[5][0][2]; cube[0][0][1] = cube[5][1][2]; cube[0][0][2] = cube[5][2][2];
            cube[5][0][2] = cube[1][0][2]; cube[5][1][2] = cube[1][0][1]; cube[5][2][2] = cube[1][0][0];
            cube[1][0][2] = cube[4][2][0]; cube[1][0][1] = cube[4][1][0]; cube[1][0][0] = cube[4][0][0];
            cube[4][0][0] = tmp[2]; cube[4][1][0] = tmp[1]; cube[4][2][0] = tmp[0];
        }
        else if(N==4){
            char[] tmp = new char[3];
            for(int i=0; i<3; i++) tmp[i] = cube[0][i][0];
            cube[0][0][0] = cube[3][2][2]; cube[0][1][0] = cube[3][1][2]; cube[0][2][0] = cube[3][0][2];
            cube[3][0][2] = cube[1][0][0]; cube[3][1][2] = cube[1][1][0]; cube[3][2][2] = cube[1][2][0];
            cube[1][0][0] = cube[2][2][0]; cube[1][1][0] = cube[2][1][0]; cube[1][2][0] = cube[2][0][0];
            cube[2][0][0] = tmp[0]; cube[2][1][0] = tmp[1]; cube[2][2][0] = tmp[2];
        }
        else if(N==5){
            char[] tmp = new char[3];
            for(int i=0; i<3; i++) tmp[i] = cube[0][i][2];
            cube[0][0][2] = cube[2][0][2]; cube[0][1][2] =  cube[2][1][2]; cube[0][2][2] = cube[2][2][2];
            cube[2][0][2] = cube[1][2][2]; cube[2][1][2] = cube[1][1][2]; cube[2][2][2] = cube[1][0][2];
            cube[1][2][2] = cube[3][2][0]; cube[1][1][2] = cube[3][1][0]; cube[1][0][2] = cube[3][0][0];
            cube[3][0][0] = tmp[2]; cube[3][1][0] = tmp[1]; cube[3][2][0] = tmp[0];
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int ind = 0, N, T = Integer.parseInt(bf.readLine());
        String tmp;
        Character m, t;
        for(int O=0; O<T; O++){
            for (int i=0; i<6; i++) for (int j=0; j<3; j++) for (int k=0; k<3; k++) cube[i][j][k] = alpa[i];
            N = Integer.parseInt(bf.readLine());
            st = new StringTokenizer(bf.readLine());
            for(int i=0; i<N; i++){
                tmp = st.nextToken();
                m = tmp.charAt(0); t = tmp.charAt(1);
                turn(dir.get(m));
                if(t=='-'){turn(dir.get(m)); turn(dir.get(m));}
            }
            for(int i=0; i<3; i++){
                for(int j=0; j<3; j++){
                    sb.append(cube[0][i][j]);
                }sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}
