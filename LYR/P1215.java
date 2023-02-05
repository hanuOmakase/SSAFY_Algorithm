package SWEA;

import java.util.Scanner;

public class P1215 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int tc = 1; tc <= 10; tc++){
            int N = sc.nextInt();

            //글자판 초기화 & 입력
            char[][] board = new char [8][8];
            for(int i = 0; i < 8; i++){
                String tmp = sc.next();
                for(int j = 0; j < 8; j++){
                    board[i][j] = tmp.charAt(j);
                }
            }

            int result = 0;

            for(int i = 0; i < 8; i++){ // 가로 탐색
                for(int j = 0; j <= (8 - N); j++){
                    int left = j;
                    int right = (j + N) - 1;
                    boolean isPalin = true;
                    while(left < right){
                        if(board[i][left] != board[i][right]){
                            isPalin = false;
                            break;
                        }
                        else{
                            left++;
                            right--;
                        }
                    }
                    if(isPalin) result++;
                }
            }

            for(int j = 0; j < 8; j++){ // 세로 탐색
                for(int i = 0; i <= (8 - N); i++){
                    int left = i;
                    int right = (i + N) - 1;
                    boolean isPalin = true;
                    while(left < right){
                        if(board[left][j] != board[right][j]){
                            isPalin = false;
                            break;
                        }
                        else {
                            left++;
                            right--;
                        }
                    }
                    if(isPalin) result++;
                }
            }

            System.out.println("#" + tc + " " + result);
        }
        sc.close();
    }
}
