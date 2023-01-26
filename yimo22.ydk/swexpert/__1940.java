
import java.util.*;
import java.io.*;
public class __1940 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc=0; tc<T; tc++) {
			int N = sc.nextInt();
			int dist = 0, v= 0;
			for(int i=0;i<N;i++) {
				int command = sc.nextInt();
				if(command == 0) {
					dist += v;
					continue;
				}
				
				int a = sc.nextInt();
				if(command == 1) {
					v += a;
				}
				else {
					v = (v - a) > 0 ? v-a : 0;
				}
				dist += v;
			}
			System.out.println("#" + (tc+1) + " " + dist);
			
		}
	}

}
