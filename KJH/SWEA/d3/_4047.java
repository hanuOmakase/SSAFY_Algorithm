package SWEA.d3;

import java.util.Scanner;
import java.io.FileInputStream;
import java.util.HashMap;
class _4047{
    public static void main(String args[]) throws Exception{
        Scanner sc = new Scanner(System.in);
        HashMap<Character, Integer > hashMap = new HashMap<Character, Integer>(){{
            put('S', 0);
            put('D', 1);
            put('H', 2);
            put('C', 3);
        }};
        int T = sc.nextInt();
        for (int test_case=1; test_case<=T; test_case+=1){
            String str = sc.next();
            int[] count = {13, 13, 13, 13};
            boolean[][] arr = new boolean[14][14];
            //Arrays.fill(arr, false);
            boolean is = false;
            for(int i=0; i<str.length(); i+=3){
                int row = hashMap.get(str.charAt(i));
                int col = Character.getNumericValue(str.charAt(i+1))*10 +
                        Character.getNumericValue(str.charAt(i+2));
                if(arr[row][col]) {
                    is = true;
                    break;
                } else{
                    arr[row][col] = true;
                    count[row] -= 1;
                }
            }
            if(is){
                System.out.printf("#%d ERROR\n",test_case);
            }
            else{
                System.out.printf("#%d %d %d %d %d\n",test_case,count[0],count[1],count[2],count[3]);
            }
        }
    }
}