package BOJ;

import java.util.Scanner;

public class Main_17413 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char[] arr = new char[100000];
        int j = 0;
        boolean is = false;
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '<') {
                is = true;
                for (int k = j - 1; k >= 0; k--) {System.out.print(arr[k]);}
                j = 0;
            }
            if(is){
                System.out.print(str.charAt(i));
                if(str.charAt(i) == '>')
                    is = false;
                continue;
            }
            if (str.charAt(i) == ' ') {
                for (int k = j - 1; k >= 0; k--) {System.out.print(arr[k]);}System.out.print(" ");
                j = 0;
            } else {
                arr[j] = str.charAt(i);
                j++;
            }
        }
        for (int k = j - 1; k >= 0; k--) {
            System.out.print(arr[k]);
        }
    }
}
