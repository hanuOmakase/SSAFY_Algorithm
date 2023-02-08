package BOJ;

import java.util.Scanner;

public class Main_2941 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] li = {"c=","c-","dz=","d-","lj","nj","s=","z="};
        String str = sc.nextLine();
        for(int i=0; i<8; i++){if(str.contains(li[i])) str = str.replaceAll(li[i],"0");}
        System.out.println(str.length());
    }
}
