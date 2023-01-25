package swexpert;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class __4047 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		for (int tc = 0; tc < T; tc++) {
			String str = br.readLine();
			sb.append("#").append(tc+1).append(" ");
			int[][] cardSet = new int[4][14];
			for(int i=0;i<cardSet.length; i++) cardSet[i][0] = 1;
			boolean check = false;
			if(str.length() > 3 * 52) {
				sb.append("ERROR");
				continue;
			}
			for (int i = 0; i < str.length() / 3; i++) {
				char k = str.charAt(i * 3);
				int num = Integer.parseInt(str.substring(i * 3 + 1, i * 3 + 3));
				int offset = 0;
				switch (k) {
				case 'S':
					offset = 0;
					break;
				case 'D':
					offset = 1;
					break;
				case 'H':
					offset = 2;
					break;
				case 'C':
					offset = 3;
					break;
				default:
					break;
				}
				
				if(cardSet[offset][num] == 1) {
					sb.append("ERROR\n");
					check = true;
					break;
				}
				cardSet[offset][num] = 1;
			}
			if(check) continue;
			
			// checking
			for(int i=0;i<cardSet.length; i++) {
				int cnt = 0;
				for(int j=0;j<cardSet[i].length; j++) {
					if(cardSet[i][j] == 0) cnt++;
				}
				sb.append(cnt).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
