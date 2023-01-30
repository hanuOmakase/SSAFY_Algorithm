package CKY.boj.excel;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _2999 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int row = str.length();
        int col = 1;
        int nRow = 0;
        int nCol = 0;

        for(int i = col; i <= str.length(); i++){
            int r = row % i;
            if(r == 0 && row/i <= i && row/i >= nRow){
                nRow = row/i;
                nCol = i;
            }
        }

        char[][] arr = new char[nRow][nCol];
        // 쓰기, 열 우선
        int idx = 0;
        for(int i = 0; i<nCol; i++){
            for(int j = 0; j<nRow; j++){
                arr[j][i] = str.charAt(idx++);
            }
        }

        // 읽기, 행 우선
        idx = 0;
        for(int i = 0; i<nRow; i++){
            for(int j = 0; j<nCol; j++){
                System.out.print(arr[i][j]);
            }
        }
    }
}
