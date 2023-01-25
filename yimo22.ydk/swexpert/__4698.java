package swexpert;
import java.io.InputStreamReader;
import java.io.*;
import java.util.*;
public class __4698 {
	
	static boolean[] number = new boolean[1000000+1];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		init();
		for(int tc=0; tc<T; tc++) {
			int D, A, B;
			StringTokenizer st = new StringTokenizer(br.readLine());
			D = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			
			int cnt =0;
			for(int i=A; i<=B; i++) {
				if(number[i]) {
					// D가 들어가는 수인지 확인
					if(Integer.toString(i).contains(Integer.toString(D))) cnt++;
				}
			}
			System.out.printf("#%d %d\n", tc+1, cnt);
		}
	}

	private static void init() {
		// TODO Auto-generated method stub
		Arrays.fill(number, true);
		
		number[0] = false;
		number[1] = false;
		for(int i=2; i<Math.sqrt(number.length); i++) {
			if(number[i]) {
				for(int j=i + i; j<number.length;j+=i) {
					number[j] = false;
				}
			}
		}
	}
}
