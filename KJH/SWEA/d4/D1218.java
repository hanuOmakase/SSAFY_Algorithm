package SWEA.d4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class D1218 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        HashMap<Character, int[]> map = new HashMap<Character, int[]>(){{
            put('(', new int[]{0, 1}); put(')', new int[]{0, -1});
            put('[', new int[]{1, 1}); put(']', new int[]{1, -1});
            put('{', new int[]{2, 1}); put('}', new int[]{2, -1});
            put('<', new int[]{3, 1}); put('>', new int[]{3, -1});
        }

        };
        for(int tc=1; tc<=T; tc++){
            int[] arr = {0, 0, 0, 0};
            String str = scanner.next();
            boolean is = true;
            for(int i=0; i<str.length(); i++){
                int[] temp = map.get(str.charAt(i));
                arr[temp[0]] += temp[1];
                if(arr[temp[0]] < 0){
                    is = false;
                    break;
                }
                if(!is){break;}
            }
            for(int i: arr){
                if(i != 0){
                    is = false;
                    break;
                }
            }
            if(is){System.out.printf("#%d %d\n",tc, 1);}
            else{System.out.printf("#%d %d\n",tc,0);}
        }
    }
}
